package com.tcgb02.motopartes.commons.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="location", schema="APP_M_INVENTARIO")
public class Store implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "store_seq", sequenceName = "store_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "store_seq")
    private Long store_id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "store", fetch = FetchType.LAZY)
    private List<ManagerStore> managers;

    @ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "location_id", insertable = false, updatable = false)
    private Location location;

    @OneToMany(mappedBy = "store", fetch = FetchType.LAZY)
    private List<ProviderMovement> providerMovement;

    @OneToMany(mappedBy = "store", fetch = FetchType.LAZY)
    private List<Inventory> inventory;

    public Long getStore_id() {
        return store_id;
    }

    public void setStore_id(Long store_id) {
        this.store_id = store_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ManagerStore> getManagers() {
        return managers;
    }

    public void setManagers(List<ManagerStore> managers) {
        this.managers = managers;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<ProviderMovement> getProviderMovement() {
        return providerMovement;
    }

    public void setProviderMovement(List<ProviderMovement> providerMovement) {
        this.providerMovement = providerMovement;
    }

    public List<Inventory> getInventory() {
        return inventory;
    }

    public void setInventory(List<Inventory> inventory) {
        this.inventory = inventory;
    }
}
