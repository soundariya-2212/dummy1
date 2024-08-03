// package com.max.usecase.controllers;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.max.usecase.models.User;
// import com.max.usecase.services.UserServices;

// @RestController
// @RequestMapping("/users")
// public class UserController {

//     @Autowired
//     private UserServices uservice;

//     @GetMapping("/all")
//     public List<User> GetUsers() {
//         return uservice.getUsers();
//     }
//     @PostMapping("/register")
//     public User AddUser(@RequestBody User user){
//         return uservice.addUser(user);
//     }
// }



package com.max.usecase.controllers;

import com.max.usecase.models.User;
import com.max.usecase.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }
}
