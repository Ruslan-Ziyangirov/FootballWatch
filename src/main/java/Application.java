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
import java.util.List;

public class Application {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        UserRepository userRepository = context.getBean(UserRepository.class);

        User danil = User.builder()
                .first_name("Даниль")
                .second_name("Галеев")
                .build();

        User evelina = User.builder()
                .first_name("Эвелина")
                .second_name("Меметова")
                .build();

        User marat = User.builder()
                .first_name("Марат")
                .second_name("Гиниятов")
                .build();

        userRepository.saveAll(List.of(danil, evelina, marat));

    }
}
