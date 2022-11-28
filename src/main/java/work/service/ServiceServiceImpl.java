package work.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import work.dao.ServiceDAO;
import work.entity.Service;

import java.util.List;

public class ServiceServiceImpl implements ServiceService{

    @Autowired
    private ServiceDAO serviceDAO;

    @Override
    @Transactional
    public List<Service> getAllServices() {
        return serviceDAO.getAllServices();
    }

    @Override
    @Transactional
    public void saveService(Service service) {
        serviceDAO.saveService(service);
    }

    @Override
    @Transactional
    public Service getService(int id) {
        return serviceDAO.getService(id);
    }

    @Override
    @Transactional
    public void deleteService(int id) {
        serviceDAO.deleteService(id);
    }
}
