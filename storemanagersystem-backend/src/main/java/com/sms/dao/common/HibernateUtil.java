package com.sms.dao.common;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.sms.error.ErrorCodes;

public class HibernateUtil {
	private static SessionFactory sessionFactory;

	static {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		sessionFactory = configuration.buildSessionFactory(builder.build());
	}

	public static SessionFactory getSessionFactory() {

		return sessionFactory;

	}

	public static Session getSessionDAO() throws HibernateException {

		Session session = sessionFactory.openSession();
		return session;
	}

	public static <T> int update(T entity) {
		Session session = getSessionDAO();
		int result = ErrorCodes.OPEN_TRANSACTION_FALSED;
		try {
			session.getTransaction().begin();
			session.update(entity);
			session.getTransaction().commit();

			result = ErrorCodes.SUCCESS;

		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.flush();
			session.clear();
			session.close();
		}

		return result;
	}

	public static <T> T updateObject(T entity) {
		Session session = getSessionDAO();
		try {
			session.getTransaction().begin();
			session.saveOrUpdate(entity);
			session.getTransaction().commit();

		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.flush();
			session.clear();
			session.close();
		}

		return entity;
	}

	public static <T> int insert(T entity) {
		Session session = getSessionDAO();
		int result = ErrorCodes.OPEN_TRANSACTION_FALSED;
		try {
			session.getTransaction().begin();
			session.save(entity);
			session.getTransaction().commit();

			result = ErrorCodes.SUCCESS;

		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.flush();
			session.clear();
			session.close();
		}

		return result;
	}

	public static <T> T insertObject(T entity) {
		Session session = getSessionDAO();
		try {
			session.getTransaction().begin();
			session.saveOrUpdate(entity);
			session.getTransaction().commit();

		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.flush();
			session.clear();
			session.close();
		}

		return entity;
	}

	public static <T> int deleteById(T entity, long id) {
		Session session = getSessionDAO();
		int result = ErrorCodes.OPEN_TRANSACTION_FALSED;
		try {
			session.getTransaction().begin();
			Object config = session.get(entity.getClass(), id);
			if (null == config)
				result = ErrorCodes.NOT_FOUND_OBJ;
			else {
				session.delete(config);
				session.getTransaction().commit();

				result = ErrorCodes.SUCCESS;
			}
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.flush();
			session.clear();
			session.close();
		}
		return result;
	}

	public static void main(String[] args) {
		getSessionFactory();
	}

}
