package com.digitalhouse.praticahql.repository;

import com.digitalhouse.praticahql.repository.collection.UserData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserData, String> {

}
