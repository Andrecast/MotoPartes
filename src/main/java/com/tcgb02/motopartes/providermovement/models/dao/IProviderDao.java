package com.tcgb02.motopartes.providermovement.models.dao;

import com.tcgb02.motopartes.providermovement.models.entity.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProviderDao extends JpaRepository<Provider, Long> {

}
