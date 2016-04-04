package ru.misha.store;

import org.junit.Test;
import ru.misha.model.City;
import ru.misha.model.Client;
import ru.misha.model.Street;

import static org.junit.Assert.*;


public class ClientStorageTest {

    ClientImplCRUD crud = new ClientStorage();
    Client client;

    @Test
    public void testGetAll() throws Exception {
        assertNotNull(crud.getAll());
        System.out.println(crud.getAll());
    }


    @Test
    public void testCreate() throws Exception {
        client = new Client();
        client.setFirstname("Mike");
        client.setLastname("Ivanov");
        client.setMiddlename("Sergeevich");

        int id = crud.create(client);
        assertEquals(crud.getById(id).getUid(), id);
        crud.delete(id);
    }

}