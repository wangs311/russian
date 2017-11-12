package com.bluemsun.service.Examination;

import com.bluemsun.common.entitys.QuestionsType;
import com.bluemsun.dao.Examination.QuestionsDao;
import com.bluemsun.dao.Examination.QuestionsTypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @author: Dongsl161
 * @Date: 2017/8/28 17:34
 */
@Service
public class QuestionsTypeService {
    
    @Autowired
    private QuestionsTypeDao questionsTypeDao;

    @Autowired
    private QuestionsDao questionsDao;
    
    
    /**
    * @Description: 添加一种题型
    * @Date: 2017/8/28 17:35
    */
    public void addQuestionsType(String questionsType) {
        questionsTypeDao.addQuestionsType(questionsType);
    }
    
    
    /**
    * @Description: 查看所有题型
    * @Date: 2017/8/28 17:36
    */
    public List<QuestionsType> selectAllQuestionsType() {
        List<QuestionsType> list = questionsTypeDao.selectAllQuestion();
        return list;
    }


    /**
    * @Description: 删除一种题型
    * @Date: 2017/8/28 17:38
    */
    public void deleteQuestionsType(String id) {
        questionsTypeDao.deleteQuestionsType(id);
        List<String> list = questionsDao.selectQuestionsByType(id);
        for(int i = 0; i < list.size(); i++) {
            questionsDao.deleteQuestions(list.get(i));
        }
    }


    /**
    * @Description: 根据大题id查询其题型
    * @Date: 2017/10/9 14:37
    */
    public QuestionsType selectById(String id) {
        return questionsTypeDao.selectById(id);
    }

    
}
