package com.lagou.utils;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lkjl_java
 * @Description:
 * @date 2021/4/2 - 14:08
 */
public class FileUploadUtils {

    /*
         图片上传
     */
    public static Map<String, String> fileUpload(MultipartFile file, HttpServletRequest request) throws IOException {
        // 1. 判断接收到的上传文件是否为空
        if (file.isEmpty()) {
            throw new RuntimeException();
        }

        // 2. 获取项目部署路径
        // realPath: ...\apache-tomcat-8.5.56\webapps\ssm-web
        String realPath = request.getServletContext().getRealPath("/");
        // 截取webapps目录，方便将上传文件存储到自定义的服务器路径
        String substring = realPath.substring(0, realPath.indexOf(request.getServletContext().getContextPath().replace("/", "")));

        // 3. 获取原文件名
        String originalFilename = file.getOriginalFilename();
        // 生成新文件名
        String newFilename = System.currentTimeMillis() + originalFilename.substring(originalFilename.lastIndexOf("."));

        // 4. 文件上传
        String uploadPath = substring + "upload\\";
        File filePath = new File(uploadPath, newFilename);

        // 5. 如果目录不存在就创建目录
        if (!filePath.getParentFile().exists()) {
            filePath.getParentFile().mkdirs();  // mkdirs() => 创建多层目录

            System.out.println("创建目录：" + filePath);
        }

        //  6. 文件实现真正上传
        file.transferTo(filePath);

       /* System.out.println("===================");
        // java是允许在注释以及代码中使用"\ u"开头的Unicode转义字符的，但是要求转义必须有效，否则编译器会报告错误。（注释包含单行，多行，文档注释）。
        System.out.println(filePath.getParentFile());  // D:\Program Files\apache-tomcat-8.5.55\webapps\ upload
        System.out.println(filePath);  // D:\Program Files\apache-tomcat-8.5.55\webapps\ upload\1617196763769.jpg
        System.out.println(request.getContextPath());  // /ssm_web
        System.out.println(request.getServletPath());  // /course/courseUpload
        System.out.println(realPath);  // D:\Program Files\apache-tomcat-8.5.55\webapps\ssm_web\
        System.out.println("======================");*/

        // 7. 将文件名和文件路径返回，进行响应
        Map<String, String> map = new HashMap<>();
        map.put("fileName",newFilename);
        map.put("filePath","http://localhost:8080/upload/" + newFilename);

        return map;
    }
}
