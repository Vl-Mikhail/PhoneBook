package ru.misha.store;

import org.junit.Test;
import ru.misha.model.City;

import static org.junit.Assert.assertEquals;


public class CityStorageTest {

    CRUD<City> crud = new CityStorage();

    @Test
    public void testCreate() throws Exception {
        City city = new City();
        city.setCity("VL");

        int id = crud.create(city);
        System.out.println(crud.getAll());
        crud.delete(id);
    }
}