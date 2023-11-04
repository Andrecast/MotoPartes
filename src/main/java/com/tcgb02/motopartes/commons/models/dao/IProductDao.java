package com.tcgb02.motopartes.commons.models.dao;

import com.tcgb02.motopartes.commons.models.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface IProductDao extends CrudRepository<Product, Long> {
}
