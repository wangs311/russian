package com.bluemsun.dao.User;

import com.bluemsun.common.core.UnitOfUUID;
import com.bluemsun.common.entitys.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description: 学生用户的Dao
 * @author: Dongsl161
 * @Date: 2017/8/12 12:45
 */
@Repository
public class StudentDao {

    @Autowired
    private  JdbcTemplate jdbcTemplate;

    /**
    * @Description: 添加一个新的学生用户
    * @Date: 2017/8/13 18:56
    */
    public void addStudent(Student student) {
        String sql = "INSERT INTO student (id, student_name, student_number, student_password, student_grade) VALUES (?, ?, ?, ?, ?)";
        Object[] args = {UnitOfUUID.IdOfUUID(), student.getStudentName(), student.getStudentNumber(), student.getStudentPassword(), student.getStudentGrade()};
        jdbcTemplate.update(sql, args);
    }


    /**
    * @Description: 删除一个学生用户
    * @Date: 2017/8/13 19:30
    */
    public void deleteStudent(String id) {
        String sql = "DELETE FROM student WHERE id = ?";
        Object[] args = {id};
        jdbcTemplate.update(sql, args);
    }


    /**
    * @Description: 更改一个用户的登录权限
    * @Date: 2017/8/13 19:48
    */
    public void updateStudentPower(String id) {
        String sql = "UPDATE student SET student_is_delete = 1 WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }


    /**
    * @Description: 根据用户名密码查询一个用户
    * @Date: 2017/8/13 20:05
    */
    public Student selectOneStudent(String studentNumber, String studentPassword) {
        String sql = "SELECT * FROM student WHERE student_number = ? AND student_password = ?";
        Object[] args = {studentNumber, studentPassword};
        RowMapper<Student> rowMapper = new BeanPropertyRowMapper<Student>(Student.class);
        Student student = null;
        try {
            student = jdbcTemplate.queryForObject(sql, rowMapper, args);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
        return student;
    }


    /**
    * @Description: 根据id查询一名用户
    * @Date: 2017/8/17 13:30
    */
    public Student selectOneById(String id) {
        String sql = "SELECT id, student_name, student_number, student_password, student_grade, student_is_delete FROM student WHERE id = ?";
        RowMapper<Student> rowMapper = new BeanPropertyRowMapper<Student>(Student.class);
        Student student = null;
        try {
            student = jdbcTemplate.queryForObject(sql, rowMapper, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
        return student;
    }


    /**
    * @Description: 查询出所有用户
    * @Date: 2017/8/13 20:39
    */
    public List<Student> selectAllStudent() {
        String sql = "SELECT * FROM student";
        RowMapper<Student> rowMapper = new BeanPropertyRowMapper<Student>(Student.class);
        List<Student> list = null;
        try {
            list = jdbcTemplate.query(sql, rowMapper);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
        return list;
    }


}
