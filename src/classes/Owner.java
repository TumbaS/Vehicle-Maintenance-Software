package classes;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Urbanovic
 */
@Entity
@Table(name = "owner")
public class Owner implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "owner_id")
    private int owner_id;

    @Column(name = "username")
    private String username;

    @Column(name = "full_name")
    private String full_name;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "owner")
    private Set<Vehicle> vehicle;

    public Owner() {
    }

    public Owner(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }

    public int getOwner_id() {
        return owner_id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setVehicle(Set<Vehicle> vehicle) {
        this.vehicle = vehicle;
    }

    public Set<Vehicle> getVehicle() {
        return vehicle;
    }

}
