package Examination;

import com.bluemsun.common.entitys.Edition;
import com.bluemsun.service.Examination.EditionService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @Description:
 * @author: Dongsl161
 * @Date: 2017/8/19 20:37
 */
public class EditionServiceTest {

    private ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
    private EditionService editionService = (EditionService) ctx.getBean("editionService");

    @Test
    public void selectAllEdtion() throws Exception {
        List<Edition> list = editionService.selectAllEdtion();
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getEditionName());
        }
    }

}