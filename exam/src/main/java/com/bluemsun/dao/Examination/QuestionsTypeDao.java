package com.bluemsun.dao.Examination;

import com.bluemsun.common.core.UnitOfUUID;
import com.bluemsun.common.entitys.QuestionsType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description: 大题类型的持久层
 * @author: Dongsl161
 * @Date: 2017/8/21 16:20
 */
@Repository
public class QuestionsTypeDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    /**
    * @Description: 添加一种题型
    * @Date: 2017/8/21 16:23
    */
    public void addQuestionsType(String questionsType) {
        String sql = "INSERT INTO questions_type (id, questions_type_name) VALUES (?, ?)";
        Object[] params = {UnitOfUUID.IdOfUUID(), questionsType};
        jdbcTemplate.update(sql, params);
    }


    /**
    * @Description: 查询所有的题型
    * @Date: 2017/8/21 16:21
    */
    public List<QuestionsType> selectAllQuestion() {
        String sql = "SELECT id, questions_type_name FROM questions_type";
        RowMapper<QuestionsType> rowMapper = new BeanPropertyRowMapper<QuestionsType>(QuestionsType.class);
        List<QuestionsType> list = null;
        try {
            list = jdbcTemplate.query(sql, rowMapper);
        }catch (EmptyResultDataAccessException e) {
            return null;
        }
        return list;
    }


    /**
    * @Description: 删除一种题型
    * @Date: 2017/8/28 17:29
    */
    public void deleteQuestionsType(String id) {
        String sql = "DELETE FROM questions_type WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

}
