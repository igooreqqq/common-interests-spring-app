package com.meow.commoninterests.repository;

import com.meow.commoninterests.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
