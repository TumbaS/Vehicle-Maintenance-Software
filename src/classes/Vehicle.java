package classes;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Urbanovic
 */
@Entity
@Table(name = "vehicle")
public class Vehicle implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_id")
    private int vehicle_id;

    @Column(name = "make")
    private String make;

    @Column(name = "model")
    private String model;

    @Column(name = "production_month", columnDefinition = "DATETIME")
    @Temporal(TemporalType.DATE)
    private Date production_month;

    @Column(name = "body")
    private String body;

    @Column(name = "fuel_type")
    private String fuel_type;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @Column(name = "registration_no")
    private String registration_no;

    @ManyToOne
    @JoinColumn(name = "logo_id")
    private Logo logo;

    @Column(name = "cubic_vol")
    private int cubic_vol;

    @Column(name = "power")
    private int power;

    @Column(name = "engine_code")
    private String engine_code;

    @OneToMany(mappedBy = "vehicle")
    private Set<Part> parts;

    @OneToMany(mappedBy = "vehicle")
    private Set<Service> services;

    public void setVehicle_id(int vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public int getVehicle_id() {
        return vehicle_id;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getMake() {
        return make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setProduction_month(Date production_month) {
        this.production_month = production_month;
    }

    public Date getProduction_month() {
        return production_month;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    public void setFuel_type(String fuel_type) {
        this.fuel_type = fuel_type;
    }

    public String getFuel_type() {
        return fuel_type;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setRegistration_no(String registration_no) {
        this.registration_no = registration_no;
    }

    public String getRegistration_no() {
        return registration_no;
    }

    public void setLogo(Logo logo) {
        this.logo = logo;
    }

    public Logo getLogo() {
        return logo;
    }

    public void setCubic_vol(int cubic_vol) {
        this.cubic_vol = cubic_vol;
    }

    public int getCubic_vol() {
        return cubic_vol;
    }

    public void setEngine_code(String engine_code) {
        this.engine_code = engine_code;
    }

    public String getEngine_code() {
        return engine_code;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    public void setParts(Set<Part> parts) {
        this.parts = parts;
    }

    public Set<Part> getParts() {
        return parts;
    }

    public void setServices(Set<Service> services) {
        this.services = services;
    }

    public Set<Service> getServices() {
        return services;
    }

    public Vehicle() {
    }

    @Override
    public String toString() {
        return make + " / " + model + " / " + registration_no;
    }

}
