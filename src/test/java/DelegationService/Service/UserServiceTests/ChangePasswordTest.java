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
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ChangePasswordTest {

    @Autowired
    private UserRepository testUserRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserService testUserService;

    private User testUser;

    @Before
    public void setUp() {
       testUser = new User(
                "Grupa 4",
                "Kaliskiego 6/9",
                "123456789",
                "Maurycy",
                "Łamignat",
                "123@wp.pl",
                "admin1234");

        entityManager.persist(testUser);

        testUser.setPassword("mocneHaslo!9");
        testUserService.changePassword(1, "mocneHaslo!9");
    }

    @Test
    public void changePassword() {
        User addedUser = entityManager.find(User.class, 1);

        Assertions.assertThat(addedUser.getPassword()).isEqualTo(testUser.getPassword());
    }
}