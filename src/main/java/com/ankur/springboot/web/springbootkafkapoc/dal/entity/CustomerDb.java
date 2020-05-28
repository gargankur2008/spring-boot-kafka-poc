package com.ankur.springboot.web.springbootkafkapoc.dal.entity;

import com.ankur.springboot.web.models.Customer;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Customer")
public class CustomerDb {
    @Id
    @GeneratedValue
    private Long CustomerId;

    private String FirstName;

    private String LastName;

    private String DOB;

    private String CustomerSince;

    private String Email;

    @ManyToMany
    @JoinTable(
            name = "customer_address",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "deliveryaddress_id"))
    Set<DeliveryAddressDb> customerAddress;

    public CustomerDb(Long customerId, String firstName, String lastName, String DOB, String customerSince, String email) {
        CustomerId = customerId;
        FirstName = firstName;
        LastName = lastName;
        this.DOB = DOB;
        CustomerSince = customerSince;
        Email = email;
    }

    public CustomerDb(){}

    public Long getCustomerId() {
        return CustomerId;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getCustomerSince() {
        return CustomerSince;
    }

    public void setCustomerSince(String customerSince) {
        CustomerSince = customerSince;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
