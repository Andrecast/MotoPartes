package com.tcgb02.motopartes.commons.models.dao;

import com.tcgb02.motopartes.commons.models.entity.Provider;
import org.springframework.data.repository.CrudRepository;

public interface IProviderDao extends CrudRepository<Provider, Long> {
}
