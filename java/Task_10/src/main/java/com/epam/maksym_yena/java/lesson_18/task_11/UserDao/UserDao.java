package com.epam.maksym_yena.java.lesson_18.task_11.UserDao;

import com.epam.maksym_yena.java.lesson_18.task_11.Doctor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

public interface UserDao {

    Doctor getUser(int id) throws SQLException;

    Doctor getDoctorByUserNameAndSpecialization(String name, String specialization) throws SQLException;

    Set<Doctor> getAllUsers() throws SQLException;

    Doctor extractDoctorFromResultSet(ResultSet rs) throws SQLException;

    boolean insertUser(Doctor user) throws SQLException;

    boolean updateUser(Doctor user) throws SQLException;

    boolean deleteUser(int id) throws SQLException;
}
