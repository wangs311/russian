package com.bluemsun.service.User;

import com.bluemsun.common.entitys.Student;
import com.bluemsun.dao.Message.MessageDao;
import com.bluemsun.dao.User.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 学生用户的Service
 * @author: Dongsl161
 * @Date: 2017/8/14 13:37
 */
@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private MessageDao messageDao;
    
    
    /**
    * @Description:  添加一个学生用户
    * @Date: 2017/8/14 16:59
    */
    public void addStudent(Student student) {
        studentDao.addStudent(student);
    }
    
    
    /**
    * @Description: 删除一个学生用户
    * @Date: 2017/8/14 17:03
    */
    public void deleteStudent(String id) {
        studentDao.deleteStudent(id);
    }


    /**
    * @Description:  根据用户名密码检查学生用户登录
    * @Date: 2017/8/14 18:30
    */
    public boolean checkLogin(String studentNumber, String studentPassword) {
        boolean flag = false;
        Student student = studentDao.selectOneStudent(studentNumber, studentPassword);
        if(student != null)
            flag = true;
        return flag;
    }



    /**
    * @Description: 查询出所有的学生用户
    * @Date: 2017/8/14 18:39
    */
    public List<Student> selectAllStudent() {
        List<Student> list = studentDao.selectAllStudent();
        return  list;
    }

    


}
