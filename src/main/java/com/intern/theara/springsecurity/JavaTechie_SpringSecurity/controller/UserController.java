package com.intern.theara.springsecurity.JavaTechie_SpringSecurity.controller;

import com.intern.theara.springsecurity.JavaTechie_SpringSecurity.dto.UserRequest;
import com.intern.theara.springsecurity.JavaTechie_SpringSecurity.model.User;
import com.intern.theara.springsecurity.JavaTechie_SpringSecurity.service.JwtService;
import com.intern.theara.springsecurity.JavaTechie_SpringSecurity.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final JwtService jwtService;
    @GetMapping(value = "/get-all")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<List<User>> findAll(){
        return ResponseEntity.ok(userService.findAll());
    }
    @PostMapping(value = "/add-new-user")

    public ResponseEntity<User> save(@RequestBody User user){
        return ResponseEntity.ok(userService.save(user));
    }
    @PutMapping(value = "/update-user/{id}")
    public ResponseEntity<User> update(@RequestBody User user ,@PathVariable(name = "id") long id ){
        return ResponseEntity.ok(userService.update(user,id));
    }

    @DeleteMapping(value = "/delete-by-id/{id}")
    public ResponseEntity<?> delete(@PathVariable long id){
        userService.delete(id);
        return ResponseEntity.ok("Delete success");
    }
    @PostMapping(value = "/authenticate")
    public String authenticationToken(@RequestBody UserRequest userRequest){
        return jwtService.generateToken(userRequest.getEmail());
    }
}
