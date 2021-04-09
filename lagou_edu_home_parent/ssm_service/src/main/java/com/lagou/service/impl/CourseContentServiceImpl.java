package com.lagou.service.impl;

import com.lagou.dao.CourseContentMapper;
import com.lagou.domain.Course;
import com.lagou.domain.CourseLesson;
import com.lagou.domain.CourseSection;
import com.lagou.service.CourseContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author lkjl_java
 * @Description:
 * @date 2021/4/2 - 9:25
 */
@Service
public class CourseContentServiceImpl implements CourseContentService {

    @Autowired
    private CourseContentMapper courseContentMapper;

    @Override
    public List<CourseSection> findSectionAndLessonByCourseId(Integer courseId) {
        return courseContentMapper.findSectionAndLessonByCourseId(courseId);
    }

    @Override
    public Course findCourseByCourseId(Integer courseId) {
        return courseContentMapper.findCourseByCourseId(courseId);
    }

    @Override
    public void saveSection(CourseSection courseSection) {
        // 补全信息
        Date date = new Date();
        courseSection.setCreateTime(date);
        courseSection.setUpdateTime(date);

        // 保存
        courseContentMapper.saveSection(courseSection);
    }

    @Override
    public void updateSection(CourseSection courseSection) {
        // 补全信息
        courseSection.setUpdateTime(new Date());

        // 调用dao
        courseContentMapper.updateSection(courseSection);
    }

    @Override
    public void updateSectionStatus(int id, int status) {
        CourseSection cs = new CourseSection();
        cs.setId(id);
        cs.setStatus(status);
        cs.setUpdateTime(new Date());

        courseContentMapper.updateSectionStatus(cs);
    }

    @Override
    public void saveLesson(CourseLesson courseLesson) {
        Date date = new Date();
        courseLesson.setCreateTime(date);
        courseLesson.setUpdateTime(date);
        courseContentMapper.saveLesson(courseLesson);
    }

    @Override
    public void updateLesson(CourseLesson courseLesson) {
        courseLesson.setUpdateTime(new Date());

        courseContentMapper.updateLesson(courseLesson);
    }

    @Override
    public void updateLessonStatus(int id, int status) {
        CourseLesson courseLesson = new CourseLesson();
        courseLesson.setId(id);
        courseLesson.setStatus(status);
        courseLesson.setUpdateTime(new Date());

        courseContentMapper.updateLessonStatus(courseLesson);
    }
}
