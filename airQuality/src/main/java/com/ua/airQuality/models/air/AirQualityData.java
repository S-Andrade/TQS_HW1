
package com.ua.airQuality.models.air;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.io.Serializable;
import com.ua.airQuality.converters.CurrentConverter;
import com.ua.airQuality.converters.LocationConverter;


@Entity
@Table(name="airQualityData")
@JsonIgnoreProperties(ignoreUnknown = true)
public class AirQualityData implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    
    @Column(name = "city")
    private String city;
    
    @Column(name = "state")
    private String state;
    
    @Column(name = "country")
    private String country;
    
    //@Column(name = "location")
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @Convert(converter = LocationConverter.class)
    @JoinTable(name="airQualityData_location",
    joinColumns={@JoinColumn(name="airQualityData_id")},
    inverseJoinColumns={@JoinColumn(name="location_id",unique = true)})
    private Location location;
    
    //@Column(name = "current")
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @Convert(converter = CurrentConverter.class)
    @JoinTable(name="airQualityData_current",
    joinColumns={@JoinColumn(name="airQualityData_id")},
    inverseJoinColumns={@JoinColumn(name="current_id", unique = true)})
    private Current current;

    public AirQualityData() {
    }

    public AirQualityData(String city, String state, String country, Location location, Current current) {
        this.city = city;
        this.state = state;
        this.country = country;
        this.location = location;
        this.current = current;
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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Current getCurrent() {
        return current;
    }

    public void setCurrent(Current current) {
        this.current = current;
    }

    @Override
    public String toString() {
        return "AirQualityData{" + "id=" + id + ", city=" + city + ", state=" + state + ", country=" + country + ", location=" + location + ", current=" + current + '}';
    }


    

}