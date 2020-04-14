package com.ua.airQuality.models.air;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="location")
public class Location implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    
    @Column(name = "type")
    private String type;
    
    @Column(name = "coordinates")
    private int[] coordinates;

    public Location() {
    }

    public Location(String type, int[] coordinates) {
        this.type = type;
        this.coordinates = coordinates;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(int[] coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public String toString() {
        return "Location{" + "id=" + id + ", type=" + type + ", coordinates=" + coordinates + '}';
    }
    
    
}