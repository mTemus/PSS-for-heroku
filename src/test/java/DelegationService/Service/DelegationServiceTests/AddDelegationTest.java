package DelegationService.Service.DelegationServiceTests;

import DelegationService.Model.Delegation;
import DelegationService.Model.User;
import DelegationService.Repository.DelegationRepository;
import DelegationService.Repository.UserRepository;
import DelegationService.Service.DelegationService;
import DelegationService.Service.UserService;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AddDelegationTest {

    @Autowired
    private DelegationRepository testDelegationRepository;

    @Autowired
    private UserRepository testUserRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private DelegationService testDelegationService;

    @Test
    public void addDelegation() {

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

        Date startDate = new Date();
        Date endDate = new Date();
        endDate.setYear(2020);
        endDate.setMonth(Calendar.DECEMBER);
        endDate.setDate(23);
        endDate.setHours(3);
        endDate.setMinutes(0);
        endDate.setSeconds(0);

        Delegation testDelegation = new Delegation("Lunapark",startDate, endDate);

        testDelegationService.addDelegation(1, testDelegation);

        List<Delegation> foundDelegations = testDelegationRepository.findAll();

        for (Delegation d: foundDelegations) {
            if (d.equals(testDelegation)) {
                Assertions.assertThat(d).isEqualTo(testDelegation);
            }
        }

    }
}