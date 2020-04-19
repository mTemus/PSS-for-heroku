package DelegationService.Service;

import DelegationService.Model.Role;
import DelegationService.Model.User;
import DelegationService.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    @Autowired
    UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) {
        User user = userRepository.findByEmail(email);
        if (user == null) throw new UsernameNotFoundException(email);

        ArrayList<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (Role role : user.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName().toString()));
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), passwordEncoder.encode(user.getPassword()), grantedAuthorities);
    }
}
