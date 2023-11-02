package com.tcgb02.motopartes.commons.entity;

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
    private Long manager_id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Long identification;

    @ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "location_id", insertable = false, updatable = false)
    private Location location;

    @OneToMany(mappedBy = "manager", fetch = FetchType.LAZY)
    private List<ManagerStore> stores;

    public Long getManager_id() {
        return manager_id;
    }

    public void setManager_id(Long manager_id) {
        this.manager_id = manager_id;
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