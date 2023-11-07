package com.tcgb02.motopartes.commons.models.dao;

import com.tcgb02.motopartes.commons.models.entity.ProviderMovement;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IProviderMovementDao extends CrudRepository<ProviderMovement, Long>{

}
