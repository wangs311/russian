package com.bluemsun.service.Message;

import com.bluemsun.common.entitys.Message;
import com.bluemsun.common.vo.MessageVo;
import com.bluemsun.dao.Message.MessageDao;
import com.bluemsun.dao.User.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 留言的service
 * @author: Dongsl161
 * @Date: 2017/8/16 18:10
 */
@Service
public class MessageService {

    @Autowired
    private MessageDao messageDao;

    @Autowired
    private StudentDao studentDao;


    /**
    * @Description: 添加一条留言
    * @Date: 2017/8/16 18:42
    */
    public void addMessage(Message message) {
        messageDao.addMessage(message);
    }


    /**
    * @Description: 删除一条留言顺带删除所有评论
    * @Date: 2017/8/16 18:49
    */
    public void deleteMessage(String id) {
        String thisId = id;
        String previousId = messageDao.selectOneMessage(thisId).getPreviousMessageId();
        messageDao.deleteMessage(thisId);
        while(previousId != null) {
            thisId = previousId;
            previousId = messageDao.selectOneMessage(thisId).getPreviousMessageId();
            messageDao.deleteMessage(thisId);
        }
    }


    /**
    * @Description: 查询所有留言
    * @Date: 2017/8/16 22:12
    */
    public List<MessageVo> selectAllMessage() {
        List<MessageVo> list = messageDao.selectAllMessage();
        for(int i = 0; i < list.size(); i++) {
            // 获取并设置用户名
            String userName = studentDao.selectOneById(list.get(i).getUserId()).getStudentName();
            list.get(i).setUserName(userName);
            // 获取并设置其回复的哪条留言
            MessageVo preMessageVo = messageDao.selectOneMessage(list.get(i).getPreviousMessageId());
            if(preMessageVo != null) {
                String preUserName = studentDao.selectOneById(preMessageVo.getUserId()).getStudentName();
                preMessageVo.setUserName(preUserName);
                list.get(i).setPreMessageVo(preMessageVo);
            }
        }
        return list;
    }


    /**
    * @Description: 查询对应用户的所有留言
    * @Date: 2017/8/17 13:46
    */
    public List<MessageVo> selectMessageByUser(String userId) {
        List<MessageVo> list = messageDao.selectOneByUser(userId);
        for(int i = 0; i < list.size(); i++) {
            // 获取并设置用户名
            String userName = studentDao.selectOneById(list.get(i).getUserId()).getStudentName();
            list.get(i).setUserName(userName);
            // 获取并设置其回复的哪条留言
            MessageVo preMessageVo = messageDao.selectOneMessage(list.get(i).getPreviousMessageId());
            if(preMessageVo != null) {
                String preUserName = studentDao.selectOneById(preMessageVo.getUserId()).getStudentName();
                preMessageVo.setUserName(preUserName);
                list.get(i).setPreMessageVo(preMessageVo);
            }
        }
        return list;
    }




}
