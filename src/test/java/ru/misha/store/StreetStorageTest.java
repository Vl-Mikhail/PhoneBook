package ru.misha.store;

import org.junit.Test;
import ru.misha.model.City;
import ru.misha.model.Client;
import ru.misha.model.Street;

import static org.junit.Assert.*;


public class StreetStorageTest {

    StreetImplCRUD crud = new StreetStorage();
    CityImplCRUD cityImpl = new CityStorage();

    @Test
    public void testCreate() throws Exception {
        Street street = new Street();
        City city = new City();

        city.setCity("Vl");
        int idCity = cityImpl.create(city);

        street.setStreet("Russkay");
        street.setCityId(idCity);

        int idStr = crud.create(street);
        crud.delete(idStr);
        cityImpl.delete(idCity);
    }

}