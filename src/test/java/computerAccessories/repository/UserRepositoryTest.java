package computerAccessories.repository;

import computerAccessories.model.Role;
import computerAccessories.model.User;
import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static java.util.function.Predicate.not;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("DAO для работы с таблицей users")
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)

public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @DisplayName("метод должен уметь получать список пользователей")
    @Test
    public void shouldReturnCorrectAllProductList() {

        val user = new User();
        user.setId(1L);
        user.setLogin("Login");
        user.setPassword("Password");
        user.setRole(new ArrayList<>(List.of(new Role(1L, "admin", new ArrayList<User>()))));

        userRepository.save(user);

        val users = userRepository.findAll();

        users.forEach(System.out::println);

        assertThat(users).isNotNull()
                .allMatch(u -> u.getId() == user.getId())
                .allMatch(u -> u.getId() == user.getId())
                .allMatch(u -> u.getId() == user.getId())
                .allMatch(u -> u.getId() == user.getId());
    }

}
