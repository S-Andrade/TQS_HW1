package com.ua.airQuality.models.location;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name="country")
public class Country implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    
    @Column(name = "country")
    private String country;
    
    public Country(){}
    
    public Country(String country){
        this.country = country;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Country{" + "id=" + id + ", country=" + country + '}';
    }
    
    
}
