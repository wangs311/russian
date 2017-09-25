package com.bluemsun.dao.Examination;

import com.bluemsun.common.core.UnitOfUUID;
import com.bluemsun.common.entitys.Examination;
import com.bluemsun.common.vo.ExaminationVo;
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
 * @Date: 2017/9/11 12:28
 */
@Repository
public class ExaminationDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    /**
    * @Description: 添加一套试卷
    * @Date: 2017/9/11 12:32
    */
    public void addExamination(Examination examination) {
        String sql = "INSERT INTO examination (id, questions_id, examination_name, unit_id, examination_mark) VALUES (?, ?, ?, ?, ?)";
        Object[] params = {UnitOfUUID.IdOfUUID(), examination.getQuestionsId(), examination.getExaminationName(), examination.getUnitId(), examination.getExaminationMark()};
        jdbcTemplate.update(sql, params);
    }
    
    
    /**
    * @Description: 删除一套试卷
    * @Date: 2017/9/11 12:49
    */
    public void deleteExamination(String id) {
        String sql = "DELETE FROM examination WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }


    /**
    * @Description: 查询出一套试卷
    * @Date: 2017/9/11 12:51
    */
    public ExaminationVo selectExamination(String id) {
        String sql = "SELECT id, questions_id, examination_name, unit_id, examination_mark FROM examination WHERE id = ?";
        RowMapper<ExaminationVo> rowMapper = new BeanPropertyRowMapper<ExaminationVo>(ExaminationVo.class);
        ExaminationVo examinationVo = null;
        try {
            examinationVo = jdbcTemplate.queryForObject(sql, rowMapper, id);
        }catch(EmptyResultDataAccessException e) {
            return null;
        }
        return examinationVo;
    }


    /**
    * @Description: 根据单元查询出所有的试卷
    * @Date: 2017/9/12 18:40
    */
    public List<ExaminationVo> selectAllExamination(String unitId) {
        String sql = "SELECT id, questions_id, examination_name, unit_id, examination_mark FROM examination WHERE unit_id = ? ORDER BY examination_name ASC";
        RowMapper<ExaminationVo> rowMapper = new BeanPropertyRowMapper<ExaminationVo>(ExaminationVo.class);
        List<ExaminationVo> list = null;
        try {
            list = jdbcTemplate.query(sql, rowMapper, unitId);
        }catch(EmptyResultDataAccessException e) {
            return null;
        }
        return list;
    }



}
