package com.ankur.springboot.web.springbootkafkapoc.dal.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "DeliveryAddress")
public class DeliveryAddressDb {

    @Id
    @GeneratedValue
    private Long AddressId;

    private long CustomerId;

    private String AddressLine;

    private String City;

    private String State;

    private String ZipCode;

    private String ContactNumber;

    @ManyToMany(mappedBy = "customerAddress")
    Set<CustomerDb> customerInfo;

    public DeliveryAddressDb(Long addressId, long customerId, String addressLine, String city, String state, String zipCode, String contactNumber) {
        AddressId = addressId;
        CustomerId = customerId;
        AddressLine = addressLine;
        City = city;
        State = state;
        ZipCode = zipCode;
        ContactNumber = contactNumber;
    }

    public DeliveryAddressDb(){}

    public Long getAddressId() {
        return AddressId;
    }

    public long getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(long customerId) {
        CustomerId = customerId;
    }

    public String getAddressLine() {
        return AddressLine;
    }

    public void setAddressLine(String addressLine) {
        AddressLine = addressLine;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getZipCode() {
        return ZipCode;
    }

    public void setZipCode(String zipCode) {
        ZipCode = zipCode;
    }

    public String getContactNumber() {
        return ContactNumber;
    }

    public void setContactNumber(String contactNumber) {
        ContactNumber = contactNumber;
    }

}
