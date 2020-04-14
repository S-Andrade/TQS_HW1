package com.ua.airQuality.models.location;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="state")
public class State implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    
    @Column(name = "state")
    private String state;
    
    @Column(name = "country")
    private String country;

    public State() {
    }

    public State(String state) {
        this.state = state;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "State{" + "id=" + id + ", state=" + state + ", country=" + country + '}';
    }

    
    
}
