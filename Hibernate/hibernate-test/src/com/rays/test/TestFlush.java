package com.rays.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rays.user.UserDTO;

public class TestFlush {
	public static void main(String[] args) {
		UserDTO dto = new UserDTO();

		dto.setFirstName("Ankit");
		dto.setLastName("Singh");
		dto.setLoginId("ankit@gmail.com");
		dto.setPassword("ankit@123");
		dto.setDob(new Date());
		dto.setAddress("Singrauli");

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();
		session.save(dto);

		/* session.flush(); */

		System.out.println("id=" + dto.getId());

		dto = (UserDTO) session.get(UserDTO.class, 1);
		System.out.println("first name = " + dto.getFirstName());

		tx.commit();

		session.close();
	}

}