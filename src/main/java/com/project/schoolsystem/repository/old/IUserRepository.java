package com.project.schoolsystem.repository.old;

import com.project.schoolsystem.model.old.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IUserRepository extends PagingAndSortingRepository<User, Long> {
    User findByUsername(String username);
}
