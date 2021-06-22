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

    @Query(value = "SELECT * FROM user as u", nativeQuery = true)
    public List<UserData> findAllUsers();

    @Query(value = "SELECT * FROM user as u WHERE u.name LIKE %:name%", nativeQuery = true)
    public List<UserData> getUserByNameContains(@Param("name") String name);

    @Query(value = "SELECT * FROM user as u WHERE u.id = :id", nativeQuery = true)
    public UserData getUserById(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM user WHERE id = :id", nativeQuery = true)
    public void deleteUser(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE user as u SET password=:password WHERE u.id = :id", nativeQuery = true)
    public void updateUserPassword(@Param("password") String password, @Param("id") Long id);

}
