package com.bluemsun.dao.Examination;

import com.bluemsun.common.core.UnitOfUUID;
import com.bluemsun.common.entitys.Question;
import com.bluemsun.common.vo.QuestionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description:
 * @author: Dongsl161
 * @Date: 2017/8/28 18:16
 */
@Repository
public class QuestionDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    /**
    * @Description: 添加一道小题
    * @Date: 2017/8/28 18:16
    */
    public void addQuestion(Question question) {
        String sql = "INSERT INTO question (id, questions_id, question_outline, question_answer, question_analysis, question_mark, question_number) VALUES (?, ?, ?, ?, ?, ?, ?)";
        Object[] params = {UnitOfUUID.IdOfUUID(), question.getQuestionsId(), question.getQuestionOutline(), question.getQuestionAnswer(), question.getQuestionAnalysis(), question.getQuestionMark(), question.getQuestionNumber()};
        jdbcTemplate.update(sql, params);
    }


    /**
    * @Description: 删除一道小题
    * @Date: 2017/8/28 18:41
    */
    public void deleteQuestion(String id) {
        String sql = "DELETE FROM question WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }


    /**
    * @Description: 查询出一道大题的所有小题
    * @Date: 2017/8/28 18:43
    */
    public List<QuestionVo> selectAllQuestion(String questionsId) {
        String sql = "SELECT id, questions_id, question_outline, question_answer, question_analysis, question_mark, question_number FROM question WHERE questions_id = ? ORDER BY question_number";
        RowMapper<QuestionVo> rowMapper = new BeanPropertyRowMapper<QuestionVo>(QuestionVo.class);
        List<QuestionVo> list = null;
        try {
            list = jdbcTemplate.query(sql, rowMapper, questionsId);
        }catch (EmptyResultDataAccessException e) {
            return null;
        }
        return list;
    }



}
