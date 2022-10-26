package com.epam.maksym_yena.java.lesson_18.task_10;


import com.epam.maksym_yena.java.lesson_18.task_11.ConnectorFactory;
import com.epam.maksym_yena.java.lesson_18.task_11.UserDao.UserDaoImplementation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws SQLException {

		Connection connection = ConnectorFactory.getConnection();

		UserDaoImplementation userDaoImplementation = new UserDaoImplementation();
		System.out.println(userDaoImplementation.getAllUsers());

		SpringApplication.run(Application.class, args);
	}
}



