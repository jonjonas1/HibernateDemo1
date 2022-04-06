package com.control;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.Player;

public class HibernatePUT_creates {

	public static void main(String[] args) {
		//when a PUT request creates a resource the server will respond with a 201 created
		try {
		Configuration config = new Configuration().configure();
		
		config.addAnnotatedClass(com.Player.class);
		StandardServiceRegistryBuilder builder = 
				new StandardServiceRegistryBuilder().applySettings(config.getProperties());
		SessionFactory factory = config.buildSessionFactory(builder.build());
		
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Player p1 = new Player(3,"Messi", "Regar", 24); //if id has generatedvalue no id needed
//		Player p2 = new Player(121,"Tavarali", "Bokhtar", 18);
		session.save(p1);
//		session.save(p2);
		
		//if use hbm2ddl.auto to 'update' it only insert additional data below
		//if use hbm2ddl.auto 'create' drop and re-create the db schema from zero		
		
		
		//Ex: Auto generate id value with @GeneratedValue on instances, no need to pass
		Player p4 = new Player("David", "vakhsh", 22);
		Player p5 = new Player("Tavarali", "chashma", 23);
				
		session.save(p4);
		session.save(p5);
		
		
		transaction.commit();
		session.close();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
