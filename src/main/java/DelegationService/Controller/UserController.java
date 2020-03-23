package DelegationService.Controller;

import DelegationService.Model.User;
import DelegationService.Service.UserServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/rest/user")
public class UserController {

    @Autowired
    private UserServ userServ;

    @PostMapping("/register")
    @ResponseBody
    public void registerUser(@RequestBody User userNew){
        userServ.registerUser(userNew);
    }

    @GetMapping("/getAllUsers")
    @ResponseBody
    public List<User> getAllUsers(){
        return userServ.getAllUsers();
    }

    @GetMapping("/gettAllUsersByRole")
    @ResponseBody
    public List<User> gettAllUsersByRole(String roleName){
        return userServ.getAllUsersByRoleName(roleName);
    }

    @PutMapping("/changePassword")
    @ResponseBody
    public void changePasword(@RequestParam long userId, @RequestParam String passwordNew){
        userServ.changePassword(userId, passwordNew);
    }

    @DeleteMapping("/deleteUserById")
    @ResponseBody
    public boolean deleteUserById(@RequestParam long userId){
        return userServ.deleteUserById(userId);
    }

}
