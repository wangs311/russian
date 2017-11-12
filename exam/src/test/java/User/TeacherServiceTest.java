package User;

import com.bluemsun.common.entitys.Teacher;
import com.bluemsun.service.User.TeacherService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description:
 * @author: Dongsl161
 * @Date: 2017/10/12 13:32
 */
public class TeacherServiceTest {

    public ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
    TeacherService teacherService = (TeacherService)ctx.getBean("teacherService");

    @Test
    public void addTeacher() {
        Teacher teacher = new Teacher();
        teacher.setTeacherEdition("fd1a17db-9ef7-4a3d-8309-9fc47a79b30a");
        teacher.setTeacherNumber("admin8");
        teacher.setTeacherName("第八册管理员");
        teacher.setTeacherPassword("88888");
        teacherService.addTeacher(teacher);
    }

}