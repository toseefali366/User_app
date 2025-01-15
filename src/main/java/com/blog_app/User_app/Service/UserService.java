package com.blog_app.User_app.Service;

import com.blog_app.User_app.Model.User;
import com.blog_app.User_app.Repository.UserRepository;
import com.blog_app.User_app.Request.UserRequest;
import com.blog_app.User_app.Response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
private UserRepository userRepository;

    public void createUser(UserRequest request) {
        User user = new User();
        user.setUserName(request.getUserName());
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
        userRepository.save(user);
    }

    public List<UserResponse> getAll() {
        List<User> list1 = userRepository.findAll();
        List<UserResponse> list = list1.stream().map(UserResponse::new).toList();
        return  list;
    }

    public UserResponse getById(Long userId) {
    return new UserResponse(userRepository.findById(userId)
            .orElseThrow(()->new RuntimeException("id not found")));
    }

    public boolean findUserId(Long userId) {
       return userRepository.existsById(userId);
    }
}
