package com.tcgb02.motopartes.providermovement.models.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="manager", schema="APP_M_INVENTARIO")
public class Manager implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "manager_seq", sequenceName = "manager_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "manager_seq")
    @Column(name = "manager_id")
    private Long managerId;

    //@Column(nullable = false)
    private String name;

    //@Column(nullable = false)
    private Long identification;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id", insertable = false, updatable = false)
    @JsonBackReference
    private Location location;

    @OneToMany(mappedBy = "manager", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<ManagerStore> stores;

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getIdentification() {
        return identification;
    }

    public void setIdentification(Long identification) {
        this.identification = identification;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<ManagerStore> getStores() {
        return stores;
    }

    public void setStores(List<ManagerStore> stores) {
        this.stores = stores;
    }
}
