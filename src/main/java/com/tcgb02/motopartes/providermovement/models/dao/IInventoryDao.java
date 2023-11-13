package com.tcgb02.motopartes.providermovement.models.dao;

import com.tcgb02.motopartes.providermovement.models.entity.Inventory;
import com.tcgb02.motopartes.providermovement.models.entity.Product;
import com.tcgb02.motopartes.providermovement.models.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IInventoryDao extends JpaRepository<Inventory, Long> {

    @Modifying
    //Actualiza la cantidad si ya existe un registro con el mismo producto y tienda.
    @Query("UPDATE Inventory i SET i.amount = i.amount + :amount WHERE i.product = :product AND i.store = :store")
    void updateInventoryIfExists(
            @Param("amount") Integer amount,
            @Param("product") Product product,
            @Param("store") Store store);

    @Modifying
    // Inserta un nuevo registro si no existe un registro con el mismo producto y tienda
    @Query("INSERT INTO Inventory (amount, stock, available, minQuantity, maxQuantity, store, product) " +
            "SELECT :amount, 0, 0, 0, 0, :store, :product FROM Inventory i " +
            "WHERE i.product = :product AND i.store = :store AND i.amount = 0")
    void insertIntoInventoryIfNotExists(
            @Param("amount") Integer amount,
            @Param("product") Product product,
            @Param("store") Store store);
}

