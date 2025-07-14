package com.myapp.service.repository;

import com.myapp.service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends JpaRepository<User,String> {

}
