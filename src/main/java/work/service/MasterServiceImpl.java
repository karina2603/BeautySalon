package work.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import work.dao.MasterDAO;
import work.entity.Master;

import java.util.List;

@Service
public class MasterServiceImpl implements MasterService{

    @Autowired
    private MasterDAO masterDAO;

    @Override
    @Transactional
    public List<Master> getAllMasters() {
        return masterDAO.getAllMasters();
    }

    @Override
    @Transactional
    public void saveMaster(Master master) {
        masterDAO.saveMaster(master);
    }

    @Override
    @Transactional
    public Master getMaster(int id) {
        return masterDAO.getMaster(id);
    }

    @Override
    @Transactional
    public void deleteMaster(int id) {
        masterDAO.deleteMaster(id);
    }
}
