package com.springboot.ranga.learn_webservices.socialmediaapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

//@JsonIgnoreProperties({"Name", "id"}) // can have single value or array of fields to ignore.
// Static filtering at class level. This will ignore the specified fields during serialization/deserialization.
public class User {

    @JsonIgnore
    // static filtering. This field will be ignored during serialization/deserialization .i.e it won't appear in JSON response
    private int id;

    @Size(min = 2, message = "Name should have at least 2 characters")
    @NotBlank(message = "Name cannot be BLANK, Please provide a Name.")
    @JsonProperty("Name") // custom name for JSON property.
    private String name;

    @Past(message = "Date of Birth should be in the past, Please provide a valid Date of Birth.")
    @NotNull(message = "Date of Birth cannot be NULL, Please provide Date of Birth.")
    @JsonProperty("Date_of_Birth")
    private LocalDate dob;

    public User(int id, String name, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.dob = dob;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                '}';
    }
}
