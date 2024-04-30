package br.com.alura.school.infra.student;

import br.com.alura.school.domain.student.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentJdbcRepository implements StudentRepository {

    private final Connection connection;

    public StudentJdbcRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void enroll(Student student) {
        try{
            String sql = "INSERT INTO STUDENT VALUES(?, ?, ?)";
            var stmt = connection.prepareStatement(sql);
            stmt.setString(1, student.getCpf().getNumber());
            stmt.setString(2, student.getName());
            stmt.setString(3, student.getEmail().getAddress());
            stmt.execute();

            sql = "INSERT INTO CELLPHONE VALUES(?, ?)";
            stmt = connection.prepareStatement(sql);
            for(Cellphone cellphone : student.getCellphones()){
                stmt.setString(1, cellphone.getDdd());
                stmt.setString(2, cellphone.getNumber());
                stmt.execute();
            }
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Student findByCPF(CPF cpf) {
        try {
            String sql = "SELECT * FROM STUDENT WHERE CPF = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, cpf.getNumber());
            ResultSet rs = st.executeQuery();

            if(!rs.next()){
                throw new RuntimeException("Student not found");
            }

            StudentFactory studentFactory = new StudentFactory();
            return studentFactory.withCPF(rs.getString("CPF"))
                .withName(rs.getString("NAME"))
                .withEmail(rs.getString("EMAIL"))
                .create();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Student> findAllEnrolledStudents() {
        Statement st = null;
        try {
            st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM STUDENT");
            List<Student> students = new ArrayList<>();
            while(rs.next()){
                StudentFactory studentFactory = new StudentFactory();
                students.add(studentFactory.withCPF(rs.getString("CPF"))
                    .withName(rs.getString("NAME"))
                    .withEmail(rs.getString("EMAIL"))
                    .create());
            }
            return students;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
