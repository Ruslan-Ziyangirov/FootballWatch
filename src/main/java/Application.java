import models.Authorization;
import models.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import repositories.AuthRepository;
import repositories.UserRepository;
import repositories.UserRepositoryJdbcTemplateImpl;

import javax.sql.DataSource;

public class Application {
    public static void main(String[] args) {
//        String url="jdbc:postgresql://localhost:5432/postgres";
//        String username = "postgres";
//        String password = "postgres";
//
//        DataSource dataSource = new DriverManagerDataSource(url, username, password);
//        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//        UserRepository userRepository = new UserRepositoryJdbcTemplateImpl(jdbcTemplate);

        User user = new User();
        user.setFirst_name("gfdg");
        user.setSecond_name("gfddww");
        user.setPasswordHash("5435341");
        user.setLogin("dswwwww");
        user.setEmail("423432gf@mail.ru");

        Authorization authorization = new Authorization();
        authorization.setId(23L);
        authorization.setUser(user);
        authorization.setCookieValue("c294bdc5-e985-170e-954e-0e45355732b3");
//


//        System.out.println(userRepository.findById(440L).get());

        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        UserRepository userRepository = context.getBean(UserRepository.class);
        AuthRepository authRepository = context.getBean(AuthRepository.class);

        System.out.println(userRepository.save(user));
        System.out.println(userRepository.findById(440L).get());

        System.out.println(authRepository.save(authorization));
        System.out.println(authRepository.findByCookie("24db203c-7a5d-4f10-83ae-0dccbd74cde0").get());

    }
}
