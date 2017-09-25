package Message;

import com.bluemsun.common.entitys.Message;
import com.bluemsun.common.vo.MessageVo;
import com.bluemsun.service.Message.MessageService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @Description:
 * @author: Dongsl161
 * @Date: 2017/8/17 14:19
 */
public class MessageServiceTest {

    private ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
    private MessageService messageService = (MessageService) ctx.getBean("messageService");

    @Test
    public void addMessage() throws Exception {
        Message message = new Message();
        message.setMessageContent("董丝纶留言");
        message.setUserId("57a33c8b-8c8c-4a1b-abe4-72c47d15fb54");
        messageService.addMessage(message);
        message.setMessageContent("杨可欣回复董丝纶的留言");
        message.setUserId("bb95ffc7-dc8f-4e66-825a-38b18ca74062");
        messageService.addMessage(message);
//        message.setMessageContent("江承远留言");
//        message.setUserId("54d9f08e-5e99-45e9-a095-33b71d42be45");
//        messageService.addMessage(message);
    }

    @Test
    public void deleteMessage() throws Exception {
        messageService.deleteMessage("c7d440fb-6237-4f60-97ca-a388bb2c0183");
    }

    @Test
    public void selectAllMessage() throws Exception {
        List<MessageVo> list = messageService.selectAllMessage();
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).getPreMessageVo() != null) {
                System.out.println(list.get(i).getMessageContent() + "---" + list.get(i).getPreMessageVo().getMessageContent());
            }else {
                System.out.println(list.get(i).getMessageContent());
            }

        }
    }

    @Test
    public void selectMessageByUser() throws Exception {
        List<MessageVo> list = messageService.selectMessageByUser("57a33c8b-8c8c-4a1b-abe4-72c47d15fb54");
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).getPreMessageVo() != null) {
                System.out.println(list.get(i).getMessageContent() + "---" + list.get(i).getPreMessageVo().getMessageContent());
            }else {
                System.out.println(list.get(i).getMessageContent());
            }

        }
    }

}