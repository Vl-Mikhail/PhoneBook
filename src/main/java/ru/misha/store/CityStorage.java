package ru.misha.store;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ru.misha.model.City;
import ru.misha.model.Street;

import java.util.Collection;


public class CityStorage implements CityImplCRUD {

    private SessionFactory factory;

    public CityStorage() {
        factory = new Configuration().configure().buildSessionFactory();
    }

    /*
    Паттерн command
    */
    public interface Command<T> {
        T pocess(Session session);
    }

    private <T> T transaction(final Command<T> command){
        final Session session = factory.openSession();
        final Transaction tx = session.beginTransaction();
        try{
            return command.pocess(session);
        } finally {
            tx.commit();
            session.close();
        }
    }

    @Override
    public Collection<City> getAll() {
        return transaction(new Command<Collection<City>>() {
            public Collection<City> pocess(Session session) {
                return session.createQuery("from City ").list();}
        });
    }

    @Override
    public int create(City city) {
        return transaction(new Command<Integer>() {
            public Integer pocess(Session session) {
                return (Integer) session.save(city);
            }
        });
    }

    @Override
    public void update(City city) {

    }

    @Override
    public void delete(int id) {
        transaction((Session session) -> {
                    session.delete(new City(id, null));
                    return null;
                }
        );

    }

}
