package bdd;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class HibernateApp {

	private Configuration cfg;
	private SessionFactory factory;
	
	public void connect() {
		cfg = new Configuration().configure("hibernate.cfg.xml");
		factory = cfg.buildSessionFactory();
	}
	
	public void close() {
		factory.close();
	}
	
	public void saveData(Data d) {

		Session session = factory.openSession();
		Data data = d;

		Transaction tx = session.beginTransaction();
		
		try {
			session.saveOrUpdate(data);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
//			factory.close();
		}
	}

	public Data obtainData(String user) {
		
		Data ret = new Data();
		Session session = factory.openSession();
		
		Transaction tx = session.beginTransaction();
		try {
			String cq = "from Data where user = '"+user+"'";
			ret = (Data)session.createQuery(cq).getSingleResult();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
//			factory.close();
		}
		
		return ret;
	}

	public static void main(String[] args) {

//		Configuration cfg = new Configuration();
//		cfg.configure("hibernate.cfg.xml");
//		// cfg.addAnnotatedClass(bdd.Data.class);
//
//		SessionFactory factory = cfg.buildSessionFactory();
//		Session session = factory.openSession();
//		Data data = new Data();
//
//		data.setUser("pepe1");
//		data.setCiudad("qwe");
//		data.setEdad("23");
//
//		Transaction tx = session.beginTransaction();
//		try {
//			// session.saveOrUpdate(data);
//			// System.out.println("Se genero el registro con exito.....!!");
//
//			tx.commit();
//
//			// CriteriaBuilder cb = session.getCriteriaBuilder();
//			// CriteriaQuery<Data> cq = cb.createQuery(Data.class);
//			// Root<Data> rp = cq.from(Data.class);
//			// cq.select(rp).where(cb.like(rp.get("user"), "pepe1"));
//
//			String cq = "from Data where user = 'raul'";
//			List<Data> lista = session.createQuery(cq).getResultList();
//			for (Data p : lista) {
//				System.out.println(p);
//			}
//		} catch (HibernateException e) {
//			if (tx != null)
//				tx.rollback();
//			e.printStackTrace();
//		} finally {
//			session.close();
//			factory.close();
//		}
		
		Data d = new Data();
		d.setUser("test1");
		d.setCiudad("merlee");
		d.setEdad("34");
		HibernateApp ha = new HibernateApp();
		
		ha.connect();
		
		ha.saveData(d);
		String us = "jorgi3";
		try {
			System.out.println(ha.obtainData(us).toString());
		} catch (Exception e) {
			e.printStackTrace();
			Data dat = new Data();
			dat.setUser(us);
			ha.saveData(dat);
		} finally {
			ha.close();
		}
	}
}
