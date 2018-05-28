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

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(bdd.Data.class);

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Data data = new Data();

		data.setUser("pepe1");
		data.setCiudad("qwe");
		data.setEdad("23");
		
		Transaction tx = session.beginTransaction();
		try {
			session.saveOrUpdate(data);
			System.out.println("Se genero el registro con exito.....!!");
			
			tx.commit();
			
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<Data> cq = cb.createQuery(Data.class);
			//Root<Data> rp = cq.from(Data.class);
			//cq.select(rp).where(cb.like(rp.get("nombre"), "%s%"));
			List<Data> lista = session.createQuery(cq).getResultList();
			for(Data p : lista) {
				System.out.println(p);
			}
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}

	}
}
