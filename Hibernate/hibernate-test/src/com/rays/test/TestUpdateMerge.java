package com.rays.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rays.user.UserDTO;



/**
 * @author S K ENTERPRISES
 * 
 * if we use merge it will check the data from database first time and then update and from next time will get the data from cache, 
 * but in update it will not use cache it will update.
 *
 */
public class TestUpdateMerge {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		UserDTO dto1 = (UserDTO) session.get(UserDTO.class, 1);

		session.close();

		dto1.setFirstName("salma");

		Session session2 = sf.openSession();

		Transaction tx = session2.beginTransaction();

		/* session2.merge(dto1); */

		 session2.update(dto1); 

		tx.commit();

		session2.close();

	}

}