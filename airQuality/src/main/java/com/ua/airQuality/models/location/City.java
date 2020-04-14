
package com.ua.airQuality.models.location;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name="city")
public class City implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    
    @Column(name = "city")
    private String city;
    
    @Column(name = "country")
    private String country;
    
    @Column(name = "state")
    private String state;

    public City() {
    }

    public City(String city) {
        this.city = city;
    }

    public City(String city, String state, String country) {
        this.city = city;
        this.country = country;
        this.state = state;
    }
   

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "City{" + "id=" + id + ", city=" + city + ", country=" + country + ", state=" + state + '}';
    }

    
}