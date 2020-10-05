package com.rmaslov.retrofit.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class UserResponse {

    @ToString
    @Getter
    @Setter
    public static class Geo {
        public String lat;
        public String lng;
    }

    @ToString
    @Getter
    @Setter
    public static class Address {
        public String street;
        public String suite;
        public String city;
        public String zipcode;
        public Geo geo;
    }

    @ToString
    @Getter
    @Setter
    public static class Company {
        public String name;
        public String catchPhrase;
        public String bs;
    }

    public int id;
    public String name;
    public String username;
    public String email;
    public Address address;
    public String phone;
    public String website;
    public Company company;
}
