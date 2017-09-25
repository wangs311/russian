package com.bluemsun.dao.Examination;

import com.bluemsun.common.entitys.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description: 单元的dao
 * @author: Dongsl161
 * @Date: 2017/8/19 20:44
 */
@Repository
public class UnitDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    /**
    * @Description: 根据册的id查询出所有的单元
    * @Date: 2017/8/21 15:53
    */
    public List<Unit> selectAllUnit(String editionId) {
        String sql = "SELECT id, unit_name, edition_id FROM unit WHERE edition_id = ? ORDER BY unit_name ASC";
        RowMapper<Unit> rowMapper = new BeanPropertyRowMapper<Unit>(Unit.class);
        List<Unit> list = null;
        try {
            list = jdbcTemplate.query(sql, rowMapper, editionId);
        }catch (EmptyResultDataAccessException e) {
            return null;
        }
        return list;
    }






}
