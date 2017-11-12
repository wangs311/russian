package com.bluemsun.controller.back;

import com.bluemsun.common.core.Pages;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description:
 * @author: Dongsl161
 * @Date: 2017/10/12 14:03
 */
@Controller
@RequestMapping("/backIndexController")
public class BackIndexController {

    /**
    * @Description: 跳转到欢迎首页
    * @Date: 2017/10/12 14:03
    */
    @RequestMapping("/toWelcome")
    public String toWelcome() {
        return Pages.BACKWELCOME;
    }


    /**
    * @Description: 跳转到出题页
    * @Date: 2017/10/12 14:27
    */
    @RequestMapping("/toMakeQuestions")
    public String toMakeQuestions() {
        return Pages.BACKQUESTIONS;
    }


    /**
    * @Description: 跳转到出卷页
    * @Date: 2017/10/13 14:15
    */
    @RequestMapping("toMakePaper")
    public String toMakePaper() {
        return Pages.BACKPAPER;
    }


    /**
    * @Description: 跳转到判卷页面
    * @Date: 2017/10/15 11:59
    */
    @RequestMapping("toCheckPaper")
    public String toCheckPaper() {
        return Pages.BACKCHECK;
    }


    /**
    * @Description: 跳转到详细判卷页面
    * @Date: 2017/10/15 13:42
    */
    @RequestMapping("toStudentPaper")
    public String toStudentPaper(String examinationIda, String ida, HttpServletRequest request) {
        request.setAttribute("examinationId", examinationIda);
        request.setAttribute("id", ida);
        return Pages.BACKSTUDENTPAPER;
    }


    @RequestMapping("toDeleteQuestions")
    public String toDeleteQuestions() {
        return Pages.BACKDELETE;
    }






}
