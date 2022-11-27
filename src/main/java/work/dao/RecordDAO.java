package work.dao;

import work.entity.Record;

import java.util.List;

public interface RecordDAO {
    public List<Record> getAllRecords();
    public void saveRecord(Record record);
    public Record getRecord(int id);
    public void deleteRecord(int id);
}
