package Examination;

import com.bluemsun.common.entitys.Examination;
import com.bluemsun.common.vo.ExaminationVo;
import com.bluemsun.service.Examination.ExaminationService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @author: Dongsl161
 * @Date: 2017/9/12 19:26
 */
public class ExaminationServiceTest {

    private ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
    private ExaminationService examinationService = (ExaminationService) ctx.getBean("examinationService");

    @Test
    public void addExamination() throws Exception {
        Examination examination = new Examination();
        examination.setQuestionsId("e4565722-33fe-48f0-ad5c-6530af4695d2#" +
                "226367b3-2e6d-47d3-a89d-ffec6db6b7e6#" +
                "b68d290e-478f-420c-b481-8c0e9d26ac79#" +
                "d0ad09b2-8de3-4b81-9b15-09379dbcb182#" +
                "7c2f7cad-203f-465b-af0a-5c026ee7ff2d");
        examination.setUnitId("e5f07a50-8e35-4638-a8e4-ac7faad88d65");
        examinationService.addExamination(examination);
    }

    @Test
    public void deleteExamination() throws Exception {
        examinationService.deleteExamination("312a4faf-2f4d-456a-bddf-fdc13562278e");
    }

    @Test
    public void selectExamination() throws Exception {
        ExaminationVo examinationVo = examinationService.selectExamination("be4e6440-a2b1-4aa5-808e-2da1a51c5b61");
        System.out.println(Arrays.asList(examinationVo.getQuestionsList()));
    }

    @Test
    public void selectAllExamination() throws Exception {
        List<ExaminationVo> list = examinationService.selectAllExamination("e5f07a50-8e35-4638-a8e4-ac7faad88d65");
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getExaminationName());
        }
    }

}