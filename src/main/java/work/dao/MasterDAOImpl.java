package work.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import work.entity.Master;
import work.entity.User;

import java.util.List;

public class MasterDAOImpl implements MasterDAO{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Master> getAllMasters() {
        Session session = sessionFactory.getCurrentSession();
        Query<Master> query = session.createQuery("from Master ",
                Master.class);
        List<Master> allMasters = query.getResultList();

        return allMasters;
    }

    @Override
    public void saveMaster(Master master) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(master);
    }

    @Override
    public Master getMaster(int id) {
        Session session = sessionFactory.getCurrentSession();
        Master master = session.get(Master.class, id);
        return master;
    }

    @Override
    public void deleteMaster(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Master>  query = session.createQuery("delete from Master " +
                "where id =:masterId");
        query.setParameter("masterId", id);
        query.executeUpdate();
    }
}
