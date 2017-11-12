package com.bluemsun.service.User;

import com.bluemsun.common.entitys.Teacher;
import com.bluemsun.dao.User.TeacherDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @author: Dongsl161
 * @Date: 2017/9/30 18:11
 */
@Service
public class TeacherService {

    @Autowired
    private TeacherDao teacherDao;


    /**
    * @Description: 添加老师
    * @Date: 2017/10/12 13:31
    */
    public void addTeacher(Teacher teacher) {
        teacherDao.addTeacher(teacher);
    }


    /**
    * @Description: 检查一个教室用户
    * @Date: 2017/9/30 18:12
    */
    public Teacher selectOneTeacher(String teacherNumber, String teacherPassword) {
        Teacher teacher = teacherDao.selectOneTeacher(teacherNumber, teacherPassword);
        return teacher;
    }

}
