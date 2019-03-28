package com.sunpeihua.login;

import com.sunpeihua.login.entity.UserEntity;
import com.sunpeihua.login.repository.IUserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginApplicationTests {
    @Autowired
    private IUserRepository userRepository;
    @Test
    public void contextLoads() {
    }

    @Test
    public void insertUser() throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update("bifukwxf".getBytes());
        String password = new BigInteger(1, md.digest()).toString(16);
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("sunpeihua");
        userEntity.setPassword(password);
        userEntity.setEmail("duanzhu23@126.com");
        userRepository.save(userEntity);
    }

    @Test
    public void searchUser(){
        UserEntity userEntity = userRepository.findByUsername("abc");
        System.out.println(userEntity);
    }

}
