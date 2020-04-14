package com.ua.airQuality.models.location;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import com.ua.airQuality.converters.CityConverter;


@Entity
@Table(name = "cities")
public class Cities implements Serializable  {
   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    
    @Column(name = "status")
    private String status;
    
    @Column(name = "data")
    @ElementCollection
    @Convert(converter = CityConverter.class)
    @OneToMany(cascade=CascadeType.ALL)
    @JoinTable(name="cities_data",
    joinColumns={@JoinColumn(name="cities_id", referencedColumnName="id")},
    inverseJoinColumns={@JoinColumn(name="data_id", referencedColumnName="id")})
    private List<City> data;
    

    public Cities() {
    }

    public Cities(String status, List<City> data) {
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

    public List<City> getData() {
        return data;
    }

    public void setData(List<City> data) {
        this.data = data;
    }


    @Override
    public String toString() {
        return "Cities{" + "id=" + id + ", status=" + status + ", data=" + data + '}';
    }

    
}
