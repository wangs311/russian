package Examination;

import com.bluemsun.common.entitys.QuestionsType;
import com.bluemsun.service.Examination.QuestionsTypeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @Description:
 * @author: Dongsl161
 * @Date: 2017/8/28 17:39
 */
public class QuestionsTypeServiceTest {

    private ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
    private QuestionsTypeService questionsTypeService = (QuestionsTypeService) ctx.getBean("questionsTypeService");


    @Test
    public void addQuestionsType() throws Exception {
        String questionsType = "造句";
        questionsTypeService.addQuestionsType(questionsType);
    }

    @Test
    public void selectAllQuestionsType() throws Exception {
        List<QuestionsType> list = questionsTypeService.selectAllQuestionsType();
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getQuestionsTypeName());
        }
    }

    @Test
    public void deleteQuestionsType() throws Exception {
        questionsTypeService.deleteQuestionsType("d0bdff6a-2efb-4ec6-8e3f-e7ccc1db6542");
    }

}