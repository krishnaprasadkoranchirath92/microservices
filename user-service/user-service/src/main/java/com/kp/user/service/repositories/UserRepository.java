package com.kp.user.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kp.user.service.models.UserDetails;

@Repository
public interface UserRepository extends JpaRepository<UserDetails, String>{

}
