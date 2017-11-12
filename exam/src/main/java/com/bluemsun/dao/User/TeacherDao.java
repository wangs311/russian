package com.bluemsun.dao.User;

import com.bluemsun.common.core.UnitOfUUID;
import com.bluemsun.common.entitys.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * @Description:
 * @author: Dongsl161
 * @Date: 2017/8/13 20:45
 */
@Repository
public class TeacherDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    /**
    * @Description: 添加老师用户
    * @Date: 2017/10/12 13:27
    */
    public void addTeacher(Teacher teacher) {
        String sql = "INSERT INTO teacher (id, teacher_name, teacher_number, teacher_password, teacher_edition) VALUES (?, ?, ?, ?, ?)";
        Object[] params = new Object[]{UnitOfUUID.IdOfUUID(), teacher.getTeacherName(), teacher.getTeacherNumber(), teacher.getTeacherPassword(), teacher.getTeacherEdition()};
        jdbcTemplate.update(sql, params);
    }


    /**
    * @Description: 判断老师账号是否正确
    * @Date: 2017/9/30 17:40
    */
    public Teacher selectOneTeacher(String teacherNumber, String teacherPassword) {
        String sql = "SELECT id, teacher_name, teacher_number, teacher_password, teacher_edition FROM teacher WHERE teacher_number = ? AND teacher_password = ?";
        RowMapper<Teacher> rowMapper = new BeanPropertyRowMapper(Teacher.class);
        Object[] params = {teacherNumber, teacherPassword};
        Teacher teacher = null;
        try {
            teacher = jdbcTemplate.queryForObject(sql, rowMapper, params);
        }catch(EmptyResultDataAccessException e) {
            return null;
        }
        return teacher;
    }


}
