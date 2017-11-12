package com.bluemsun.dao.Examination;

import com.bluemsun.common.core.UnitOfUUID;
import com.bluemsun.common.entitys.FinishExamination;
import com.bluemsun.common.vo.FinishExaminationVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @author: Dongsl161
 * @Date: 2017/9/12 21:21
 */
@Repository
public class FinishExaminationDao {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    
    /**
    * @Description: 增加一套做完的试卷
    * @Date: 2017/9/12 21:22
    */
    public String addFinishExamination(FinishExamination finishExamination) {
        String sql = "INSERT INTO finish_examination (id, student_id, examination_id, unit_id, finish_mark, finish_time) VALUES (?, ?, ?, ?, ?, ?)";
        String id = UnitOfUUID.IdOfUUID();
        Object[] params = {id, finishExamination.getStudentId(), finishExamination.getExaminationId(), finishExamination.getUnitId(), finishExamination.getFinishMark(), new Date()};
        jdbcTemplate.update(sql, params);
        return id;
    }
    
    
    /**
    * @Description: 删除一套做完的试卷
    * @Date: 2017/9/12 21:32
    */
    public void deleteFinishExamination(String examinationId) {
        String sql = "DELETE FROM finish_examination WHERE examination_id = ?";
        jdbcTemplate.update(sql, examinationId);
    }
    

    /**
    * @Description: 更改试卷的分数
    * @Date: 2017/10/11 21:36
    */
    public void updateMark(int mark, String id) {
        String sql = "UPDATE finish_examination SET finish_mark = ? WHERE id = ?";
        jdbcTemplate.update(sql, mark, id);
    }


    /**
    * @Description: 更改一套试卷的处理状态
    * @Date: 2017/9/13 9:51
    */
    public void updateFinExam(String id) {
        String sql = "UPDATE finish_examination SET finish_already = 1 WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }


    /**
    * @Description: 根据id查询一个已完成的试卷
    * @Date: 2017/9/13 19:23
    */
    public FinishExaminationVo selectFinExamById(String id) {
        String sql = "SELECT finish_examination.id, finish_examination.student_id, finish_examination.examination_id, finish_examination.finish_already, finish_examination.unit_id, examination_name, finish_mark" +
                " FROM finish_examination INNER JOIN examination ON finish_examination.examination_id = examination.id" +
                " WHERE finish_examination.id = ?";
        RowMapper<FinishExaminationVo> rowMapper = new BeanPropertyRowMapper<FinishExaminationVo>(FinishExaminationVo.class);
        FinishExaminationVo finishExaminationVo = null;
        try {
            finishExaminationVo = jdbcTemplate.queryForObject(sql, rowMapper, id);
        }catch(EmptyResultDataAccessException e) {
            return null;
        }
        return finishExaminationVo;
    }




    /**
    * @Description: 学生查看自己已经做过的试卷
    * @Date: 2017/10/10 21:26
    */
    public List<FinishExaminationVo> selectFromStudent(String studentId) {
        String sql = "SELECT " +
                "unit.unit_name," +
                "edition.edition_name," +
                "examination.examination_name," +
                "finish_examination.id," +
                "finish_examination.student_id," +
                "finish_examination.examination_id," +
                "finish_examination.finish_already," +
                "finish_examination.unit_id," +
                "finish_examination.finish_mark,"+
                "finish_examination.finish_time " +
                "FROM " +
                "finish_examination " +
                "INNER JOIN unit ON finish_examination.unit_id = unit.id " +
                "INNER JOIN edition ON unit.edition_id = edition.id " +
                "INNER JOIN examination ON finish_examination.examination_id = examination.id " +
                "WHERE finish_examination.student_id = ? AND finish_examination.finish_already = '1' ORDER BY finish_time DESC";
        RowMapper<FinishExaminationVo> rowMapper = new BeanPropertyRowMapper<FinishExaminationVo>(FinishExaminationVo.class);
        System.out.println(sql);
        List<FinishExaminationVo> list = null;
        try {
            list = jdbcTemplate.query(sql, rowMapper, studentId);
        }catch(EmptyResultDataAccessException e) {
            return null;
        }
        return list;
    }


    /**
    * @Description: 老师后台查看做过的试卷，sql拼接
    * @Date: 2017/10/11 19:16
    */
    public List<FinishExaminationVo> selectFromTeacher(String editionId, String finishAlready, String unitId) {
        String sql = "SELECT " +
                "unit.unit_name," +
                "edition.edition_name," +
                "examination.examination_name," +
                "finish_examination.id," +
                "finish_examination.student_id," +
                "finish_examination.examination_id," +
                "finish_examination.finish_already," +
                "finish_examination.unit_id," +
                "finish_examination.finish_mark,"+
                "student.student_name," +
                "finish_examination.finish_time " +
                "FROM " +
                "finish_examination " +
                "INNER JOIN unit ON finish_examination.unit_id = unit.id " +
                "INNER JOIN edition ON unit.edition_id = edition.id " +
                "INNER JOIN examination ON finish_examination.examination_id = examination.id " +
                "INNER JOIN student ON finish_examination.student_id = student.id " +
                "WHERE edition.id = ? AND finish_already = ?";
        if(unitId != null) {
            sql += " AND unit.id = '" + unitId + "' ";
        }
        sql += " ORDER BY finish_time DESC";
        RowMapper<FinishExaminationVo> rowMapper = new BeanPropertyRowMapper<FinishExaminationVo>(FinishExaminationVo.class);
        List<FinishExaminationVo> list = null;
        try {
            list = jdbcTemplate.query(sql, rowMapper, editionId, finishAlready);
        }catch(EmptyResultDataAccessException e) {
            return null;
        }
        return list;
    }



}
