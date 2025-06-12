package com.myapp.service.repository;

import com.myapp.service.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<User,String> {

}
