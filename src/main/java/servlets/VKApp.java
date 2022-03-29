//package servlets;
//
//import com.google.gson.Gson;
//import com.vk.api.sdk.client.Lang;
//import com.vk.api.sdk.client.TransportClient;
//import com.vk.api.sdk.client.VkApiClient;
//import com.vk.api.sdk.client.actors.UserActor;
//import com.vk.api.sdk.exceptions.ApiException;
//import com.vk.api.sdk.exceptions.ClientException;
//import com.vk.api.sdk.httpclient.HttpTransportClient;
//import com.vk.api.sdk.objects.UserAuthResponse;
//import com.vk.api.sdk.objects.users.responses.GetResponse;
//import form.UserForm;
//import models.User;
//import repositories.old.AuthRepository;
//import repositories.old.AuthRepositoryImpl;
//import repositories.old.UsersRepository;
//import repositories.old.UsersRepositoryImpl;
//import services.UsersService;
//import services.UsersServicesImpl;
//
//import javax.servlet.ServletException;
//import javax.servlet.UnavailableException;
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//public class VKApp {
////    public static void main(String[] args) {
////        TransportClient transportClient = HttpTransportClient.getInstance();
////        VkApiClient vk = new VkApiClient(transportClient);
////
////        UserActor userActor = new UserActor(7984737,"nV2T8XznTF7M3vgIu1Pc");
////
////    }
//
//    private UsersService usersService;
//
//    private final String DB_URL ="jdbc:postgresql://localhost:5432/postgres";
//    private final String DB_USERNAME = "postgres";
//    private final String DB_PASSWORD = "postgres";
//
//    @Override
//    public void init() throws ServletException {
//        super.init();
//        try {
//            Class.forName("org.postgresql.Driver");
//            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5434/postgres");
//            AuthRepository authRepository = new AuthRepositoryImpl(connection);
//            UsersRepository usersRepository = new UsersRepositoryImpl(connection);
//            usersService = new UsersServicesImpl(usersRepository,authRepository);
//        } catch (ClassNotFoundException | SQLException e ) {
//            System.out.println("Fail!");
//            throw new UnavailableException("Сайт недоступен!");
//        }
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        try {
//            TransportClient transportClient = HttpTransportClient.getInstance();
//            VkApiClient vk = new VkApiClient(transportClient, new Gson(), 5);
//
//            String code = req.getParameter("code");
//            UserAuthResponse authResponse = vk.oauth()
//                    .userAuthorizationCodeFlow(7997612, "PY7d7v2zPh1fbPEuNK7l", "http://localhost:8080/vk", code)
//                    .execute();
//
//            UserActor actor = new UserActor(authResponse.getUserId(), authResponse.getAccessToken());
//            System.out.println(actor.getAccessToken());
//
//            GetResponse account = vk.users().get(actor)
//                    .userIds(actor.getId().toString())
//                    .lang(Lang.RU)
//                    .unsafeParam("v", "5.131")
//                    .execute().get(0);
//
//            System.out.println(account.getLastName() + account.getFirstName());
//            UserForm userForm = new UserForm();
//            userForm.setLogin(account.getFirstName());
//            userForm.setPassword(account.getLastName());
//            User user = usersService.register(userForm);
//            Cookie cookie = usersService.signIn(userForm);;
//            if (cookie != null) {
//                System.out.println("in cookie if SignInServlet");
//
//                resp.addCookie(cookie);
//                resp.sendRedirect("/m");
//// req.getRequestDispatcher("jsp/mainPage.jsp").forward(req,resp);
//
//            } else {
//
//                req.getRequestDispatcher("jsp/index.jsp").forward(req,resp);
//            }
//
//        } catch (ClientException | ApiException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//}
