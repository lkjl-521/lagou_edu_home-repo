package com.lagou.controller;

import com.lagou.domain.Course;
import com.lagou.domain.CourseVO;
import com.lagou.domain.ResponseResult;
import com.lagou.service.CourseService;
import com.lagou.utils.FileUploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lkjl_java
 * @Description:
 * @date 2021/3/31 - 18:39
 */
@RestController
@RequestMapping("/course")
public class CourseController {


    @Autowired
    private CourseService courseService;

    /*
           多条件查询课程列表信息
     */
    @RequestMapping("/findCourseByCondition")
    public ResponseResult findCourseByCondition(@RequestBody CourseVO courseVO) {
        
        // 调用service
        List<Course> list = courseService.findCourseByCondition(courseVO);

        ResponseResult responseResult = new ResponseResult(true, 200, "响应成功", list);

        return responseResult;
    }

    /*
         课程图片上传
     */
    @RequestMapping("/courseUpload")
    public ResponseResult fileUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
        Map<String, String> map = FileUploadUtils.fileUpload(file, request);

        ResponseResult result = new ResponseResult(true, 200, "响应成功", map);

        return result;
    }

    /*
        新增课程信息和讲师信息
        新增和修改写在同一个方法中
     */
    @RequestMapping("/saveOrUpdateCourse")
    public ResponseResult saveOrUpdateCourse(@RequestBody CourseVO courseVO) throws InvocationTargetException, IllegalAccessException {

        ResponseResult responseResult;
        if (courseVO.getId() == null) {
            // 调用service
            courseService.saveCourseAndTeacher(courseVO);
            responseResult = new ResponseResult(true, 200, "新增成功", null);
        } else {
            courseService.updateCourseAndTeacher(courseVO);
            responseResult = new ResponseResult(true, 200, "修改成功", null);
        }

        return responseResult;
    }

    /*
        回显课程信息：根据id查询课程信息及相关的讲师信息
     */
    @RequestMapping("/findCourseById")
    public ResponseResult findCourseById(Integer id) {
        CourseVO courseVo = courseService.findCourseById(id);


        return new ResponseResult(true, 200, "响应成功" , courseVo);
    }

    /*
        更新课程状态
     */
    @RequestMapping("/updateCourseStatus")
    public ResponseResult updateCourseStatus(Integer id, Integer status) {
        // 调用service
        courseService.updateCourseStatus(id, status);

        // 响应数据
        Map<String, Object> map = new HashMap<>();
        map.put("status",status);

        ResponseResult responseResult = new ResponseResult(true, 200, "课程状态更新成功", map);
        return responseResult;
    }


}
