package com.bluemsun.dao.Examination;

import com.bluemsun.common.core.UnitOfUUID;
import com.bluemsun.common.entitys.FinishAnswer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * @Description:
 * @author: Dongsl161
 * @Date: 2017/9/14 8:43
 */
@Repository
public class FinishAnswerDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    /**
    * @Description: 插入一条试题记录
    * @Date: 2017/9/14 8:43
    */
    public void addFinishAnswer(FinishAnswer finishAnswer) {
        String sql = "INSERT INTO finish_answer (id, finish_examination_id, question_id, finish_answer_content) VALUES (?, ?, ?, ?)";
        Object[] params = {UnitOfUUID.IdOfUUID(), finishAnswer.getFinishExaminationId(), finishAnswer.getQuestionId(), finishAnswer.getFinishAnswerContent()};
        jdbcTemplate.update(sql, params);
    }


    /**
    * @Description: 删除试题记录，根据已完成试卷id
    * @Date: 2017/9/14 8:55
    */
    public void deleteFinishAnswer(String finishExaminationId) {
        String sql = "DELETE FROM finish_answer WHERE finish_examination_id = ?";
        jdbcTemplate.update(sql, finishExaminationId);
    }



    /**
    * @Description: 修改分数
    * @Date: 2017/9/15 19:14
    */
    public void updateMark(String id, int mark) {
        String sql = "UPDATE finish_answer SET finish_answer_mark = ? WHERE id = ?";
        jdbcTemplate.update(sql, mark, id);
    }

    
    /**
    * @Description: 根据小题id和所完成试卷的id查询出对应的完成的小题
    * @Date: 2017/9/15 12:11
    */
    public FinishAnswer selectOneFinAns(String questionId, String FinishExaminationId) {
        String sql = "SELECT id, finish_examination_id, question_id, finish_answer_content, finish_answer_mark FROM finish_answer WHERE question_id = ? AND finish_examination_id = ?";
        RowMapper<FinishAnswer> rowMapper = new BeanPropertyRowMapper<FinishAnswer>(FinishAnswer.class);
        FinishAnswer finishAnswer = null;
        try {
            finishAnswer = jdbcTemplate.queryForObject(sql, rowMapper, questionId, FinishExaminationId);
        }catch(EmptyResultDataAccessException e) {
            return null;
        }
        return finishAnswer;
    }


}
