package com.tcgb02.motopartes.providermovement.models.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="location", schema="APP_M_INVENTARIO")
public class Location implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "location_seq", sequenceName = "location_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "location_seq")
    @Column(name = "location_id")
    private Long locationId;

    //@Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "location", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Manager> managers;

    @OneToMany(mappedBy = "location", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Store> stores;

    @OneToMany(mappedBy = "location", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Provider> providers;

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Manager> getManagers() {
        return managers;
    }

    public void setManagers(List<Manager> managers) {
        this.managers = managers;
    }

    public List<Store> getStores() {
        return stores;
    }

    public void setStores(List<Store> stores) {
        this.stores = stores;
    }

    public List<Provider> getProviders() {
        return providers;
    }

    public void setProviders(List<Provider> providers) {
        this.providers = providers;
    }
}
