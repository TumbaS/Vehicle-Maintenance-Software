package classes;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Urbanovic
 */
@Entity
@Table(name = "logo")
public class Logo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "logo_id")
    private int logo_id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "logo")
    @Lob
    private byte[] logo;

    @OneToMany(mappedBy = "logo")
    private Set<Vehicle> vehicle;

    public Logo() {
    }

    public Logo(int logo_id, byte[] logo) {
        this.logo_id = logo_id;
        this.logo = logo;
    }

    public void setLogo_id(int logo_id) {
        this.logo_id = logo_id;
    }

    public int getLogo_id() {
        return logo_id;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    public byte[] getLogo() {
        return logo;
    }

    public void setVehicle(Set<Vehicle> vehicle) {
        this.vehicle = vehicle;
    }

    public Set<Vehicle> getVehicle() {
        return vehicle;
    }

}
