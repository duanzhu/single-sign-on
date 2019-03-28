package com.sunpeihua.login.repository;

import com.sunpeihua.login.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends CrudRepository<UserEntity, String> {
    UserEntity findByUsername(String username);
}
