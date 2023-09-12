package com.intern.theara.springsecurity.JavaTechie_SpringSecurity.service;

import com.intern.theara.springsecurity.JavaTechie_SpringSecurity.model.User;
import com.intern.theara.springsecurity.JavaTechie_SpringSecurity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    public List<User> findAll(){
        return userRepository.findAll();
    }
    public User save(User user){
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User update(User user,long id){
        User user1 = userRepository.findById(id).get();
        user1.setId(id);
        user1.setFirstName(user.getFirstName());
        user1.setLastName(user.getLastName());
        user1.setEmail(user.getEmail());
        user1.setPassword(user.getPassword());
        user1.setRole(user.getRole());
        userRepository.save(user1);
        return user1;
    }
    public void delete(long id){
        userRepository.deleteById(id);
    }
}
