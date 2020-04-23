package DelegationService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.ResolvableType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@SpringBootApplication
@RestController
public class OAuth2LoginController {

    @Autowired
    private ClientRegistrationRepository clientRegistrationRepository;
    private static String authorizationRequestBaseUri = "oauth2/authorization";
    Map<String, String> oauth2AuthenticationUrls = new HashMap();

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


    @GetMapping("/oauth_login")
    public String getLoginPage(Model model) {
        Iterable<ClientRegistration> clientRegistrations = null;
        ResolvableType type = ResolvableType.forInstance(this.clientRegistrationRepository).as(Iterable.class);
        if (type != ResolvableType.NONE && ClientRegistration.class.isAssignableFrom(type.resolveGenerics()[0])) {
            clientRegistrations = (Iterable)this.clientRegistrationRepository;
        }

        clientRegistrations.forEach((registration) -> {
            String var10000 = (String)this.oauth2AuthenticationUrls.put(registration.getClientName(), authorizationRequestBaseUri + "/" + registration.getRegistrationId());
        });
        model.addAttribute("urls", this.oauth2AuthenticationUrls);
        return "oauth_login";
    }
}
