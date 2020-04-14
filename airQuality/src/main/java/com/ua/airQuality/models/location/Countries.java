package com.ua.airQuality.models.location;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import com.ua.airQuality.converters.CountryConverter;



@Entity
@Table(name = "countries")
public class Countries implements Serializable  {
   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    
    @Column(name = "status")
    private String status;
    
    @Column(name = "data")
    @ElementCollection
    @Convert(converter = CountryConverter.class)
    @OneToMany(cascade=CascadeType.ALL)
    @JoinTable(name="countries_data",
    joinColumns={@JoinColumn(name="countries_id", referencedColumnName="id")},
    inverseJoinColumns={@JoinColumn(name="data_id", referencedColumnName="id")})
    private List<Country> data;

    public Countries(){}
    
    public Countries(String status, List<Country> data) {
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

    public List<Country> getData() {
        return data;
    }

    public void setData(List<Country> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Countries{" + "id=" + id + ", status=" + status + ", data=" + data + '}';
    }
    
    
}
