package com.zipcodewilmington.centrallibrary;

public class Address {
    private String street;
    private String city;
    private String state;
    private String zipCode;

    public Address(String street, String city, String state, String zipCode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        if (street != null && !street.isEmpty()){
            this.street = street;
        } else {
            System.out.println("Invalid street");
        }
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        if (city != null && !city.isEmpty()){
            this.city = city;
        } else {
            System.out.println("Invalid city");
        }
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        if (state != null && !state.isEmpty()) {
            this.state = state;
        } else {
            System.out.println("Invalid state");
        }
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        if (zipCode != null && !zipCode.isEmpty()) {
            this.zipCode = zipCode;
        } else {
            System.out.println("invalid zipcode");
        }
    }

    public String toString() {
    return street + ", " + city + ", " + state + " " + zipCode;
    }

}
