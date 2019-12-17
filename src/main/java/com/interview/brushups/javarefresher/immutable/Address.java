package com.interview.brushups.javarefresher.immutable;

/**
 * Let the Non-Immutable Class implement Clonable interface.
 * @override clone() method
 */
public class Address implements Cloneable {
    public String addressType;
    public String address;
    public String city;

    public Address(String addressType, String address, String city) {
        super();
        this.addressType = addressType;
        this.address = address;
        this.city = city;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressType='" + addressType + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
