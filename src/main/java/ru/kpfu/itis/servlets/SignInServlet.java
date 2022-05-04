package ru.kpfu.itis.servlets;

import ru.kpfu.itis.form.LoginForm;
import ru.kpfu.itis.services.UsersService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignInServlet extends HttpServlet {

    private UsersService usersService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext servletContext = config.getServletContext();
        usersService = (UsersService) servletContext.getAttribute("usersService");
    }

    private final String DB_URL="jdbc:postgresql://localhost:5432/postgres";
    private final String DB_USERNAME = "postgres";
    private final String DB_PASSWORD = "postgres";

/*    @Override
    public void init() throws ServletException {

        //Подгружаем драйвер, оно автоматически регистрирует JDBC
        try {
            Class.forName("org.postgresql.Driver");
            //Cоздаем подключение к БД
            Connection connection = DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);

            UsersRepository usersRepository = new UsersRepositoryImpl(connection);
            AuthRepository authRepository = new AuthRepositoryImpl(connection);
            usersService = new UsersServicesImpl(usersRepository,authRepository);


        }catch (ClassNotFoundException | SQLException e){

            System.out.println("Unavailable");
            throw new UnavailableException("Сайт недоступен!!!");
        }
    }*/



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/m").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");


        LoginForm loginForm = new LoginForm(login,password);
        System.out.println(loginForm);

        Cookie cookie = usersService.signIn(loginForm);


        if(cookie != null) {
            response.addCookie(cookie);

            response.sendRedirect("/m");
            request.getSession().setAttribute("signInStatus",' ');
            request.getSession().setAttribute("name","Вы авторизовались под логином - "+ login);
            System.out.println(cookie.getValue());


        }else{
            request.setAttribute("name"," ");
            request.setAttribute("signInStatus","Неправильный логин или пароль");
            request.getRequestDispatcher("/m").forward(request,response);
        }

    }
}
