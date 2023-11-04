package com.tcgb02.motopartes.commons.models.dao;

import com.tcgb02.motopartes.commons.models.entity.Store;
import org.springframework.data.repository.CrudRepository;

public interface IStoreDao extends CrudRepository<Store, Long> {
}
