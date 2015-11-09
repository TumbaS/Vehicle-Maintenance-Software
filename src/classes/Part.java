package classes;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Urbanovic
 */
@Entity
@Table(name = "part")
public class Part implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "part_id")
    private int part_id;

    @Column(name = "description")
    private String description;

    @Column(name = "part_number")
    private String part_number;

    @Column(name = "supplier")
    private String supplier;

    @Column(name = "price")
    private String price;

    @Column(name = "note")
    private String note;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    @OneToMany(mappedBy = "part")
    private Set<Service> services;

    public Part() {
    }

    public void setPart_id(int part_id) {
        this.part_id = part_id;
    }

    public int getPart_id() {
        return part_id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setPart_number(String part_number) {
        this.part_number = part_number;
    }

    public String getPart_number() {
        return part_number;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPrice() {
        return price;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNote() {
        return note;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setServices(Set<Service> services) {
        this.services = services;
    }

    public Set<Service> getServices() {
        return services;
    }

    @Override
    public String toString() {
        return description + " / " + supplier;
    }

}
