package DelegationService.Service;

import DelegationService.Other.RoleTypes;
import DelegationService.Model.Role;
import DelegationService.Model.User;
import DelegationService.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public void registerUser(User userNew){
        userRepository.save(userNew);
    }

    public List<User> getAllUsers(){
        return  userRepository.findAll();
    }

    public List<User> getAllUsersByRoleName(String roleName){
        if(roleName.equals("USER")) return userRepository.findByRoles(new Role(RoleTypes.USER));
        else{
            return userRepository.findByRoles(new Role(RoleTypes.ADMIN));
        }
    }

    public void changePassword(long userId, String passwordNew){
        userRepository.findById((int)userId).map(user -> {
            user.setPassword(passwordNew);
            return userRepository.save(user);
        });
    }

    public boolean deleteUserById(long userId){
        boolean exist = userRepository.findAll().removeIf(user -> user.getIduser() == (int)userId);
        if(exist){
            userRepository.deleteById((int)userId);
            return true;
        }else{
            return false;
        }
    }
}
