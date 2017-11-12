package com.bluemsun.service.Examination;

import com.bluemsun.common.entitys.FinishAnswer;
import com.bluemsun.common.entitys.Question;
import com.bluemsun.common.entitys.Questions;
import com.bluemsun.common.vo.QuestionVo;
import com.bluemsun.common.vo.QuestionsVo;
import com.bluemsun.dao.Examination.FinishAnswerDao;
import com.bluemsun.dao.Examination.QuestionDao;
import com.bluemsun.dao.Examination.QuestionsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description:
 * @author: Dongsl161
 * @Date: 2017/8/29 15:01
 */
@Service
public class QuestionsService {

    @Autowired
    private QuestionsDao questionsDao;

    @Autowired
    private QuestionDao questionDao;

    @Autowired
    private FinishAnswerDao finishAnswerDao;


    /**
    * @Description: 添加一道大题和对应小题
    * @Date: 2017/8/29 15:05
    */
    @Transactional
    public void addQuestions(QuestionsVo questionsVo, List<Question> questionList) {
        Questions questions = new Questions();
        questions.setQuestionsTitle(questionsVo.getQuestionsTitle());
        questions.setQuestionsArticle(questionsVo.getQuestionsArticle());
        questions.setQuestionsTypeId(questionsVo.getQuestionsTypeId());
        questions.setUnitId(questionsVo.getUnitId());




        int mark = questionList.get(0).getQuestionMark() * questionList.size();
        questions.setQuestionsMark(mark);
        String questionsId = questionsDao.addQuestions(questions);
        for(int i = 0; i < questionList.size(); i++) {
            questionList.get(i).setQuestionsId(questionsId);
            questionDao.addQuestion(questionList.get(i));
        }
    }


    /**
    * @Description: 删除一道大题
    * @Date: 2017/8/29 15:56
    */
    public void deleteQuestions(String id) {
        questionsDao.deleteQuestions(id);
        List<QuestionVo> list = questionDao.selectAllQuestion(id);
        for(int i = 0; i < list.size(); i++) {
            questionDao.deleteQuestion(list.get(i).getId());
        }
    }


    /**
    * @Description: 根据单元和题型查询出对应大题
    * @Date: 2017/8/29 16:00
    */
    public List<QuestionsVo> selectQuestionsByUnitAndType(String unitId, String questionsTypeId) {
        List<QuestionsVo> questionsList = questionsDao.selectQuestionsByUnitAndType(unitId, questionsTypeId);
        for(int i = 0; i < questionsList.size(); i++) {
            QuestionsVo questionsVo = questionsList.get(i);
            List<QuestionVo> list = questionDao.selectAllQuestion(questionsVo.getId());
//            for(int j = 0; j < list.size(); j++) {
//                list.get(j).setOutline(list.get(j).getQuestionOutline().split("#"));
//                if(finishExaminationId != null) {
//                    FinishAnswer finishAnswer = finishAnswerDao.selectOneFinAns(list.get(i).getId(), finishExaminationId);
//                    list.get(i).setFinishAnswer(finishAnswer);
//                }
//            }
            questionsList.get(i).setQuestionList(list);
        }
        return questionsList;
    }


    /**
    * @Description: 根据id查询出一道大题
    * @Date: 2017/8/29 16:16
    */
    public QuestionsVo selectQuestionsById(String id, String finishExaminationId) {
        QuestionsVo questionsVo = questionsDao.selectQuestionsVoById(id);
        List<QuestionVo> list = questionDao.selectAllQuestion(questionsVo.getId());
        for(int i = 0; i < list.size(); i++) {
            list.get(i).setOutline(list.get(i).getQuestionOutline().split("#"));
            if(finishExaminationId != null) {
                FinishAnswer finishAnswer = finishAnswerDao.selectOneFinAns(list.get(i).getId(), finishExaminationId);
                list.get(i).setFinishAnswer(finishAnswer);
            }
        }
        questionsVo.setQuestionList(list);
        return questionsVo;
    }


}
