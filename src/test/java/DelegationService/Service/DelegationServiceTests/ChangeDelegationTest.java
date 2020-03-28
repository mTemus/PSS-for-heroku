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
public class ChangeDelegationTest {

    @Autowired
    private DelegationRepository testDelegationRepository;

    @Autowired
    private UserRepository testUserRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private DelegationService testDelegationService;

    Delegation testDelegation;

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
        Date startDate = new Date();
        Date endDate = new Date();
        endDate.setYear(2020);
        endDate.setMonth(Calendar.DECEMBER);
        endDate.setDate(23);
        endDate.setHours(3);
        endDate.setMinutes(0);
        endDate.setSeconds(0);

        testDelegation = new Delegation("Lunapark", startDate, endDate);
        entityManager.persist(testDelegation);
        entityManager.flush();
    }

    @Test
    public void changeDelegation() {
        testDelegation.setDescription("Aquapark");
        testDelegation.setDateTimeStart(new Date());

        testDelegationService.changeDelegation(1, testDelegation);

        Delegation modifiedDelegation = entityManager.find(Delegation.class, 1);

        Assertions.assertThat(modifiedDelegation).isEqualTo(testDelegation);
    }
}