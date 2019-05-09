package com.xning.fastdfs.user.service;

import com.xning.fastdfs.user.entity.User;
import com.xning.fastdfs.user.repositroy.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class UserService {
    @Autowired
    private UserRepository repository;

    public User get(Long id){
        return repository.getOne(id);
    }

    public void save(User user){
        repository.save(user);
    }
}
