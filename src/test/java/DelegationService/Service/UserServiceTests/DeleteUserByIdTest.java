package DelegationService.Service.UserServiceTests;

import DelegationService.Model.User;
import DelegationService.Repository.UserRepository;
import DelegationService.Service.UserService;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
@DataJpaTest
public class DeleteUserByIdTest {

    @Autowired
    private UserRepository testUserRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserService testUserService;

    @Test
    public void deleteUserById() {

        List<User> expectedUsers = new ArrayList<>();

        User testUser1 = new User(
                "Grupa 4",
                "Kaliskiego 6/9",
                "123456789",
                "Maurycy",
                "Łamignat",
                "123@wp.pl",
                "admin1234");
        User testUser2 = new User(
                "Grupa 3",
                "Fordońska 132",
                "12356242",
                "Kazimierz",
                "Testowicz",
                "kaztes@o2.pl",
                "1234admin");

        entityManager.persist(testUser1);
        entityManager.persist(testUser2);

        expectedUsers.add(testUser1);
        expectedUsers.add(testUser2);

        testUserService.deleteUserById(2);
        expectedUsers.remove(1);

        List<User> allUsersInDatabase = testUserService.getAllUsers();

        Assertions.assertThat(allUsersInDatabase).isEqualTo(expectedUsers);
    }
}