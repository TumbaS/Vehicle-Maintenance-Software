/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.Logo;
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
public class LogoDAO {

    public Logo saveLogo(Logo logo) {
        Session session = HibernateUtil.createSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(logo);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e);
        } finally {
            HibernateUtil.close();
        }
        return logo;
    }

    public Logo getLogo(int logo_id) {
        Session session = HibernateUtil.createSessionFactory().openSession();
        try {
            Logo logo = (Logo) session.get(Logo.class, logo_id);
            return logo;
        } catch (HibernateException e) {
            System.out.println(e);
        } finally {
            HibernateUtil.close();
        }
        return null;
    }

    public Logo getLogoByBrand(String brand) {
        Session session = HibernateUtil.createSessionFactory().openSession();
        Transaction tx = null;
        String hql = "from Logo as logo where logo.brand='" + brand + "'";
        Query query = session.createQuery(hql);
        List<Logo> logos = null;

        try {
            tx = session.beginTransaction();
            logos = query.list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e);
        } finally {
            HibernateUtil.close();
        }
        for (int i = 0; i < logos.size(); i++) {
            Logo logo = logos.get(i);
            return logo;
        }
        return null;
    }

}
