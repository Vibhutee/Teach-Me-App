package com.teach.me.app.Controller;

import com.teach.me.app.DTO.UserDTO;
import com.teach.me.app.Enum.UserType;
import com.teach.me.app.Exception.UserNotFoundException;
import com.teach.me.app.Model.User;
import com.teach.me.app.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    private ResponseEntity insertUser(@RequestBody User user){
        user.setUserType(UserType.valueOf(user.getUserType().toString()));
        User newUser = userService.insertUser(user);
        return ResponseEntity.ok().body(newUser);
    }
    @GetMapping("/all")
    private List<User> getAllUser(){
        List<User> userList = new ArrayList<User>();
        userList = userService.getAllUsers();
        return  userList;
    }
    @GetMapping("/{userId}")
    private User getUserById(@PathVariable int userId) throws UserNotFoundException {
        return userService.getUserById(userId);
    }

    @PostMapping("/login")
    private ResponseEntity loginUser(@RequestBody UserDTO user) {
        User existingUser = userService.getUserForLogin(user);
        return ResponseEntity.ok().body(existingUser);
    }
}
