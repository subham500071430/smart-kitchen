package com.myapp.service.repository;

import com.myapp.service.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsersRepository extends JpaRepository<User, String> {

    @Transactional
    @Modifying
    @Query("update User u set u.password = :password where u.emailId = :emailId")
    int updatePassword(@Param("emailId") String emailId, @Param("password") String password);

}
