package work.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import work.entity.Record;
import work.entity.Service;

import java.util.List;

public class ServiceDAOImpl implements ServiceDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Service> getAllServices() {
        Session session = sessionFactory.getCurrentSession();
        Query<Service> query = session.createQuery("from Service ",
                Service.class);
        List<Service> allServices = query.getResultList();

        return allServices;
    }

    @Override
    public void saveService(Service service) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(service);
    }

    @Override
    public Service getService(int id) {
        Session session = sessionFactory.getCurrentSession();
        Service service = session.get(Service.class, id);
        return service;
    }

    @Override
    public void deleteService(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Service>  query = session.createQuery("delete from Service " +
                "where id =:serviceId");
        query.setParameter("serviceId", id);
        query.executeUpdate();
    }
}
