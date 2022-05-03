package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import form.RequestForm;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
import repositories.old.MatcheRepositoryImpl;


import javax.servlet.ServletException;
import javax.servlet.UnavailableException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class RequestServlet extends HttpServlet {

    private MatcheRepositoryImpl matcheRepository;
    private Connection connection;

    private final String DB_URL="jdbc:postgresql://localhost:5432/postgres";
    private final String DB_USERNAME = "postgres";
    private final String DB_PASSWORD = "postgres";

    private static final String MY_EMAIL = "ziyangirovr@mail.ru";
    private static final String MY_PASSWORD = "Z563211563211h";

      @Override
      public void init() throws ServletException {

          //Подгружаем драйвер, оно автоматически регистрирует JDBC
          try {
              Class.forName("org.postgresql.Driver");
              //Cоздаем подключение к БД
              connection = DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);

          }catch (ClassNotFoundException | SQLException e){

              System.out.println("Unavailable");
              throw new UnavailableException("Сайт недоступен!!!");
          }
      }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        request.getRequestDispatcher("/m").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        matcheRepository = new MatcheRepositoryImpl(connection);

//        request.setCharacterEncoding("UTF-8");
//        String first_name = request.getParameter("firstNameRequest");
//        String second_name = request.getParameter("secondNameRequest");
//        String email = request.getParameter("emailRequest");
//
//        RequestForm requestForm = new RequestForm();
//        requestForm.setFirstName(first_name);
//        requestForm.setSecondName(second_name);
//        requestForm.setEmail(email);

        ObjectMapper objectMapper = new ObjectMapper();
        RequestForm requestForm = objectMapper.readValue(request.getParameter("request"), RequestForm.class);



        System.out.println("Я побывал реквест сервлете");
        System.out.println(requestForm);

        try {
            Email emailMessage = new SimpleEmail();

            // Configuration
            emailMessage.setSmtpPort(25);
            emailMessage.setAuthenticator(new DefaultAuthenticator(MY_EMAIL, MY_PASSWORD));
            emailMessage.setHostName("smtp.mail.ru");
            emailMessage.setSSLOnConnect(true);


            // Отправитель
            emailMessage.setFrom(MY_EMAIL);

            // Тема сообщения
            emailMessage.setSubject("Расписание футбольных матчей");

            // Текст сообщения.
            emailMessage.setMsg(requestForm.getFirstName()+" "+requestForm.getSecondName()+" вы заполняли форму на сайте" +
                    " FootballWatch - вот ваше расписание:\n" +
                    matcheRepository.findAll());

            // Получатель
            emailMessage.addTo(requestForm.getEmail());
            emailMessage.send();
            response.sendRedirect("/m");
            System.out.println("Сообщение было отправлено!!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Сообщение не отправилось(((");
        }


    }
}
