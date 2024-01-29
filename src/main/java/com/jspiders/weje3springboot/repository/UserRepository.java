package com.jspiders.weje3springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jspiders.weje3springboot.pojo.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer>{

}
