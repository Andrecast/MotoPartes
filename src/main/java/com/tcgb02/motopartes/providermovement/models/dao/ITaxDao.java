package com.tcgb02.motopartes.providermovement.models.dao;

import com.tcgb02.motopartes.providermovement.models.entity.Tax;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITaxDao extends JpaRepository<Tax, Long> {
}
