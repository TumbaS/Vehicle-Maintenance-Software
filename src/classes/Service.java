/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Urbanovic
 */
@Entity
@Table(name = "service")
public class Service implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id")
    private int service_id;

    @Column(name = "service_date", columnDefinition = "DATETIME")
    @Temporal(TemporalType.DATE)
    private Date service_date;

    @Column(name = "odometer_value")
    private int odometer_value;

    @Column(name = "service_name")
    private String service_name;

    @ManyToOne
    @JoinColumn(name = "part_id")
    private Part part;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    @Column(name = "service_description")
    private String service_description;

    public Service() {
    }

    public void setService_id(int service_id) {
        this.service_id = service_id;
    }

    public int getService_id() {
        return service_id;
    }

    public void setService_date(Date service_date) {
        this.service_date = service_date;
    }

    public Date getService_date() {
        return service_date;
    }

    public void setOdometer_value(int odometer_value) {
        this.odometer_value = odometer_value;
    }

    public int getOdometer_value() {
        return odometer_value;
    }

    public void setPart(Part part) {
        this.part = part;
    }

    public Part getPart() {
        return part;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_description(String service_description) {
        this.service_description = service_description;
    }

    public String getService_description() {
        return service_description;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

}
