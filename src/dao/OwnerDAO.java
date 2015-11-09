package dao;

import classes.Owner;
import classes.Vehicle;
import hibernate.helper.HibernateUtil;
import java.util.ArrayList;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Urbanovic
 */
public class OwnerDAO {

    public Owner saveOwner(Owner owner) {
        Session session = HibernateUtil.createSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(owner);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e);
        } finally {
            HibernateUtil.close();
        }
        return owner;
    }

    public Owner getOwner(int owner_id) {
        Session session = HibernateUtil.createSessionFactory().openSession();
        try {
            Owner owner = (Owner) session.get(Owner.class, owner_id);
            return owner;
        } catch (HibernateException e) {
            System.out.println(e);
        } finally {
            HibernateUtil.close();
        }
        return null;
    }

    public Owner updateOwner(Owner owner) {
        Session session = HibernateUtil.createSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.merge(owner);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e);
        } finally {
            HibernateUtil.close();
        }
        return owner;
    }

    public ArrayList<Vehicle> getVehicleSet(Owner owner) {
        Session session = HibernateUtil.createSessionFactory().openSession();
        Transaction tx = null;
        String hql = "from Vehicle as vehicle where owner_id =" + owner.getOwner_id() + ")";
        Query query = session.createQuery(hql);

        try {
            tx = session.beginTransaction();
            ArrayList<Vehicle> vehicles = (ArrayList<Vehicle>) query.list();
            tx.commit();
            return vehicles;
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
