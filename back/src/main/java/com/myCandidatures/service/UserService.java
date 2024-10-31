package com.myCandidatures.service;

import com.myCandidatures.model.User;
import com.myCandidatures.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public Map<String, String> authentification(String email, String password) {
        Map<String, String> response = new HashMap<>();
        Optional<User> employeeOption = userRepository.findByEmailAndPassword(email, password);
        if (employeeOption.isPresent()) {
            response.put("message", "Authentication success");
            return response;
        }
        response.put("message", "Authentication failed");
        return response;
    }

    public User getUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public void addNewUser(User user) {
        Optional<User> employeeByEmail = userRepository.findByEmail(user.getEmail());
        if (employeeByEmail.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        userRepository.save(user);
    }
}
