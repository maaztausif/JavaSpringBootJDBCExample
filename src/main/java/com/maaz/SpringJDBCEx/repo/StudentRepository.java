package com.maaz.SpringJDBCEx.repo;

import com.maaz.SpringJDBCEx.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {

    private JdbcTemplate jdbc;

    public JdbcTemplate getJdbc() {
        return jdbc;
    }

    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void save(Student std){

        String sql = "insert into student (roll_No,name,marks) values (?,?,?)";

        System.out.println("test" + std.getRollNo());
        int rows = jdbc.update(sql,std.getRollNo(),std.getName(),std.getMarks());
        System.out.println(rows + " effected");
        System.out.println("Student Save");
    }

    public List<Student> findAll(){
        List<Student> studentData = new ArrayList<>();

        String sql = "select * from student";
//        RowMapper<Student> mapper = ( rs,  rowNum) -> {
//                Student s = new Student();
//                s.setRollNo(rs.getInt("roll_No"));
//                s.setName(rs.getString("name"));
//                s.setMarks(rs.getInt("marks"));
//
//                return s;
//
//        };

//        RowMapper mapper = new RowMapper() {
//            @Override
//            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//                Student s = new Student();
//                s.setRollNo(rs.getInt("roll_No"));
//                s.setName(rs.getString("name"));
//                s.setMarks(rs.getInt("marks"));
//
//                return s;
//            }
//        };

        return jdbc.query(sql,( rs,  rowNum) -> {
            Student s = new Student();
            s.setRollNo(rs.getInt("roll_No"));
            s.setName(rs.getString("name"));
            s.setMarks(rs.getInt("marks"));

            return s;

        });
    }
}
