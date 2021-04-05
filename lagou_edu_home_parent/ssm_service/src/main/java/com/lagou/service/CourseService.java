package com.lagou.service;

import com.lagou.domain.Course;
import com.lagou.domain.CourseVO;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * @author lkjl_java
 * @Description:
 * @date 2021/3/31 - 18:35
 */
public interface CourseService {
    /*
        多条件查询课程列表
     */
    public List<Course> findCourseByCondition(CourseVO courseVO);

    /*
        添加课程及讲师信息
     */
    public void saveCourseAndTeacher(CourseVO courseVO) throws InvocationTargetException, IllegalAccessException;
    /*
        回显课程信息
     */

    public CourseVO findCourseById(Integer id);

    /*
        修改课程信息
     */
    public void updateCourseAndTeacher(CourseVO courseVO) throws InvocationTargetException, IllegalAccessException;

    /*
        课程状态变更
     */
    public void updateCourseStatus(int CourseId, int status);

}
