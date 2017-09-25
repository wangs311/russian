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
    public void addFinishExamination(FinishExamination finishExamination) {
        String sql = "INSERT INTO finish_examination (id, student_id, examination_id, unit_id) VALUES (?, ?, ?, ?)";
        Object[] params = {UnitOfUUID.IdOfUUID(), finishExamination.getStudentId(), finishExamination.getExaminationId(), finishExamination.getUnitId()};
        jdbcTemplate.update(sql, params);
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
        String sql = "SELECT finish_examination.id, finish_examination.student_id, finish_examination.examination_id, finish_examination.finish_already, finish_examination.unit_id, examination_name" +
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
    * @Description: 按照单元和学生年级查询已经做完的试卷
     * 有多种情况，单元是必选项，后台查出所有的，选择年级查看。或者学生前台自己登陆查看自己的
    * @Date: 2017/9/12 21:46
    */
    public List<FinishExaminationVo> selectFinExamByUnit(String unitId, int grade, String studentId) {
        String sql = "SELECT finish_examination.id, finish_examination.student_id, " +
                "finish_examination.examination_id, finish_examination.finish_already, " +
                "finish_examination.unit_id, examination.examination_name, student.student_name " +
                "FROM finish_examination INNER JOIN examination ON finish_examination.examination_id = examination.id " +
                "INNER JOIN student ON finish_examination.student_id = student.id WHERE finish_examination.unit_id = ?";
        if(grade != 0) {
            sql += " AND student_grade = " + grade;
        }
        if(studentId != null) {
            sql += " AND student_id = '" + studentId + "' ";
        }
        sql += " ORDER BY examination_name ASC";
        Object[] params = {unitId};
        RowMapper<FinishExaminationVo> rowMapper = new BeanPropertyRowMapper<FinishExaminationVo>(FinishExaminationVo.class);
        List<FinishExaminationVo> list = null;
        try {
            list = jdbcTemplate.query(sql, rowMapper, params);
        }catch(EmptyResultDataAccessException e) {
            return null;
        }
        return list;
    }


}
