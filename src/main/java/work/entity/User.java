package work.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "username")
    private String login;
    @Column(name = "password")
    private String password;
    @Transient
    private String passwordConfirm;
    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE,
                    CascadeType.REFRESH, CascadeType.PERSIST})
    @JoinTable(
            name="user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles;

    public User() {
    }

    public User(String login, String password, String passwordConfirm, List<Role> roles) {
        if (passwordConfirm.equals(password)) {
            this.login = login;
            this.password = password;
            this.passwordConfirm = passwordConfirm;
            this.roles = roles;
        }
    }

    public void addRoleToUser(Role role) {
        if (roles == null) {
            roles = new ArrayList<>();
        }
        roles.add(role);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }


    public void setLogin(String username) {
        this.login = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(login, user.login) && Objects.equals(password, user.password) && Objects.equals(passwordConfirm, user.passwordConfirm) && Objects.equals(roles, user.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, passwordConfirm, roles);
    }
}

