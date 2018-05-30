package bdd;

//import java.util.List;
//
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Expression;
//import javax.persistence.criteria.Path;
//import javax.persistence.criteria.Root;
//
//import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
//import org.hibernate.criterion.Restrictions;

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
		}
	}

	public Data obtainData(String user) {
		
		Data ret = new Data();
		Session session = factory.openSession();
		
		try {
			String cq = "from Data where user = '"+user+"'";
			ret = (Data)session.createQuery(cq).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			Data dat = new Data();
			dat.setUser(user);
			this.saveData(dat);
			ret = dat;
		} finally {
			session.close();
		}
		
		return ret;
	}
	
}
