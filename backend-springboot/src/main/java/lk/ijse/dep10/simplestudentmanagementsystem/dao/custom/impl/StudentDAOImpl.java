package lk.ijse.dep10.simplestudentmanagementsystem.dao.custom.impl;

import lk.ijse.dep10.simplestudentmanagementsystem.dao.custom.StudentDAO;
import lk.ijse.dep10.simplestudentmanagementsystem.entity.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;
import static  lk.ijse.dep10.simplestudentmanagementsystem.dao.util.Mappers.STUDENT_ROW_MAPPER;

@Repository
public class StudentDAOImpl implements StudentDAO {

    private JdbcTemplate jdbcTemplate;

    public StudentDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Student save(Student student) throws Exception {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement stm = con.prepareStatement("INSERT INTO student (name, address) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
            stm.setString(1, student.getName());
            stm.setString(2, student.getAddress());
            return stm;
        }, keyHolder);
        student.setId(keyHolder.getKey().intValue());
        return student;
    }

    @Override
    public void deleteById(Integer pk) throws Exception {
        jdbcTemplate.update("DELETE FROM student WHERE id=?", pk);
    }

    @Override
    public List<Student> findAll() throws Exception {
        return jdbcTemplate.query("SELECT * FROM student", STUDENT_ROW_MAPPER);
    }

}
