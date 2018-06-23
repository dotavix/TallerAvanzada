package bdd;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import bot.PGP;

public class HibernateApp {

	private static final SessionFactory factory;

	static {
		try {
			factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		} catch (HibernateException he) {
			System.err.println("Ocurrió un error en la inicialización de la SessionFactory: " + he);
			throw new ExceptionInInitializerError(he);
		}
	}

	public static SessionFactory getSessionFactory() {
		return factory;
	}

	// public void connect() {
	// cfg = new Configuration().configure("hibernate.cfg.xml");
	// factory = cfg.buildSessionFactory();
	// }
	//
	// public void close() {
	// factory.close();
	// }

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

	public Data obtainData(String user) throws Exception {

		Data ret = new Data();
		Session session = factory.openSession();

		try {
			ret = (Data) session.get(Data.class, user);
		} catch (Exception e) {
			e.printStackTrace();
			Data dat = new Data();
			dat.setUser(user);
			this.saveData(dat);
			ret = dat;
			PGP.GenerateKeyPairRSA(dat.getUser(), dat.getPasswordRSA());
		} finally {
			session.close();
		}

		return ret;
	}

}
