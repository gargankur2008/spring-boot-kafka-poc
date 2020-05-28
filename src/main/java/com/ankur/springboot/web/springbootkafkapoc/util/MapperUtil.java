package com.ankur.springboot.web.springbootkafkapoc.util;

import com.ankur.springboot.web.models.Customer;
import com.ankur.springboot.web.models.DeliveryAddress;
import com.ankur.springboot.web.springbootkafkapoc.dal.entity.CustomerDb;
import com.ankur.springboot.web.springbootkafkapoc.dal.entity.DeliveryAddressDb;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MapperUtil {
    MapperUtil INSTANCE = Mappers.getMapper(MapperUtil.class);

    CustomerDb CustomerDbMapper(Customer customer);

    @InheritInverseConfiguration
    Customer CustomerAvroMapper(CustomerDb customerDb);

    DeliveryAddressDb DeliveryAddressDbMapper(DeliveryAddress deliveryAddress);

    @InheritInverseConfiguration
    DeliveryAddress DeliveryAddressAvroMapper(DeliveryAddressDb deliveryAddressDb);
}
