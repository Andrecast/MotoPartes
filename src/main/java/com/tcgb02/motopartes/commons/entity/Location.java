package com.tcgb02.motopartes.commons.entity;

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
    private Long location_id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "location", fetch = FetchType.LAZY)
    private List<Manager> managers;

    @OneToMany(mappedBy = "location", fetch = FetchType.LAZY)
    private List<Store> stores;

    @OneToMany(mappedBy = "location", fetch = FetchType.LAZY)
    private List<Provider> providers;

    public Long getLocation_id() {
        return location_id;
    }

    public void setLocation_id(Long location_id) {
        this.location_id = location_id;
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
