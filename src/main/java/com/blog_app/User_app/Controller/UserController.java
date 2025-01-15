package com.blog_app.User_app.Controller;

import com.blog_app.User_app.Request.UserRequest;
import com.blog_app.User_app.Response.UserResponse;
import com.blog_app.User_app.Service.UserService;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/post")
            public void createUser(@RequestBody UserRequest request) {
        userService.createUser(request);
    }


    @GetMapping("/getAll")
            public List<UserResponse> getAll(){
        return userService.getAll();
    }


    @GetMapping("/getById/{userId}")
            public UserResponse getById(@PathVariable Long userId){
        return userService.getById(userId);
    }


    @GetMapping("/isUserExist/{userId}")
    public boolean findUserId(@PathVariable Long userId){
       return userService.findUserId(userId);
    }
}
