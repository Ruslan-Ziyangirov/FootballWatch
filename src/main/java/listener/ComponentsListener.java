package listener;

import models.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import repositories.UserRepository;
import repositories.UserRepositoryJdbcTemplateImpl;
import repositories.old.*;
import services.UsersService;
import services.UsersServicesImpl;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ComponentsListener implements ServletContextListener {

    String url="jdbc:postgresql://localhost:5432/postgres";
    String username = "postgres";
    String password = "postgres";


    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        servletContextEvent.getServletContext().setAttribute("applicationContext", context);
    }

}
