package com.bluemsun.controller.back;

import com.bluemsun.common.core.Pages;
import com.bluemsun.common.entitys.Teacher;
import com.bluemsun.service.User.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @Description: 教师角色的控制器
 * @author: Dongsl161
 * @Date: 2017/10/12 12:30
 */
@Controller
@RequestMapping("/backTeacherController")
public class BackTeacherController {

    @Autowired
    private TeacherService teacherService;


    /**
    * @Description: 老师登录
    * @Date: 2017/10/12 12:59
    */
    @RequestMapping("/login")
    public String login(String teacherNumber, String teacherPassword, HttpSession session) {
        Teacher teacher = teacherService.selectOneTeacher(teacherNumber, teacherPassword);
        if(teacher != null) {
            session.setAttribute("teacher", teacher);
            return Pages.BACKINDEX;
        }
        return "redirect:/loginBack.jsp";
    }



}
