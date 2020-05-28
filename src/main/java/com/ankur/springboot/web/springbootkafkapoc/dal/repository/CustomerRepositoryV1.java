package com.ankur.springboot.web.springbootkafkapoc.dal.repository;

import com.ankur.springboot.web.springbootkafkapoc.dal.entity.CustomerDb;
import com.ankur.springboot.web.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@Transactional
public class CustomerRepositoryV1 {
    @Autowired
    EntityManager entityManager;

    public CustomerDb save(CustomerDb customer) {
        entityManager.merge(customer);
        return customer;
    }
}
