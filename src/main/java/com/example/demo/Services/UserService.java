package com.example.demo.Services;

import com.example.demo.Models.User;
import com.example.demo.Models.UserDTO;
import com.example.demo.Repositories.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserRepository userRepository;

    public User getUserById(@NotNull Integer userId) {
        return userRepository.getReferenceById(userId);
    }

    public String addNewUser(User user){
        if(userRepository.existsById(user.getUserId())){
            return "User already exists";
        }
        else{
            userRepository.save(user);
            return "Success";
        }

    }

    public List<UserDTO> getUserList() {
        List<User> users =  userRepository.findAll();
        return users.stream().map(x -> objectMapper.convertValue(x, UserDTO.class)).toList();
    }
}
