package com.ankur.springboot.web.springbootkafkapoc.dal.repository;

import com.ankur.springboot.web.springbootkafkapoc.dal.entity.CustomerDb;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<CustomerDb, Long> {
}
