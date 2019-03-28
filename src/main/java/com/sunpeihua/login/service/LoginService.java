package com.sunpeihua.login.service;

import com.sunpeihua.login.entity.UserEntity;
import com.sunpeihua.login.repository.IUserRepository;
import com.sunpeihua.login.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author: sunpeihua
 * @create: 2019/3/28 23:25
 **/
@Service
public class LoginService {
    private final IUserRepository userRepository;


    @Autowired
    public LoginService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean checkUsername(String username) {
        UserEntity userEntity = userRepository.findByUsername(username);
        return userEntity == null;
    }

    public boolean register(UserVO userVO) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(userVO.getPassword().getBytes());
        String password = new BigInteger(1, md.digest()).toString(16);
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userVO.getUsername());
        userEntity.setPassword(password);
        userEntity.setEmail(userVO.getEmail());
        userRepository.save(userEntity);
        return true;
    }
}
