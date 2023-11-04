package com.tcgb02.motopartes.commons.models.dao;

import com.tcgb02.motopartes.commons.models.entity.ProviderMovement;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository //bean de acceso a datos, traduce con detalle las excepciones o errores q puedan ocurrir
public class ProviderMovementDaoImpl implements IProviderMovementDao{

    @PersistenceContext //Inyecta el Entity Manager
    private EntityManager em; //realiza todas las operaciones a la BD pero a nivel de objetos

    @SuppressWarnings("unchecked")
    @Transactional
    @Override
    public List<ProviderMovement> findAll() {
        return em.createQuery("from ProviderMovement").getResultList(); //Retorna el listado de movimientos
    }
}
