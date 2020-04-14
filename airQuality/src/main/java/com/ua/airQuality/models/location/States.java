package com.ua.airQuality.models.location;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import com.ua.airQuality.converters.StateConverter;

@Entity
@Table(name = "states")
public class States implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    
    @Column(name = "status")
    private String status;
    
    @Column(name = "data")
    @ElementCollection
    @Convert(converter = StateConverter.class)
    @OneToMany(cascade=CascadeType.ALL)
    @JoinTable(name="states_data",
    joinColumns={@JoinColumn(name="states_id", referencedColumnName="id")},
    inverseJoinColumns={@JoinColumn(name="data_id", referencedColumnName="id")})
    private List<State> data;
    

    public States() {
    }

    public States(String status, List<State> data) {
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

    public List<State> getData() {
        return data;
    }

    public void setData(List<State> data) {
        this.data = data;
    }


    @Override
    public String toString() {
        return "States{" + "id=" + id + ", status=" + status + ", data=" + data  + '}';
    }
    
}
