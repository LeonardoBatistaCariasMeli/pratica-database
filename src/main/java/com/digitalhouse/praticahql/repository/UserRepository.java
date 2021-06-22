package com.digitalhouse.praticahql.repository;

import com.digitalhouse.praticahql.repository.entity.UserData;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<UserData, Long> {

    @Query("SELECT u FROM UserData u")
    public List<UserData> findAllUsers();

    @Query("SELECT u FROM UserData u WHERE u.name LIKE %:name%")
    public List<UserData> getUserByNameContains(@Param("name") String name);

    @Query("SELECT u FROM UserData u WHERE u.id = :id")
    public UserData getUserById(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query("DELETE FROM UserData WHERE id = :id")
    public void deleteUser(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query("UPDATE UserData SET password=:password WHERE id = :id")
    public void updateUserPassword(@Param("password") String password, @Param("id") Long id);

}
