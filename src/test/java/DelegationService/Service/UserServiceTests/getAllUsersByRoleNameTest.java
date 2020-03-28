package DelegationService.Service.UserServiceTests;

import DelegationService.Model.Role;
import DelegationService.Model.User;
import DelegationService.Other.RoleTypes;
import DelegationService.Repository.RoleRepository;
import DelegationService.Repository.UserRepository;
import DelegationService.Service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class getAllUsersByRoleNameTest {

    @Autowired
    private UserRepository testUserRepository;

    @Autowired
    private RoleRepository testRoleRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserService testUserService;

    List<User> createdUsersWithRoleUSER;

    @Before
    public void setUp() {
        Set<Role> USERRoles = new HashSet<>();
        Set<Role> ADMINRoles = new HashSet<>();

        Role userRole = new Role();
        userRole.setRoleName(RoleTypes.USER);
        Role adminRole = new Role();
        adminRole.setRoleName(RoleTypes.ADMIN);
        USERRoles.add(userRole);
        ADMINRoles.add(adminRole);

        entityManager.persist(adminRole);
        entityManager.persist(userRole);
        entityManager.flush();

        createdUsersWithRoleUSER = new ArrayList<>();

        User testUser1 = new User(
                "Grupa 4",
                "Kaliskiego 6/9",
                "123456789",
                "Maurycy",
                "Łamignat",
                "123@wp.pl",
                "admin1234");
        testUser1.setRoles(ADMINRoles);

        User testUser2 = new User(
                "Grupa 3",
                "Fordońska 132",
                "12356242",
                "Kazimierz",
                "Testowicz",
                "kaztes@o2.pl",
                "1234admin");
        testUser2.setRoles(ADMINRoles);

        User testUser3 = new User(
                "Grupa 4",
                "Kaliskiego 6/9",
                "123456789",
                "Jakub",
                "Mlekowski",
                "88wjd@wir.pl",
                "mocneh4slo$");
        testUser3.setRoles(USERRoles);

        User testUser4 = new User(
                "Grupa 1",
                "Uniwersytecka 66",
                "2442842",
                "Eryk",
                "Daniel",
                "sarna77@wp.pl",
                "buszmen38");
        testUser4.setRoles(USERRoles);

        createdUsersWithRoleUSER.add(testUser3);
        createdUsersWithRoleUSER.add(testUser4);

        entityManager.persist(testUser1);
        entityManager.persist(testUser2);
        entityManager.persist(testUser3);
        entityManager.persist(testUser4);
        entityManager.flush();
    }

    @Test
    public void getAllUsersByRoleName() {
        List<User> usersWithUserRole = testUserService.getAllUsersByRoleName("USER");
        Assert.assertEquals(createdUsersWithRoleUSER, usersWithUserRole);
    }
}