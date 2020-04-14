package com.ua.airQuality.models.air;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="pollution")
public class Pollution implements Serializable,  Comparable<Pollution> {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    
    @Column(name = "ts")
    private String ts;
    
    @Column(name = "aquis")
    private String aqius;
    
    @Column(name = "mainus")
    private String mainus;
    
    @Column(name = "aqicn")
    private String aqicn;
    
    @Column(name = "maincn")
    private String maincn;
    
    @Column(name = "city")
    private String city;
    
    @Column(name = "state")
    private String state;
    
    @Column(name = "country")
    private String country;

    public Pollution() {
    }

    public Pollution(String ts, String aqius, String mainus, String aqicn, String maincn) {
        this.ts = ts;
        this.aqius = aqius;
        this.mainus = mainus;
        this.aqicn = aqicn;
        this.maincn = maincn;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public String getAqius() {
        return aqius;
    }

    public void setAqius(String aqius) {
        this.aqius = aqius;
    }

    public String getMainus() {
        return mainus;
    }

    public void setMainus(String mainus) {
        this.mainus = mainus;
    }

    public String getAqicn() {
        return aqicn;
    }

    public void setAqicn(String aqicn) {
        this.aqicn = aqicn;
    }

    public String getMaincn() {
        return maincn;
    }

    public void setMaincn(String maincn) {
        this.maincn = maincn;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city= city;
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
        return "Pollution{" + "id=" + id + ", ts=" + ts + ", aqius=" + aqius + ", mainus=" + mainus + ", aqicn=" + aqicn + ", maincn=" + maincn + ", city=" + city + ", state=" + state + ", country=" + country + '}';
    }

     @Override
    public int compareTo(Pollution p) {
        return getTs().compareTo(p.getTs());
    }
    
    
    
}