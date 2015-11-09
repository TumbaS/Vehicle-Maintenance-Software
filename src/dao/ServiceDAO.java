/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.Owner;
import classes.Part;
import classes.Service;
import classes.Vehicle;
import hibernate.helper.HibernateUtil;
import java.util.List;
import java.util.Set;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Urbanovic
 */
public class ServiceDAO {

    public Service saveService(Service service) {
        Session session = HibernateUtil.createSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(service);
            tx.commit();
            System.out.println("Service saved!");
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e);
        } finally {
            HibernateUtil.close();
        }
        return service;
    }

    public Service getService(int service_id) {
        Session session = HibernateUtil.createSessionFactory().openSession();
        try {
            Service service = (Service) session.get(Service.class, service_id);
            return service;
        } catch (HibernateException e) {
            System.out.println(e);
        } finally {
            HibernateUtil.close();
        }
        return null;
    }

    public Service updateService(Service service) {
        Session session = HibernateUtil.createSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.merge(service);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e);
        } finally {
            HibernateUtil.close();
        }
        return service;
    }

    public List<Service> getServicesByPart(Part part, Vehicle vehicle) {
        Session session = HibernateUtil.createSessionFactory().openSession();
        Transaction tx = null;
        String hql = null;
        if (part != null) {
            hql = "from Service as service where vehicle_id=" + vehicle.getVehicle_id() + " and part_id = " + part.getPart_id() + ")";
        } else {
            hql = "from Service as service where vehicle_id=" + vehicle.getVehicle_id() + " and part_id = null)";
        }
        Query query = session.createQuery(hql);

        try {
            tx = session.beginTransaction();
            List<Service> services = (List<Service>) query.list();
            tx.commit();
            return services;
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e);
        } finally {
            HibernateUtil.close();
        }

        return null;
    }
}
