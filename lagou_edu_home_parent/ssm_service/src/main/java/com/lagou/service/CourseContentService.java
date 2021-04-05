package com.lagou.service;

import com.lagou.domain.Course;
import com.lagou.domain.CourseSection;

import java.util.List;

/**
 * @author lkjl_java
 * @Description:
 * @date 2021/4/2 - 9:24
 */
public interface CourseContentService {
    /*
         根据课程id查询关联的章节信息和课时信息
     */
    public List<CourseSection> findSectionAndLessonByCourseId(Integer courseId);

    /*
        回显章节对应的课程信息
     */
    public Course findCourseByCourseId(Integer courseId);

    /*
        添加章节信息
     */
    public void saveSection(CourseSection courseSection);

    /*
        修改章节信息
     */
    public void updateSection(CourseSection courseSection);

    /*
        修改章节状态
     */
    public void updateSectionStatus(int id, int status);
}
