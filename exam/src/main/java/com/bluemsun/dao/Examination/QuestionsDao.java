package com.bluemsun.dao.Examination;

import com.bluemsun.common.core.UnitOfUUID;
import com.bluemsun.common.entitys.Questions;
import com.bluemsun.common.vo.QuestionsVo;
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
 * @Date: 2017/8/28 19:13
 */
@Repository
public class QuestionsDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    /**
    * @Description: 添加一道大题
    * @Date: 2017/8/28 19:13
    */
    public String addQuestions(Questions questions) {
        String sql = "INSERT INTO questions (id, questions_title, questions_article, questions_type_id, questions_mark, unit_id) VALUES (?, ?, ?, ?, ?, ?)";
        String id = UnitOfUUID.IdOfUUID();
        Object[] params = {id, questions.getQuestionsTitle(), questions.getQuestionsArticle(), questions.getQuestionsTypeId(), questions.getQuestionsMark(), questions.getUnitId()};
        jdbcTemplate.update(sql, params);
        return id;
    }


    /**
    * @Description: 删除一道大题
    * @Date: 2017/8/28 19:39
    */
    public void deleteQuestions(String id) {
        String sql = "DELETE FROM questions WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }


    /**
    * @Description: 查询一个单元的某个题型的所有大题
    * @Date: 2017/8/28 19:41
    */
    public List<QuestionsVo> selectQuestionsByUnitAndType(String unitId, String questionsTypeId) {
        String sql = "SELECT id, questions_title, questions_article, questions_type_id, questions_mark, unit_id FROM questions WHERE unit_id = ? AND questions_type_id = ?";
        RowMapper<QuestionsVo> rowMapper = new BeanPropertyRowMapper<QuestionsVo>(QuestionsVo.class);
        List<QuestionsVo> list = null;
        try {
            list = jdbcTemplate.query(sql, rowMapper, unitId, questionsTypeId);
        }catch (EmptyResultDataAccessException e) {
            return null;
        }
        return list;
    }


    /**
    * @Description: 根据id查询某道大题
    * @Date: 2017/8/28 20:09
    */
    public QuestionsVo selectQuestionsVoById(String id) {
        String sql = "SELECT id, questions_title, questions_article, questions_type_id, questions_mark, unit_id FROM questions WHERE id = ?";
        RowMapper<QuestionsVo> rowMapper = new BeanPropertyRowMapper<QuestionsVo>(QuestionsVo.class);
        QuestionsVo questionsVo = null;
        try {
            questionsVo = jdbcTemplate.queryForObject(sql, rowMapper, id);
        }catch (EmptyResultDataAccessException e) {
            return null;
        }
        return questionsVo;
    }


    /**
    * @Description: 根据题型查询所有大题id
    * @Date: 2017/8/30 21:59
    */
    public List<String> selectQuestionsByType(String questionsTypeId) {
        String sql = "SELECT id FROM questions WHERE questions_type_id = ?";
        RowMapper<String> rowMapper = new BeanPropertyRowMapper<String>(String.class);
        List<String> list = jdbcTemplate.query(sql, rowMapper, questionsTypeId);
        return list;
    }


}
