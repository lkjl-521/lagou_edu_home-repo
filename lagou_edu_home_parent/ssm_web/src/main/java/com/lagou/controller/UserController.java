package com.lagou.controller;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.ResponseResult;
import com.lagou.domain.Role;
import com.lagou.domain.User;
import com.lagou.domain.UserVO;
import com.lagou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author lkjl_java
 * @Description:
 * @date 2021/4/2 - 18:39
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /*
        分页显示&多条件查询
     */
    @RequestMapping("/findAllUserByPage")
    public ResponseResult findAllUserByPage(@RequestBody UserVO userVO) {
        PageInfo pageInfo = userService.findAllUserByPage(userVO);
        return  new ResponseResult(true, 200, "多条件查询成功",pageInfo);
    }

    /*
        用户登录（根据用户名查询具体信息）
     */
    @RequestMapping("/login")
    public ResponseResult login(User user, HttpServletRequest request) throws Exception {
        User user1 = userService.login(user);

        if (user1 != null) {
            // 保存用户id及access_token到session中
            HttpSession session = request.getSession();
            String access_token = UUID.randomUUID().toString();
            session.setAttribute("access_token",access_token);
            session.setAttribute("user_id",user1.getId());

            // 将查询出来的信息响应给前台
            Map<String, Object> map = new HashMap<>();
            map.put("access_token",access_token);
            map.put("user_id",user1.getId());
            // 将查询出来的user，也存到map中
            map.put("user",user1);

            return new ResponseResult(true, 1, "登录成功", map);
        } else {
            return new ResponseResult(true, 400, "用户名密码错误", null);
        }
    }

    /*
        分配角色回显
     */
    @RequestMapping("/findUserRoleById")
    public ResponseResult findUserRelationRoleById(Integer id) {
        List<Role> roleList = userService.findUserRelationRoleById(id);

        return new ResponseResult(true, 200, "分配角色回显成功",roleList);
    }

    /*
           分配角色
     */
    @RequestMapping("/userContextRole")
    public ResponseResult userContextRole(@RequestBody UserVO userVO) {
        userService.userContextRole(userVO);

        return  new ResponseResult(true, 200, "分配角色成功", null);
    }

    /*
           获取用户权限，进行动态展示
     */
    @RequestMapping("/getUserPermissions")
    public ResponseResult getUserPermissions(HttpServletRequest request) {

        // 1. 获取请求头中的token
        String headerToken = request.getHeader("Authorization");

        // 2. 获取session中的token
        String sessionToken = (String) request.getSession().getAttribute("access_token");
        
        // 3. 判断token是否一致
        if (headerToken.equals(sessionToken)) {
            // 获取用户id
            Integer user_id = (Integer) request.getSession().getAttribute("user_id");
            return userService.getUserPermissions(user_id);
        } else {
            return  new ResponseResult(false, 400, "获取菜单信息失败", null);
        }

    }
}
