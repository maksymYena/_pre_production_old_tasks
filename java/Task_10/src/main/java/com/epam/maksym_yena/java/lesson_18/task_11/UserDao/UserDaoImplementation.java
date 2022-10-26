package com.epam.maksym_yena.java.lesson_18.task_11.UserDao;

import com.epam.maksym_yena.java.lesson_18.task_11.ConnectorFactory;
import com.epam.maksym_yena.java.lesson_18.task_11.Doctor;
import org.apache.catalina.connector.Connector;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class UserDaoImplementation implements UserDao{

    @Override
    public Doctor extractDoctorFromResultSet(ResultSet rs) throws SQLException {
        Doctor user = new Doctor();
        user.setId( rs.getInt("id") );
        user.setName( rs.getString("name") );
        user.setSpecialization( rs.getString("specialization") );
        return user;
    }


    @Override
    public Doctor getUser(int id) throws SQLException {
        Connection connection = ConnectorFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE id=" + id);
            if(rs.next())
            {
                return extractDoctorFromResultSet(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Doctor getDoctorByUserNameAndSpecialization(String name, String specialization) throws SQLException {
        Connector connector = new Connector();
        Connection connection = ConnectorFactory.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM users WHERE name=? AND specialization=?");
            ps.setString(1, name);
            ps.setString(2, specialization);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                return extractDoctorFromResultSet(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Set getAllUsers() throws SQLException {
        Connector connector = new Connector();
        Connection connection = ConnectorFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");
            Set users = new HashSet();
            while(rs.next())
            {
                Doctor doctor = extractDoctorFromResultSet(rs);
                users.add(doctor);
            }
            return users;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean insertUser(Doctor user) throws SQLException {
        Connector connector = new Connector();
        Connection connection = ConnectorFactory.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO users VALUES (NULL, ?, ?, ?)");
            ps.setString(1, user.getName());
            ps.setString(2, user.getSpecialization());
            ps.setInt(3, user.getId());
            int i = ps.executeUpdate();
            if(i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateUser(Doctor user) throws SQLException {
        Connector connector = new Connector();
        Connection connection = ConnectorFactory.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE users SET name=?, specialization=? WHERE id=?");
            ps.setString(1, user.getName());
            ps.setString(2, user.getSpecialization());
            ps.setInt(4, user.getId());
            int i = ps.executeUpdate();
            if(i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        Connector connector = new Connector();
        Connection connection = ConnectorFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate("DELETE FROM users WHERE id=" + id);
            if(i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
