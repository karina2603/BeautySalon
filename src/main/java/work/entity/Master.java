package work.entity;



import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "masters")
public class Master {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_master")
    private int ID_master;
    @Column(name = "name")
    private String name;
    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE,
                    CascadeType.REFRESH, CascadeType.PERSIST})
    @JoinTable(
            name="masters_services",
            joinColumns = @JoinColumn(name = "master_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id")
    )
    private List<Service> services;
//    @OneToMany
//    @JoinColumn(name = "master_record")
//    private List<Record> records;

    public void addServiceToMaster(Service service) {
        if (services == null) {
            services = new ArrayList<>();
        }
        services.add(service);
    }
    public Master(String name, List<Service> services) {
        this.name = name;
        this.services = services;
    }
    public Master(String name) {
        this.name = name;
    }

    public Master() {
    }

    public int getID_master() {
        return ID_master;
    }

    public void setID_master(int ID_master) {
        this.ID_master = ID_master;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Master master = (Master) o;
        return ID_master == master.ID_master && Objects.equals(name, master.name) && Objects.equals(services, master.services);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID_master, name, services);
    }
}
