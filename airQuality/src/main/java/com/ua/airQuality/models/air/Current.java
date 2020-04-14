package com.ua.airQuality.models.air;

import javax.persistence.*;
import java.io.Serializable;
import com.ua.airQuality.converters.WeatherConverter;
import com.ua.airQuality.converters.PollutionConverter;

@Entity
@Table(name = "current")
public class Current implements Serializable  {
   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @Convert(converter = WeatherConverter.class)
    @JoinTable(name="current_weather",
    joinColumns={@JoinColumn(name="current_id")},
    inverseJoinColumns={@JoinColumn(name="weather_id", unique = true)})
    private Weather weather;
    
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @Convert(converter = PollutionConverter.class)
    @JoinTable(name="current_pollution",
    joinColumns={@JoinColumn(name="current_id")},
    inverseJoinColumns={@JoinColumn(name="pollution_id", unique = true)})
    private Pollution pollution;

    public Current() {
    }

    public Current(Weather weather, Pollution pollution) {
        this.weather = weather;
        this.pollution = pollution;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public Pollution getPollution() {
        return pollution;
    }

    public void setPollution(Pollution pollution) {
        this.pollution = pollution;
    }

    @Override
    public String toString() {
        return "Current{" + "id=" + id + ", weather=" + weather + ", pollution=" + pollution + '}';
    }
    
    
    
    
}