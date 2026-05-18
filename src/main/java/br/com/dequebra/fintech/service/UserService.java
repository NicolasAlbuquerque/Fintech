package br.com.dequebra.fintech.service;

import br.com.dequebra.fintech.model.User;
import br.com.dequebra.fintech.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService{

    @Autowired
    private UserRepository userRepository;

    public User save(User user){
        return userRepository.save(user);
    }

    public User findById(Long id){
        Optional<User> user = userRepository.findById(id);

        if(user.isPresent()){
            return user.get();
        }else {
            throw new RuntimeException("User not found.");
        }
    }

    public List<User> findAll(){
        return  userRepository.findAll();
    }


    public void delete(Long id){
        Optional<User> user = userRepository.findById(id);

        if(user.isPresent()){
            userRepository.deleteById(id);
        }else{
            throw new RuntimeException("User not found.");
        }
    }

    public User update(Long id, User user){
        Optional<User> userNow = userRepository.findById(id);

        if(userNow.isPresent()){
            return  userRepository.save(user);
        }else{
            throw new RuntimeException("User not found.");
        }
    }
}
