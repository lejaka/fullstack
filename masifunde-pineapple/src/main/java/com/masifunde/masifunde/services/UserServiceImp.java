package com.masifunde.masifunde.services;

import com.masifunde.masifunde.models.User;
import com.masifunde.masifunde.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.transaction.Transactional;
import java.util.Optional;

@Service("UserService")
@Transactional
public class UserServiceImp implements UserService{
    @Autowired
    private UserRepository userRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImp.class);

    @Override
    public ResponseEntity<User> saveOrUpdate(User user){
        System.out.println("Is transaction open saveOrUpdate? "+ TransactionSynchronizationManager.isActualTransactionActive());
        ResponseEntity<User> responseEntity = null;
        Optional<User> optionalUser = userRepository.findById(user.getUser_id());
        if(!optionalUser.isPresent()){
            System.out.println("User with id "+ user.getUser_id() +" was not found");
        }
        try{
            if(optionalUser.isPresent()){
                //Update user details and return data
                responseEntity = userRepository.findById(user.getUser_id())
                        .map(record -> {
                            record.setDisplayName(user.getDisplayName());
                            record.setEmail(user.getEmail());
                            record.setPhotoURL(user.getPhotoURL());
                            User updated = userRepository.save(user);
                            return ResponseEntity.ok().body(updated);
                        }).orElse(ResponseEntity.notFound().build());
            }
            else{
                responseEntity = ResponseEntity.notFound().build();
            }
        }
        catch(RuntimeException e){
            LOGGER.error("User update exception: ", e.getMessage());
        }
        return responseEntity;
    }
}
