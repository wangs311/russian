package com.bluemsun.dao.Message;

import com.bluemsun.common.core.UnitOfUUID;
import com.bluemsun.common.entitys.Message;
import com.bluemsun.common.vo.MessageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @Description: 留言的Dao
 * @author: Dongsl161
 * @Date: 2017/8/16 16:36
 */
@Repository
public class MessageDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    /**
    * @Description: 添加一条留言
    * @Date: 2017/8/16 16:38
    */
    public void addMessage(Message message) {
        String sql = "INSERT INTO message (id, user_id, previous_message_id, message_content, message_time) VALUES (?, ?, ?, ?, ?)";
        Object[] args = {UnitOfUUID.IdOfUUID(), message.getUserId(), message.getPreviousMessageId(), message.getMessageContent(), new Date()};
        jdbcTemplate.update(sql, args);
    }


    /**
    * @Description: 根据id删除一条留言
    * @Date: 2017/8/16 17:30
    */
    public void deleteMessage(String id) {
        String sql = "DELETE FROM message WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }


    /**
    * @Description: 根据id查询一条留言
    * @Date: 2017/8/16 17:31
    */
    public MessageVo selectOneMessage(String id) {
        String sql = "SELECT id, user_id, previous_message_id, message_content, message_time FROM message WHERE id = ?";
        RowMapper<MessageVo> rowMapper = new BeanPropertyRowMapper<MessageVo>(MessageVo.class);
        MessageVo messageVo = null;
        try {
            messageVo = jdbcTemplate.queryForObject(sql, rowMapper, id);
        }catch (EmptyResultDataAccessException e) {
            return null;
        }
        return messageVo;
    }


    /**
    * @Description: 根据用户id查询其留言
    * @Date: 2017/8/17 12:24
    */
    public List<MessageVo> selectOneByUser(String userId) {
        String sql = "SELECT id, user_id, previous_message_id, message_content, message_time FROM message WHERE user_id = ?";
        RowMapper<MessageVo> rowMapper = new BeanPropertyRowMapper<MessageVo>(MessageVo.class);
        List<MessageVo> list = null;
        try {
            list = jdbcTemplate.query(sql, rowMapper, userId);
        }catch (EmptyResultDataAccessException e) {
            return null;
        }
        return list;
    }


    /**
    * @Description: 查询所有留言
    * @Date: 2017/8/16 18:06
    */
    public List<MessageVo> selectAllMessage() {
        String sql = "SELECT id, user_id, previous_message_id, message_content FROM message ORDER BY message_time DESC";
        RowMapper<MessageVo> rowMapper = new BeanPropertyRowMapper<MessageVo>(MessageVo.class);
        List<MessageVo> list = null;
        try {
            list = jdbcTemplate.query(sql, rowMapper);
        }catch (EmptyResultDataAccessException e) {
            return null;
        }
        return list;
    }


}
