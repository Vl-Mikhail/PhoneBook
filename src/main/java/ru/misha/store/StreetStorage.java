package ru.misha.store;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ru.misha.model.Street;

import java.util.Collection;

public class StreetStorage implements StreetImplCRUD{

    private SessionFactory factory;

    public StreetStorage() {
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
    public Collection<Street> getAll() {
        return transaction(new Command<Collection<Street>>() {
            public Collection<Street> pocess(Session session) {return session.createQuery("from Street ").list();}
        });
    }

    @Override
    public int create(Street street) {
        return transaction(new Command<Integer>() {
            public Integer pocess(Session session) {
                return (Integer) session.save(street);
            }
        });
    }

    @Override
    public void update(Street street) {

    }

    @Override
    public void delete(int id) {
        transaction((Session session) -> {
            session.delete(new Street(id, null));
            return null;

                }
        );
    }

    public Collection<Street> findByCity(Integer cityId) {
        return transaction(new Command<Collection<Street>>() {
            public Collection<Street> pocess(Session session) {
                final Query query = session.createQuery("from Street where cityId=:cityId");
                query.setInteger("cityId", cityId);
                return query.list();
            }
        });
    }

}
