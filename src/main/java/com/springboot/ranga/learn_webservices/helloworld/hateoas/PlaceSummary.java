package com.springboot.ranga.learn_webservices.helloworld.hateoas;

// Summary view for list endpoint
public class PlaceSummary {
    private String name;

    public PlaceSummary(String name) {
        this.name = name;
    }
    // getters and setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}
