package com.ua.airQuality.models.air;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name="weather")
public class Weather implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    
    @Column(name = "ts")
    private String ts;
    
    @Column(name = "tp")
    private String tp;
    
    @Column(name = "pr")
    private String pr;
    
    @Column(name = "hu")
    private String hu;
    
    @Column(name = "ws")
    private String ws;
    
    @Column(name = "wd")
    private String wd;
    
    @Column(name = "ic")
    private String ic;
    
    @Column(name = "city")
    private String city;
    
    @Column(name = "state")
    private String state;
    
    @Column(name = "country")
    private String country;

    public Weather() {
    }

    public Weather(String ts, String tp, String pr, String hu, String ws, String wd, String ic) {
        this.ts = ts;
        this.tp = tp;
        this.pr = pr;
        this.hu = hu;
        this.ws = ws;
        this.wd = wd;
        this.ic = ic;
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

    public String getTp() {
        return tp;
    }

    public void setTp(String tp) {
        this.tp = tp;
    }

    public String getPr() {
        return pr;
    }

    public void setPr(String pr) {
        this.pr = pr;
    }

    public String getHu() {
        return hu;
    }

    public void setHu(String hu) {
        this.hu = hu;
    }

    public String getWs() {
        return ws;
    }

    public void setWs(String ws) {
        this.ws = ws;
    }

    public String getWd() {
        return wd;
    }

    public void setWd(String wd) {
        this.wd = wd;
    }

    public String getIc() {
        return ic;
    }

    public void setIc(String ic) {
        this.ic = ic;
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

    @Override
    public String toString() {
        return "Weather{" + "id=" + id + ", ts=" + ts + ", tp=" + tp + ", pr=" + pr + ", hu=" + hu + ", ws=" + ws + ", wd=" + wd + ", ic=" + ic + ", city=" + city + ", state=" + state + ", country=" + country + '}';
    }

    
    
    
    
}
