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
public class GetAllDelegationsOrderByDateStartDescTest {

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
        startDate.setTime(11111);
        Date endDate = new Date();
        endDate.setYear(2020);
        endDate.setMonth(Calendar.DECEMBER);
        endDate.setDate(23);
        endDate.setHours(3);
        endDate.setMinutes(0);
        endDate.setSeconds(0);

        Delegation testDelegation1 = new Delegation("Lunapark", startDate, endDate);

        startDate = new Date();
        startDate.setTime(842423);
        endDate = new Date();
        endDate.setYear(2022);
        endDate.setMonth(Calendar.JANUARY);
        endDate.setDate(31);
        endDate.setHours(15);
        endDate.setMinutes(30);
        endDate.setSeconds(0);

        Delegation testDelegation2 = new Delegation("Wynalezienie szczepionki na koronawirusa", startDate, endDate);

        startDate = new Date();
        startDate.setTime(251252222);
        endDate = new Date();
        endDate.setYear(2021);
        endDate.setMonth(Calendar.APRIL);
        endDate.setDate(15);
        endDate.setHours(0);
        endDate.setMinutes(0);
        endDate.setSeconds(0);

        Delegation testDelegation3 = new Delegation("Badania nad wplywem masla orzechowego na ruch obrotowy Ziemi", startDate, endDate);

        entityManager.persist(testDelegation1);
        entityManager.persist(testDelegation3);
        entityManager.persist(testDelegation2);
        entityManager.flush();

        createdDelegations.add(testDelegation3);
        createdDelegations.add(testDelegation2);
        createdDelegations.add(testDelegation1);
    }

    @Test
    public void getAllDelegationsOrderByDateStartDesc() {
        List<Delegation> orderedDelegations = testDelegationService.getAllDelegationsOrderByDateStartDesc();

        Assertions.assertThat(orderedDelegations).isEqualTo(createdDelegations);
    }
}