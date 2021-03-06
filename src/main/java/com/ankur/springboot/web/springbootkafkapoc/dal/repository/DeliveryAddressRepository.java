package com.ankur.springboot.web.springbootkafkapoc.dal.repository;

import com.ankur.springboot.web.springbootkafkapoc.dal.entity.DeliveryAddressDb;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryAddressRepository extends CrudRepository<DeliveryAddressDb, Long> {
}
