package com.tcgb02.motopartes.commons.models.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="provider", schema="APP_M_INVENTARIO")
public class Provider implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "provider_seq", sequenceName = "provider_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "provider_seq")
    @Column(name = "provider_id")
    private Long providerId;

    //@Column(nullable = false)
    private String name;

    //@Column(nullable = false)
    private Long contact;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id", insertable = false, updatable = false)
    private Location location;

    @OneToMany(mappedBy = "provider", fetch = FetchType.LAZY)
    private List<Product> products;

    //@OneToMany(mappedBy = "provider", fetch = FetchType.LAZY)
    //private List<ProviderMovement> providerMovement; no necesito una lista de movimientos del proveedor

    public Long getProviderId() {
        return providerId;
    }

    public void setProviderId(Long providerId) {
        this.providerId = providerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getContact() {
        return contact;
    }

    public void setContact(Long contact) {
        this.contact = contact;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
