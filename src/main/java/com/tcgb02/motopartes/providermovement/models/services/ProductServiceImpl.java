package com.tcgb02.motopartes.providermovement.models.services;

import com.tcgb02.motopartes.providermovement.models.dao.IProductDao;
import com.tcgb02.motopartes.providermovement.models.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ProductServiceImpl implements IProductService{
    @Autowired
    private IProductDao productDao;

    @Override
    public Product getProductById(Long productId) {
        return productDao.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + productId));
    }

    @Override
    public List<Product> getAllProducts() {
        return (List<Product>) productDao.findAll();
    }
}
