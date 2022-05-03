package servlets;

import form.UserForm;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import repositories.UserRepository;
import repositories.UserRepositoryJdbcTemplateImpl;
import services.UsersService;
import services.UsersServicesImpl;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;


public class RegistrationServlet extends HttpServlet {

    private Connection connection;
    private UsersServicesImpl usersService;


    @Override
    public void init(ServletConfig config) throws ServletException {
        ApplicationContext context = (ApplicationContext) config.getServletContext().getContext("applicationContext");
    }




    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        System.out.println("ЖИВИ!");
        request.getRequestDispatcher("jsp/registr.ftl").forward(request, response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String first_name = request.getParameter("first_name");
        String second_name = request.getParameter("second_name");
        String email = request.getParameter("email");

        UserForm userForm = new UserForm();
        userForm.setFirst_name(first_name);
        userForm.setSecond_name(second_name);
        userForm.setLogin(login);
        userForm.setPassword(password);
        userForm.setEmail(email);

        usersService.register(userForm);

        request.getRequestDispatcher("jsp/index.ftl").forward(request, response);
    }
}