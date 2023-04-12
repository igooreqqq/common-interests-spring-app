package com.meow.commoninterests.repository;

import com.meow.commoninterests.entity.Interests;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterestsRepository extends JpaRepository<Interests, Long> {
}
