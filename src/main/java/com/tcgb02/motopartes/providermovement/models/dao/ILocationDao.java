package com.tcgb02.motopartes.providermovement.models.dao;

import com.tcgb02.motopartes.providermovement.models.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILocationDao extends JpaRepository<Location, Long> {
}
