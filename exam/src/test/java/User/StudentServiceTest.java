package User;

import com.bluemsun.common.entitys.Student;
import com.bluemsun.service.User.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @Description:
 * @author: Dongsl161
 * @Date: 2017/8/15 14:30
 */
public class StudentServiceTest {

    public ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
    StudentService studentService = (StudentService) ctx.getBean("studentService");

    @Test
    public void addStudent() throws Exception {
        Student student = new Student();
        student.setStudentNumber("201501xxxx");
        student.setStudentPassword("201501xxxx");
        student.setStudentName("江承远");
        student.setStudentGrade("2015");
        studentService.addStudent(student);
    }

    @Test
    public void deleteStudent() throws Exception {
        studentService.deleteStudent("526498ce-9a5c-4f14-b389-e873f1e4ee5b");
    }

    @Test
    public void checkLogin() throws Exception {
        Boolean flag = studentService.checkLogin("2015012007", "2015012008");
        System.out.println(flag);
    }

    @Test
    public void selectAllStudent() throws Exception {
        List<Student> list = studentService.selectAllStudent();
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getStudentGrade());
        }
    }

}