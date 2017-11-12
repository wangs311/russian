package Examination;

import com.bluemsun.common.entitys.FinishExamination;
import com.bluemsun.common.vo.FinishExaminationVo;
import com.bluemsun.service.Examination.FinishExaminationService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @author: Dongsl161
 * @Date: 2017/9/13 19:48
 */
public class FinishExaminationServiceTest {

    private ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
    private FinishExaminationService finishExaminationService = (FinishExaminationService)ctx.getBean("finishExaminationService");

    @Test
    public void addFinishExamination() throws Exception {
        FinishExamination finishExamination = new FinishExamination();
        finishExamination.setExaminationId("623e25f8-afd5-40a6-ba94-4485836cf96b");
        finishExamination.setStudentId("bb95ffc7-dc8f-4e66-825a-38b18ca74062");
        // 54d9f08e-5e99-45e9-a095-33b71d42be45
        // bb95ffc7-dc8f-4e66-825a-38b18ca74062
        finishExamination.setUnitId("e5f07a50-8e35-4638-a8e4-ac7faad88d65");
        finishExaminationService.addFinishExamination(finishExamination);
    }

    @Test
    public void updateFinishExamination() throws Exception {
        finishExaminationService.updateFinishExamination("f04ea1f0-b2af-48ee-9528-cb02b033553b");
    }

    @Test
    public void selectFinExamById() throws Exception {
        FinishExaminationVo finishExaminationVo = finishExaminationService.selectFinExamById("35cc2871-b97f-43e1-9455-d4a638293979");
        System.out.println(finishExaminationVo.getExaminationName());
    }

    @Test
    public void selectFromStudent() {
        List<FinishExaminationVo> list = new ArrayList<FinishExaminationVo>();
        list = finishExaminationService.selectFromStudent("57a33c8b-8c8c-4a1b-abe4-72c47d15fb54");
    }

}