package com.tcgb02.motopartes.commons.models.dao;

import com.tcgb02.motopartes.commons.models.entity.Location;
import org.springframework.data.repository.CrudRepository;

public interface ILocationDao extends CrudRepository<Location, Long> {
}
