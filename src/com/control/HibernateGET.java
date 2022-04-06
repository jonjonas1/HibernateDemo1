package com.control;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.Player;

public class HibernateGET {

	public static void main(String[] args) {
		try {
			Configuration config = new Configuration().configure();
			
			config.addAnnotatedClass(com.Player.class);
			StandardServiceRegistryBuilder builder = 
					new StandardServiceRegistryBuilder().applySettings(config.getProperties());
			SessionFactory factory = config.buildSessionFactory(builder.build());
			
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();

			
			//EX:  To retrieve a record
			Player p  = session.get(Player.class, 1);
			System.out.println("Detail: "+p);
			

			transaction.commit();
			session.close();
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}

	}

}
