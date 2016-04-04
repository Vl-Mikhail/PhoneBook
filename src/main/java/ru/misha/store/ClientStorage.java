package ru.misha.store;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ru.misha.model.Client;
import java.util.Collection;


public class ClientStorage implements ClientImplCRUD {

    private SessionFactory factory;

    public ClientStorage() {
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


    public Collection<Client> getAll() {
        return transaction(new Command<Collection<Client>>() {
            public Collection<Client> pocess(Session session) {return session.createQuery("from Client ").list();}
        });
    }

    public int create(final Client client) {
        return transaction(new Command<Integer>() {
            public Integer pocess(Session session) {
                return (Integer) session.save(client);
            }
        });
    }

    public void update(final Client client) {
        transaction((Session session) -> {
                    session.update(client);
                    return null;
                }
        );
    }

    public void delete(int id) {
        transaction((Session session) -> {
                    session.delete(new Client(id, null));
                    return null;
                }
        );
    }

    public Client getById(int id){
        return transaction(new Command<Client>() {
            @Override
            public Client pocess(Session session) {
                return (Client) session.get(Client.class, id);
            }
        });
    }
}
