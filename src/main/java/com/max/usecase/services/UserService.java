// package com.max.usecase.services;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.max.usecase.models.User;
// import com.max.usecase.repos.UserRepo;

// @Service
// public class UserServices {
//     @Autowired
//     private UserRepo urepo;


//     public List<User> getUsers(){
//         return urepo.findAll();
//     }

//     public User addUser(User user){
//         return urepo.save(user);
//     }
// }



package com.max.usecase.services;

import com.max.usecase.models.User;
import com.max.usecase.repos.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public ResponseEntity<User> getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public ResponseEntity<User> updateUser(Long id, User user) {
        if (userRepository.existsById(id)) {
            user.setUid(id);
            return ResponseEntity.ok(userRepository.save(user));
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<Void> deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
