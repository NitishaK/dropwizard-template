package com.sample.common.utils;

import com.google.inject.Inject;
import com.google.inject.Provider;

import javax.persistence.EntityManager;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by nitisha.khandelwal on 16/05/16.
 */

public abstract class GenericDAO<E extends AbstractEntity, P> implements IGenericDAO<E, P> {

    @Inject
    private Provider<EntityManager> entityManagerProvider;

    private Class<E> entityClass;

    @SuppressWarnings("unchecked")
    public P insert(E entity) {
        entityManagerProvider.get().persist(entity);
        return (P) entity.getId();
    }

    public E find(P id) {
        return entityManagerProvider.get().find(getEntityClass(), id);
    }

    public void update(E entity) {
        entityManagerProvider.get().merge(entity);
    }

    public void delete(E entity) {
        entityManagerProvider.get().remove(entity);
    }

    public EntityManager getEntityManager() {
        return entityManagerProvider.get();
    }

    @SuppressWarnings("unchecked")
    public Class<E> getEntityClass() {
        if (entityClass == null) {
            Type type = getClass().getGenericSuperclass();
            if (type instanceof ParameterizedType) {
                ParameterizedType paramType = (ParameterizedType) type;

                entityClass = (Class<E>) paramType.getActualTypeArguments()[0];

            } else {
                throw new IllegalArgumentException(
                        "Could not guess entity class by reflection");
            }
        }
        return entityClass;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<E> findAll() {
//        return this.entityManagerProvider.get().createNamedQuery(getEntityClass().getSimpleName() + ".GetAll").getResultList();
        return this.entityManagerProvider.get().createQuery("select x from " + getEntityClass().getSimpleName() + " x")
                .getResultList();

    }

}


