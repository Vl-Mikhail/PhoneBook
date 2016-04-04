package ru.misha.store;


import ru.misha.model.Client;

public interface ClientImplCRUD extends CRUD<Client>{

    Client getById(int id);

}
