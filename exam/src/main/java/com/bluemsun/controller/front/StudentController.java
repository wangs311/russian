package com.bluemsun.controller.front;

import com.bluemsun.common.core.Pages;
import com.bluemsun.common.entitys.Student;
import com.bluemsun.service.User.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
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
            Student studentDetail = studentService.selectByNum(student.getStudentNumber(), student.getStudentPassword());
            session.setAttribute("student", studentDetail);
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


    /**
    * @Description: 进入学生个人中心
    * @Date: 2017/9/28 16:56
    */
    @RequestMapping("/toPersonal")
    public String toPersonal() {
        return Pages.FRONTPERSONAL;
    }

    /**
     * @Description: 学生做过试卷的具体页面
     * @Date: 2017/10/16 18:59
     */
    @RequestMapping("toChecking")
    public String toChecking(String examinationIda, String ida, HttpServletRequest request) {
        request.setAttribute("examinationId", examinationIda);
        request.setAttribute("id", ida);
        return Pages.FRONTCHECKING;
    }


}
