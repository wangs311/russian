package Examination;

import com.bluemsun.common.entitys.Question;
import com.bluemsun.common.vo.QuestionsVo;
import com.bluemsun.service.Examination.QuestionsService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @author: Dongsl161
 * @Date: 2017/8/29 17:19
 */
public class QuestionsServiceTest {

    private ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
    private QuestionsService questionsService = (QuestionsService)ctx.getBean("questionsService");

    @Test
    public void addQuestions() throws Exception {
        QuestionsVo questions = new QuestionsVo();
        questions.setQuestionsTitle("造句。造个屁");
        questions.setQuestionsTypeId("07c14a5d-5759-421e-9434-cc4bcc9444e8");
        questions.setUnitId("14e12df5-84ee-480d-a82b-55ec8c3329c7");
        // questions.setQuestionsArticle("这是完型填空的文章");
        List<Question> questionList = new ArrayList<Question>();
        for(int i = 0; i < 5; i++) {
            Question question = new Question();
            question.setQuestionOutline("吃屁" + i);
            question.setQuestionAnswer("答案" + i);
            question.setQuestionAnalysis("解析" + i);
            question.setQuestionMark(2);
            question.setQuestionNumber(i);
            questionList.add(question);
        }
        questionsService.addQuestions(questions, questionList);
    }

    @Test
    public void deleteQuestions() throws Exception {
        questionsService.deleteQuestions("35533b26-d5e8-487b-a03f-69fab37dd7e0");
    }

//    @Test
//    public void selectQuestionsByUnitAndType() throws Exception {
//        List<QuestionsVo> list = questionsService.selectQuestionsByUnitAndType("14e12df5-84ee-480d-a82b-55ec8c3329c7", "517ada9e-465c-4c78-9551-9bfe52e4d1a6");
//        for(int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i).getQuestionsTitle() + "--" + list.get(i).getQuestionsArticle());
//            List<QuestionVo> questionVoList = list.get(i).getQuestionList();
//            for(int j = 0; j < questionVoList.size(); j++) {
//                System.out.println("    " + Arrays.toString(questionVoList.get(j).getOutline()));
//                System.out.println("    " + questionVoList.get(j).getQuestionAnswer() + "--" + questionVoList.get(j).getQuestionAnalysis());
//            }
//        }
//    }

//    @Test
//    public void selectQuestionsById() throws Exception {
//        QuestionsVo questionsVo = questionsService.selectQuestionsById("226367b3-2e6d-47d3-a89d-ffec6db6b7e6");
//        System.out.println(questionsVo.getQuestionsTitle() + "--" + questionsVo.getQuestionsArticle());
//        List<QuestionVo> questionVoList = questionsVo.getQuestionList();
//        for(int j = 0; j < questionVoList.size(); j++) {
//            System.out.println("    " + Arrays.toString(questionVoList.get(j).getOutline()));
//            System.out.println("    " + questionVoList.get(j).getQuestionAnswer() + "--" + questionVoList.get(j).getQuestionAnalysis());
//        }
//    }

}