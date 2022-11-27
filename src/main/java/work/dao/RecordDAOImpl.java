package work.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import work.entity.Record;

import java.util.List;

public class RecordDAOImpl implements RecordDAO{

    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Record> getAllRecords() {
        Session session = sessionFactory.getCurrentSession();
        Query<Record> query = session.createQuery("from Record ",
                Record.class);
        List<Record> allRecords = query.getResultList();

        return allRecords;
    }

    @Override
    public void saveRecord(Record record) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(record);
    }

    @Override
    public Record getRecord(int id) {
        Session session = sessionFactory.getCurrentSession();
        Record record = session.get(Record.class, id);
        return record;
    }

    @Override
    public void deleteRecord(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Record>  query = session.createQuery("delete from Record " +
                "where id =:recordId");
        query.setParameter("recordId", id);
        query.executeUpdate();
    }
}
