package com.rays.hql;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rays.user.UserDTO;

public class TestHQLOrderBy {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Query q = session.createQuery("from UserDTO order by firstName");
		List list = q.list();
		Iterator it = list.iterator();
		while (it.hasNext()) {
			UserDTO dto = (UserDTO) it.next();
			System.out.println( dto.getId());
			System.out.println("\t" + dto.getFirstName());
			System.out.println("\t" + dto.getLastName());
			System.out.println("\t" + dto.getLoginId());
			System.out.println("\t" + dto.getPassword());
			System.out.println("\t" + dto.getDob());
			System.out.println("\t" + dto.getAddress());

		}

	}

}
