package DelegationService;

import DelegationService.Repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;




@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
public class DelegationServiceApp {
    public static void main(String[] args) {
        SpringApplication.run(DelegationServiceApp.class, args);
    }
}