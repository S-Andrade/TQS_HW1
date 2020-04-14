package com.ua.airQuality.models.air;

import javax.persistence.*;
import java.io.Serializable;
import com.ua.airQuality.converters.AirQualityDataConverter;


@Entity
@Table(name = "airQuality")
public class AirQuality implements Serializable  {
   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    
    @Column(name = "status")
    private String status;
    
    //@Column(name = "data")
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @Convert(converter = AirQualityDataConverter.class)
    @JoinTable(name="airQuality_dataAirQualityData",
    joinColumns={@JoinColumn(name="airQuality_id")},
    inverseJoinColumns={@JoinColumn(name="dataAirQualityData_id", unique = true)})
    private AirQualityData  data;

    public AirQuality() {
    }

    public AirQuality(String status, AirQualityData data) {
        this.status = status;
        this.data = data;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public AirQualityData getData() {
        return data;
    }

    public void setData(AirQualityData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "AirQuality{" + "id=" + id + ", status=" + status + ", data=" + data + '}';
    }
    
    
    

}