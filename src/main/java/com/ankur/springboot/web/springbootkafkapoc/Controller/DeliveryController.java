package com.ankur.springboot.web.springbootkafkapoc.Controller;

import com.ankur.springboot.web.springbootkafkapoc.Service.KafkaProducerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DeliveryController {

    private KafkaProducerService service = new KafkaProducerService();

    @RequestMapping(method = RequestMethod.POST, value = "/newdelivery", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> newDelivery(@RequestBody com.ankur.springboot.web.models.DeliveryAddress deliveryAddress) {
        if(service.getMessage(deliveryAddress)){
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/test")
    public String test() {
        return "Tested";
    }
}
