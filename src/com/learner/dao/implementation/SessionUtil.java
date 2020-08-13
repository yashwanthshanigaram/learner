package com.learner.dao.implementation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.learner.dao.implementation.SessionUtil;

public class SessionUtil {
	
	  private static SessionUtil instance = new SessionUtil();
	  private SessionFactory sessionFactory;

	  public static SessionUtil getInstance() {
	    return instance;
	  }

	  private SessionUtil() {
	    Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
	    StandardServiceRegistryBuilder builder =
	        new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
	    sessionFactory = configuration.buildSessionFactory(builder.build());
	  }

	  public Session getSession() {
	    Session session = getInstance().sessionFactory.openSession();
	    return session;
	  }

}
