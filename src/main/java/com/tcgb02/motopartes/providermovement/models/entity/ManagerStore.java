package com.tcgb02.motopartes.providermovement.models.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "manager_store", schema="APP_M_INVENTARIO")
public class ManagerStore implements Serializable {


    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private ManagerStorePK id;

    @ManyToOne
    @JoinColumn(name = "manager_id", insertable = false, updatable = false)
    @JsonBackReference
    private Manager manager;

    @ManyToOne
    @JoinColumn(name = "store_id", insertable = false, updatable = false)
    @JsonBackReference
    private Store store;

    public ManagerStorePK getId() {
        return id;
    }

    public void setId(ManagerStorePK id) {
        this.id = id;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
}
