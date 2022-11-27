package work.service;

import work.entity.Master;

import java.util.List;

public interface MasterService {
    public List<Master> getAllMasters();
    public void saveMaster(Master master);
    public Master getMaster(int id);
    public void deleteMaster(int id);
}
