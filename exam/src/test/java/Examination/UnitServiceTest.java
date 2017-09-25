package Examination;

import com.bluemsun.common.entitys.Unit;
import com.bluemsun.service.Examination.UnitService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @Description:
 * @author: Dongsl161
 * @Date: 2017/8/21 16:14
 */
public class UnitServiceTest {

    private ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
    private UnitService unitService = (UnitService)ctx.getBean("unitService");

    @Test
    public void selectAllUnit() throws Exception {
        List<Unit> list = unitService.selectAllUnit("14e12df5-84ee-480d-a82b-55ec8c3329c7");
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getUnitName());
        }
    }

}