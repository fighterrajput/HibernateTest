package com.rays.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rays.user.UserDTO;

public class TestSavePersist {
	public static void main(String[] args) {
		UserDTO dto = new UserDTO();

		dto.setFirstName("jay");
		dto.setId(5);
		dto.setLastName("singh");
		dto.setLoginId("jaysingh@gmail.com");
		dto.setPassword("123");
		dto.setDob(new Date());
		dto.setAddress("singrauli");

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		int i = (int) session.save(dto);

		System.out.println("i => " + i);

		session.persist(dto);

		tx.commit();

		session.close();
	}

}
