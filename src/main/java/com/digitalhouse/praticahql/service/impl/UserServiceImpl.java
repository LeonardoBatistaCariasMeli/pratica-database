package com.digitalhouse.praticahql.service.impl;

import com.digitalhouse.praticahql.dto.request.UserRequest;
import com.digitalhouse.praticahql.dto.response.UserResponse;
import com.digitalhouse.praticahql.repository.UserRepository;
import com.digitalhouse.praticahql.repository.collection.UserData;
import com.digitalhouse.praticahql.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserResponse> findAllUsers() {
        var list = userRepository.findAll();
        return this.fromListUserData(list);
    }

//    @Override
//    public List<UserResponse> findByUserNameContains(String name) {
//        var list = userRepository.getUserByNameContains(name);
//        return this.fromListUserData(list);
//    }

    @Override
    public UserResponse findUserById(String id) {
        var data = userRepository.findById(id);
        return this.fromUserData(data.get());
    }

    @Override
    public UserData createUser(UserRequest request) {
        return userRepository.save(new UserData(request.getName(), request.getEmail(), request.getPassword()));
    }

    @Override
    public void deleteUser(String id) {
       userRepository.deleteById(id);
    }

//    @Override
//    public void updateUserPassword(UserRequest request) {
//        userRepository.updateUserPassword(request.getPassword(), request.getId());
//    }

    private List<UserResponse> fromListUserData(List<UserData> list) {
        return list.stream().map(d -> this.fromUserData(d)).collect(Collectors.toList());
    }

    private UserResponse fromUserData(UserData data) {
        return new UserResponse(data.getId(), data.getName(), data.getEmail(), data.getPassword());
    }
}
