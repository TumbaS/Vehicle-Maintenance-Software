package dao;

import classes.Part;
import hibernate.helper.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Urbanovic
 */
public class PartDAO {

    public Part savePart(Part part) {
        Session session = HibernateUtil.createSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(part);
            tx.commit();
            System.out.println("Part saved!");
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e);
        } finally {
            HibernateUtil.close();
        }
        return part;
    }

    public Part getPart(int part_id) {
        Session session = HibernateUtil.createSessionFactory().openSession();
        try {
            Part part = (Part) session.get(Part.class, part_id);
            return part;
        } catch (HibernateException e) {
            System.out.println(e);
        } finally {
            HibernateUtil.close();
        }
        return null;
    }

    public Part updatePart(Part part) {
        Session session = HibernateUtil.createSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.merge(part);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e);
        } finally {
            HibernateUtil.close();
        }
        return part;
    }
}
