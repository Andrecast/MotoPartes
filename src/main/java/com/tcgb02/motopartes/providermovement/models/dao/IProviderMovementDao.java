package com.tcgb02.motopartes.providermovement.models.dao;

import com.tcgb02.motopartes.providermovement.models.entity.ProviderMovement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProviderMovementDao extends JpaRepository<ProviderMovement, Long> {

}
