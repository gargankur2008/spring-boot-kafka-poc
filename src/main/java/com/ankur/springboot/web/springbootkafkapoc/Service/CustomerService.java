package com.ankur.springboot.web.springbootkafkapoc.Service;

import com.ankur.springboot.web.models.Customer;
import com.ankur.springboot.web.springbootkafkapoc.dal.repository.CustomerRepository;
import com.ankur.springboot.web.springbootkafkapoc.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    public void save(Customer customer) {
        repository.save(MapperUtil.INSTANCE.CustomerDbMapper(customer));
    }
}
