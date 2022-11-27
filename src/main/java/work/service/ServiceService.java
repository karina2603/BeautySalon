package work.service;

import work.entity.Service;

import java.util.List;

public interface ServiceService {

    public List<Service> getAllServices();
    public void saveService(Service service);
    public Service getService(int id);
    public void deleteService(int id);
}
