package DelegationService.Service.UserServiceTests;

import DelegationService.Model.User;
import DelegationService.Repository.UserRepository;
import DelegationService.Service.UserService;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RegisterUserTest {

    @Autowired
    private UserRepository testUserRepository;

    @Autowired
    private UserService testUserService;

    @Before
    public void setUp() {

    }

    @Test
    public void registerUser() {
        User testUser = new User(
                "Grupa 4",
                "Kaliskiego 6/9",
                "123456789",
                "Maurycy",
                "Łamignat",
                "123@wp.pl",
                "admin1234");

        testUserService.registerUser(testUser);

        List<User> foundUsers = testUserRepository.findAll();

        for (User u: foundUsers) {
            if (u.equals(testUser)) {
                Assertions.assertThat(u).isEqualTo(testUser);
            }
        }

    }
}