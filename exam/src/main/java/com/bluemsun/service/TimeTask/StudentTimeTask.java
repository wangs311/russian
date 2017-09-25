package com.bluemsun.service.TimeTask;

import com.bluemsun.common.entitys.Student;
import com.bluemsun.dao.User.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

/**
 * @Description: 关于学生用户的定时任务
 * @author: Dongsl161
 * @Date: 2017/8/14 15:41
 */
@Service
public class StudentTimeTask {

    @Autowired
    private StudentDao studentDao;

    /**
    * @Description: 定时地检查学生账号是否过期
    * @Date: 2017/8/14 15:43
    */
    public void updateStudentIsDelete() {
        List<Student> list = studentDao.selectAllStudent();
        // 获取当前年份及月份
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        for (int i = 0; i < list.size(); i++) {
            // 计算学生是否已经毕业
            int grade = Integer.parseInt(list.get(i).getStudentGrade());
            int sub = year - grade;
            if(sub == 4 && month == 6) {
                studentDao.updateStudentPower(list.get(i).getId());
            }
        }
    }



}
