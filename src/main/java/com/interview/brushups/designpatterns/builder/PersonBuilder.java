package com.interview.brushups.designpatterns.builder;

class Person {

    private int id;
    private String name;

    private int phone;
    private String address;

    // The constructor is private and can only be called by the Builder Class
    private Person(PersonBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    //Builder Class
    public static class PersonBuilder {
        private int id;
        private String name;

        private int phone;
        private String address;

        public PersonBuilder(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public PersonBuilder setPhone(int phone) {
            this.phone = phone;
            return this;
        }

        public PersonBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Person build() {
            return new Person(this);
        }

    }

}