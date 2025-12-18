package com.springboot.ranga.learn_webservices.helloworld.hateoas;

// Full place details
public class Place {
    private Long id;
    private String name;
    private String location;
    private String description;
    private String history;
    private String bestTimeToVisit;

    public Place(Long id, String name, String location,
                 String description, String history, String bestTimeToVisit) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.description = description;
        this.history = history;
        this.bestTimeToVisit = bestTimeToVisit;
    }
    // getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getBestTimeToVisit() {
        return bestTimeToVisit;
    }

    public void setBestTimeToVisit(String bestTimeToVisit) {
        this.bestTimeToVisit = bestTimeToVisit;
    }
}

