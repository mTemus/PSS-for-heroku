package DelegationService.Service;

import DelegationService.Model.Delegation;
import DelegationService.Model.User;
import DelegationService.Repository.DelegationRepository;
import DelegationService.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DelegationServ {

    @Autowired
    UserRepository userRepository;

    @Autowired
    DelegationRepository delegationRepository;

    public List<Delegation> getAllByUserId(long userId){
        return userRepository.findById((int)userId).map(User::getDelegation).get();
    }

    public void addDelegation(long userId, Delegation delegation){
        List<Delegation> userDelegation = userRepository.findById((int)userId).map(User::getDelegation).get();
        userDelegation.add(delegation);
        userRepository.findById((int)userId).map(user -> {
            user.setDelegation(userDelegation);
            return userRepository.save(user);
        });
    }

    public boolean removeDelegation(long userId, long delegationId){
        boolean userExist = userRepository.findAll().removeIf(user -> user.getIduser() == (int)userId);
        boolean delegationExist = delegationRepository.findAll().removeIf(user -> user.getIdDelegation() == (int)delegationId);
        if(userExist&&delegationExist){
            delegationRepository.deleteById((int) delegationId);
            return true;
        }else{
            return false;
        }
    }

    public void changeDelegation(long delegationId, Delegation delegation){
        delegationRepository.findById((int)delegationId).map(delegation1 -> {
            delegation1 = delegation;
            return delegationRepository.save(delegation1);
        });
    }

    public List<Delegation> getAllDelegation(){
        return delegationRepository.findAll();
    }

    public List<Delegation> getAllDelegationsOrderByDateStartDesc(){
        return delegationRepository.findAll().stream()
                .sorted(Comparator.comparing(Delegation::getDateTimeStart, Comparator.reverseOrder()))
                .collect(Collectors.toList());
    }

    public List<Delegation> getAllDelegationsByUserOrderByDateStartDesc(long userId){
        return  getAllByUserId(userId).stream()
                .sorted(Comparator.comparing(Delegation::getDateTimeStart, Comparator.reverseOrder()))
                .collect(Collectors.toList());
    }
}
