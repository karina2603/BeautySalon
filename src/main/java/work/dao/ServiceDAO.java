package work.dao;

import work.entity.Service;

import java.util.List;

public interface ServiceDAO {
    public List<Service> getAllServices();
    public void saveService(Service service);
    public Service getService(int id);
    public void deleteService(int id);
}
