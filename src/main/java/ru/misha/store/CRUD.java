package ru.misha.store;


import ru.misha.model.Client;

import java.util.Collection;

public interface CRUD<T> {

    Collection<T> getAll();

    int create(T t);

    void update(T t);

    void delete(int id);

}
