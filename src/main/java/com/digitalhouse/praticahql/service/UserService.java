package com.digitalhouse.praticahql.service;

import com.digitalhouse.praticahql.dto.request.UserRequest;
import com.digitalhouse.praticahql.dto.response.UserResponse;

import java.util.List;

public interface UserService {
    public List<UserResponse> findAllUsers();

    public List<UserResponse> findByUserNameContains(String name);

    public UserResponse findUserById(Long id);

    public void deleteUser(Long id);

    public void updateUserPassword(UserRequest request);
}
