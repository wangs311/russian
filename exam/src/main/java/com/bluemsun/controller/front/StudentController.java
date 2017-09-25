package com.bluemsun.controller.front;

import com.bluemsun.common.core.Pages;
import com.bluemsun.common.entitys.Student;
import com.bluemsun.service.User.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Description:
 * @author: Dongsl161
 * @Date: 2017/9/18 18:47
 */
@Controller
@RequestMapping("/studentController")
public class StudentController {

    @Autowired
    private StudentService studentService;


    /**
    * @Description: 学生登录
    * @Date: 2017/9/18 18:51
    */
    @RequestMapping("/login")
    public String login(Student student, HttpSession session) throws IOException {
        if(studentService.checkLogin(student.getStudentNumber(), student.getStudentPassword())) {
            session.setAttribute("student", student);
            return Pages.FRONTINDEX;
        }
        return "redirect:/login.jsp";
    }


    /**
    * @Description: 退出登录
    * @Date: 2017/9/19 14:56
    */
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("student");
        return "redirect:/login.jsp";
    }


}
