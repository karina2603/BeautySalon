package work.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import work.dao.RecordDAO;
import work.entity.Record;

import java.util.List;

public class RecordServiceImpl implements RecordService{

    @Autowired
    RecordDAO recordDAO;

    @Override
    @Transactional
    public List<Record> getAllRecords() {
        return recordDAO.getAllRecords();
    }

    @Override
    @Transactional
    public void saveRecord(Record record) {
        recordDAO.saveRecord(record);
    }

    @Override
    @Transactional
    public Record getRecord(int id) {
        return recordDAO.getRecord(id);
    }

    @Override
    @Transactional
    public void deleteRecord(int id) {
        recordDAO.deleteRecord(id);
    }
}
