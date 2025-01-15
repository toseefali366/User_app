package com.blog_app.User_app.Response;

import com.blog_app.User_app.Model.User;
import lombok.Data;

@Data
public class UserResponse {
    private Long userId;
    private String userName;
    private String password;
    private String email;

    public UserResponse(User user) {
        this.userId =user.getUserId();
        this.userName = user.getUserName();
        this.password = user.getPassword();
        this.email = user.getEmail();
    }
}
