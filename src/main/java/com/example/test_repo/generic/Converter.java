package com.example.test_repo.generic;

import com.example.test_repo.common.domain.Domain;
import com.example.test_repo.common.entity.Entity;

public interface Converter<D extends Domain, E extends Entity> {

    @SuppressWarnings("unchecked")
    default D toDomain(E entity) {
        return (D) entity.toDomain();
    }

    @SuppressWarnings("unchecked")
    default E toEntity(D domain){
        return (E) domain.toEntity();
    }
}
