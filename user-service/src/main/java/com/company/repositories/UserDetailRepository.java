package com.company.repositories;

import com.company.domains.UserDetail;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by petenguy1 on 1/3/2017.
 */
public interface UserDetailRepository extends CrudRepository<UserDetail, Long> {
}
