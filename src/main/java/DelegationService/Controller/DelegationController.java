package DelegationService.Controller;

import DelegationService.Model.Delegation;
import DelegationService.Service.DelegationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("rest/delegation")
public class DelegationController {
    @Autowired
    DelegationService delegationService;

    @PostMapping("/addDelegation")
    @ResponseBody
    public void addDelegation(long userId, Delegation delegation){
        delegationService.addDelegation(userId,delegation);
    }

    @DeleteMapping("/removeDelegation")
    @ResponseBody
    public void removeDelegation(long userId, long delegationId){
        delegationService.removeDelegation(userId, delegationId);
    }

    @PutMapping("/changeDelegation")
    @ResponseBody
    public void changeDelegation(long delegationId, Delegation delegation){
        delegationService.changeDelegation(delegationId, delegation);
    }

    @GetMapping("/getAllDelegtions")
    @ResponseBody
    List<Delegation> getAllDelegations(){
        return delegationService.getAllDelegation();
    }

    @GetMapping("/getAllDelegationsOrderByDateStartDesc")
    @ResponseBody
    List<Delegation> getAllDelegationsOrderByDateStartDesc(){
        return delegationService.getAllDelegationsOrderByDateStartDesc();
    }

    @GetMapping("/getAllDelegationsByUserOrderByDateStartDesc")
    @ResponseBody
    List<Delegation> getAllDelegationsByUserOrderByDateStartDesc(long userId){
        return delegationService.getAllDelegationsByUserOrderByDateStartDesc(userId);
    }
}
