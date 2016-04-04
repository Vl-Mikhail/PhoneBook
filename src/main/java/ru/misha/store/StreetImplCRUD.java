package ru.misha.store;


import ru.misha.model.Street;

import java.util.Collection;

public interface StreetImplCRUD extends CRUD<Street>{

    Collection<Street> findByCity(Integer cityId);
}
