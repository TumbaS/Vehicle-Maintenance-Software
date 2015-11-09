package dao;

import classes.Logo;
import classes.Owner;
import classes.Vehicle;
import hibernate.helper.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Urbanovic
 */
public class VehicleDAO {

    public Vehicle saveVehicle(Vehicle vehicle) {
        Session session = HibernateUtil.createSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(vehicle);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e);
        } finally {
            HibernateUtil.close();
        }
        return vehicle;
    }

    public Vehicle getVehicle(int vehicle_id) {
        Session session = HibernateUtil.createSessionFactory().openSession();
        try {
            Vehicle vehicle = (Vehicle) session.get(Vehicle.class, vehicle_id);
            return vehicle;
        } catch (HibernateException e) {
            System.out.println(e);
        } finally {
            HibernateUtil.close();
        }
        return null;
    }

    public Vehicle updateVehicle(Vehicle vehicle) {
        Session session = HibernateUtil.createSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.merge(vehicle);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e);
        } finally {
            HibernateUtil.close();
        }
        return vehicle;
    }

    public Vehicle getFirstVehicle(Owner owner) {
        Session session = HibernateUtil.createSessionFactory().openSession();
        Transaction tx = null;
        String hql = "from Vehicle as vehicle where vehicle_id=(select min(vehicle_id) from vehicle where owner_id =" + owner.getOwner_id() + ")";
        Query query = session.createQuery(hql);

        try {
            tx = session.beginTransaction();
            Vehicle vehicle = (Vehicle) query.uniqueResult();
            tx.commit();
            return vehicle;
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
