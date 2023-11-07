package com.tcgb02.motopartes.commons.models.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="store", schema="APP_M_INVENTARIO")
public class Store implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "store_seq", sequenceName = "store_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "store_seq")
    @Column(name = "store_id")
    private Long storeId;

    //@Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "store", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<ManagerStore> managers;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id", insertable = false, updatable = false)
    @JsonBackReference
    private Location location;

    @OneToMany(mappedBy = "store", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<ProviderMovement> providerMovement;

    @OneToMany(mappedBy = "store", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Inventory> inventory;

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
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
