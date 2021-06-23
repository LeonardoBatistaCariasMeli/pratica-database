package com.digitalhouse.praticahql.service;

import com.digitalhouse.praticahql.dto.request.UserRequest;
import com.digitalhouse.praticahql.dto.response.UserResponse;
import com.digitalhouse.praticahql.repository.collection.UserData;

import java.util.List;

public interface UserService {
    public List<UserResponse> findAllUsers();

//    public List<UserResponse> findByUserNameContains(String name);

    public UserResponse findUserById(String id);

    public UserData createUser(UserRequest request);

    public void deleteUser(String id);

//    public void updateUserPassword(UserRequest request);
}
