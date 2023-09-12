package com.intern.theara.springsecurity.JavaTechie_SpringSecurity.service;

import com.intern.theara.springsecurity.JavaTechie_SpringSecurity.model.SecurityUser;
import com.intern.theara.springsecurity.JavaTechie_SpringSecurity.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailService implements UserDetailsService {
    @Autowired
    private  UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository
                .findByEmail(username)
                .map(SecurityUser::new)
                .orElseThrow(()->new UsernameNotFoundException("Invalid for this user !!"));
    }
}
