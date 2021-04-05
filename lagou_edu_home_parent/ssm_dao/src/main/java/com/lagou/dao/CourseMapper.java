package com.lagou.dao;

import com.lagou.domain.Course;
import com.lagou.domain.CourseVO;
import com.lagou.domain.Teacher;

import java.util.List;

/**
 * @author lkjl_java
 * @Description:
 * @date 2021/3/31 - 18:22
 */
public interface CourseMapper {

    /*
        多条件课程查询
     */
    public List<Course> findCourseByCondition(CourseVO courseVO);

    /*
        新增课程信息
     */
    public void saveCourse(Course course);

    /*
        新增讲师信息
     */
    public void saveTeacher(Teacher teacher);

    /*
        回显课程信息（根据id回显课程信息和相关的讲师信息）
     */
    public CourseVO findCourseById(Integer id);

    /*
        更新课程信息
     */
    public void updateCourse(Course course);

    /*
        更新讲师信息
     */
    public void updateTeacher(Teacher teacher);

    /*
        更改课程状态
     */
    public void updateCourseStatus(Course course);


}
