package work.dao;

import work.entity.Master;
import java.util.List;

public interface MasterDAO {
    public List<Master> getAllMasters();
    public void saveMaster(Master master);
    public Master getMaster(int id);
    public void deleteMaster(int id);
}
