package com.ankur.springboot.web.springbootkafkapoc.Controller;

import com.ankur.springboot.web.springbootkafkapoc.Service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    @Autowired
    private KafkaProducerService service;

    @RequestMapping(method = RequestMethod.POST, path = "/newcustomer",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> newCustomer(@RequestBody com.ankur.springboot.web.models.Customer customer) {
        if(service.sendMessage(customer)) {
            // System.out.println(customer.getFirstName());
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).build();
    }
}
