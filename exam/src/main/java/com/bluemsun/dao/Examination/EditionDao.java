package com.bluemsun.dao.Examination;

import com.bluemsun.common.entitys.Edition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description: 册的Dao
 * @author: Dongsl161
 * @Date: 2017/8/19 20:25
 */
@Repository
public class EditionDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    /**
    * @Description: 查询出所有册
    * @Date: 2017/8/19 20:26
    */
    public List<Edition> selectAllEdition() {
        String sql = "SELECT id, edition_name FROM edition ORDER BY edition_name ASC";
        RowMapper<Edition> rowMapper = new BeanPropertyRowMapper<Edition>(Edition.class);
        List<Edition> list = null;
        try {
            list = jdbcTemplate.query(sql, rowMapper);
        }catch (EmptyResultDataAccessException e) {
            return null;
        }
        return list;
    }



}
