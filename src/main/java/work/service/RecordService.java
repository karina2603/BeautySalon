package work.service;

import work.entity.Record;

import java.util.List;

public interface RecordService {
    public List<Record> getAllRecords();
    public void saveRecord(Record record);
    public Record getRecord(int id);
    public void deleteRecord(int id);
}
