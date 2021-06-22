package com.digitalhouse.praticahql.dto.request;

public class UserRequest {

    private Long id;
    private String password;

    public UserRequest() {
    }

    public UserRequest(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
