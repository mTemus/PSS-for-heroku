package DelegationService.Service.DelegationServiceTests;

import DelegationService.Model.Delegation;
import DelegationService.Model.User;
import DelegationService.Repository.DelegationRepository;
import DelegationService.Repository.UserRepository;
import DelegationService.Service.DelegationService;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RemoveDelegationTest {

    @Autowired
    private DelegationRepository testDelegationRepository;

    @Autowired
    private UserRepository testUserRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private DelegationService testDelegationService;

    private List<Delegation> createdDelegations;

    @Before
    public void addUsersToDatabase() {
        User testUser = new User(
                "Grupa 4",
                "Kaliskiego 6/9",
                "123456789",
                "Maurycy",
                "Łamignat",
                "123@wp.pl",
                "admin1234");

        entityManager.persist(testUser);
        entityManager.flush();
    }

    @Before
    public void addDelegationsToDatabase() {
        createdDelegations = new ArrayList<>();

        Date startDate = new Date();
        Date endDate = new Date();
        endDate.setYear(2020);
        endDate.setMonth(Calendar.DECEMBER);
        endDate.setDate(23);
        endDate.setHours(3);
        endDate.setMinutes(0);
        endDate.setSeconds(0);

        Delegation testDelegation1 = new Delegation("Lunapark", startDate, endDate);
        createdDelegations.add(testDelegation1);
        entityManager.persist(testDelegation1);

        startDate = new Date();
        endDate = new Date();
        endDate.setYear(2022);
        endDate.setMonth(Calendar.JANUARY);
        endDate.setDate(31);
        endDate.setHours(15);
        endDate.setMinutes(30);
        endDate.setSeconds(0);

        Delegation testDelegation2 = new Delegation("Wynalezienie szczepionki na koronawirusa", startDate, endDate);
        createdDelegations.add(testDelegation2);
        entityManager.persist(testDelegation2);
        entityManager.flush();

        createdDelegations.remove(0);
    }


    @Test
    public void removeDelegation() {
        testDelegationService.removeDelegation(1,1);
        List<Delegation> delegationsInDatabase = testDelegationRepository.findAll();
        Assertions.assertThat(delegationsInDatabase).isEqualTo(createdDelegations);
    }
}