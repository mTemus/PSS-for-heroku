package DelegationService.Controller;

import DelegationService.Model.Delegation;
import DelegationService.Service.DelegationServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("rest/delegation")
public class DelegationController {
    @Autowired
    DelegationServ delegationServ;

    @PostMapping("/addDelegation")
    @ResponseBody
    public void addDelegation(long userId, Delegation delegation){
        delegationServ.addDelegation(userId,delegation);
    }

    @DeleteMapping("/removeDelegation")
    @ResponseBody
    public void removeDelegation(long userId, long delegationId){
        delegationServ.removeDelegation(userId, delegationId);
    }

    @PutMapping("/changeDelegation")
    @ResponseBody
    public void changeDelegation(long delegationId, Delegation delegation){
        delegationServ.changeDelegation(delegationId, delegation);
    }

    @GetMapping("/getAllDelegtions")
    @ResponseBody
    List<Delegation> getAllDelegations(){
        return delegationServ.getAllDelegation();
    }

    @GetMapping("/getAllDelegationsOrderByDateStartDesc")
    @ResponseBody
    List<Delegation> getAllDelegationsOrderByDateStartDesc(){
        return delegationServ.getAllDelegationsOrderByDateStartDesc();
    }

    @GetMapping("/getAllDelegationsByUserOrderByDateStartDesc")
    @ResponseBody
    List<Delegation> getAllDelegationsByUserOrderByDateStartDesc(long userId){
        return delegationServ.getAllDelegationsByUserOrderByDateStartDesc(userId);
    }
}
