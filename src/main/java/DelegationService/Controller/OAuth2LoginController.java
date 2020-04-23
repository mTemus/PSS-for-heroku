package DelegationService.Controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@SpringBootApplication
@RestController
public class OAuth2LoginController {

    // 8080/oauth2/authorization/github
    // 8080/oauth2/authorization/google

    @GetMapping("/oa2_user")
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
        Map<String, Object> userData = new HashMap<>();

        userData.put("name", principal.getAttribute("name"));
        userData.put("email", principal.getAttribute("email"));
        userData.put("company", principal.getAttribute("company"));
        userData.put("location", principal.getAttribute("location"));

        return userData;
    }
}
