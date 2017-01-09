package com.company.repositories;

import com.company.domains.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by petenguy1 on 12/27/2016.
 */
public interface UserRepository extends CrudRepository<User, Long> {
}
