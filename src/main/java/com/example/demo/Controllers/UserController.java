package com.example.demo.Controllers;

import com.example.demo.Models.User;
import com.example.demo.Models.UserDTO;
import com.example.demo.Services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/EventBook")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("Register")
    public ResponseEntity<String> addUser(@Valid @RequestBody User user){
        return new ResponseEntity<>(userService.addNewUser(user), HttpStatus.OK);
    }

    @GetMapping("Users")
    public ResponseEntity<List<UserDTO>> getUsers(){
        List<UserDTO> dto = userService.getUserList();
       return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
