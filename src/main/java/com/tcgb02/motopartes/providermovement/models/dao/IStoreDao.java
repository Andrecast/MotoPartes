package com.tcgb02.motopartes.providermovement.models.dao;

import com.tcgb02.motopartes.providermovement.models.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStoreDao extends JpaRepository<Store, Long> {
}
