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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private Role role;

    @Column(name = "enabled")
    private int enabled;

    public User() {
    }

    public User(String login, String password, String passwordConfirm, Role role) {
        if (passwordConfirm.equals(password)) {
            this.login = login;
            this.password = password;
            this.passwordConfirm = passwordConfirm;
            this.role = role;
            this.enabled = 1;
        }
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
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

    public Role getRole() {
        return role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(login, user.login) && Objects.equals(password, user.password) && Objects.equals(passwordConfirm, user.passwordConfirm) && Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, passwordConfirm, role);
    }
}

