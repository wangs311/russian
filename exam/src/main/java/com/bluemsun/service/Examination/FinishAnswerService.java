package com.bluemsun.service.Examination;

import com.bluemsun.common.entitys.FinishAnswer;
import com.bluemsun.dao.Examination.FinishAnswerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @author: Dongsl161
 * @Date: 2017/9/15 19:15
 */
@Service
public class FinishAnswerService {

    @Autowired
    private FinishAnswerDao finishAnswerDao;


    /**
    * @Description: 插入一条记录
    * @Date: 2017/9/15 19:16
    */
    public void addFinishAnswer(FinishAnswer finishAnswer) {
        finishAnswerDao.addFinishAnswer(finishAnswer);
    }


    /**
    * @Description: 修改分数
    * @Date: 2017/9/15 19:17
    */
    public void updateMark(String id, int mark) {
        finishAnswerDao.updateMark(id, mark);
    }



}
