package com.rays.cache;

import java.util.Iterator;
import java.util.List;

import org.hibernate.CacheMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rays.user.UserDTO;

public class TestQuerryCache {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		Query q = session.createQuery("from UserDTO where id = 1");

		q.setCacheable(true);

		List list = q.list();

		Iterator it = list.iterator();

		while (it.hasNext()) {

			UserDTO dto = (UserDTO) it.next();
			System.out.print(dto.getId());
			System.out.print("\t" + dto.getFirstName());
			System.out.print("\t" + dto.getLastName());
			System.out.print("\t" + dto.getLoginId());
			System.out.print("\t" + dto.getPassword());
			System.out.print("\t" + dto.getDob());
			System.out.println("\t" + dto.getAddress());
		}
		Query q1 = session.createQuery("from UserDTO where id = 1");
		q1.setCacheable(true);

		/* q1.setCacheMode(CacheMode.REFRESH); */
		List list2 = q1.list();

		Iterator it2 = list2.iterator();

		while (it2.hasNext()) {

			UserDTO dto1 = (UserDTO) it2.next();

			System.out.print(dto1.getId());
			System.out.print("\t" + dto1.getFirstName());
			System.out.print("\t" + dto1.getLastName());
			System.out.print("\t" + dto1.getLoginId());
			System.out.print("\t" + dto1.getPassword());
			System.out.print("\t" + dto1.getDob());
			System.out.println("\t" + dto1.getAddress());

		}

	}
}
