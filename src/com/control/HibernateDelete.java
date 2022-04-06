package com.control;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.Player;

public class HibernateDelete {

	public static void main(String[] args) {
		try {
			Configuration config = new Configuration().configure();
			
			config.addAnnotatedClass(com.Player.class);
			StandardServiceRegistryBuilder builder = 
					new StandardServiceRegistryBuilder().applySettings(config.getProperties());
			SessionFactory factory = config.buildSessionFactory(builder.build());
			
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			
			Player p = session.get(Player.class, 10);
			
			System.out.println("Will be deleted from DB: "+p);
			
			session.delete(p);
			
			transaction.commit();
			session.close();
		} 
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
