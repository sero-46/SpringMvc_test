package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.context.spi.CurrentSessionContext;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<Customer> getCustomers() {
		
		Session currentSession=sessionFactory.getCurrentSession();
		 
		Query<Customer> theQuery=currentSession.createQuery("from Customer order by firstname",Customer.class);
		List<Customer> customersList=theQuery.getResultList();
		
		return customersList;
	}


	@Override
	public void saveCustomer(Customer theCustomer) {
		
		Session currentSession=sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theCustomer);
	}


	@Override
	public Customer getCustomerId(int theId) {
		
		Session currentSession=sessionFactory.getCurrentSession();
		
		Customer customer=currentSession.get(Customer.class,theId);
		return customer;
	}


	@Override
	public void deleteCustomerId(int theId) {
	
		Session currentSession=sessionFactory.getCurrentSession();
		Query<Customer> theQuery=
				currentSession.createQuery("delete from Customer where id=:customerId")
				.setParameter("customerId", theId);
		theQuery.executeUpdate();
	}

	@Override
	public Customer searchCustomerId(int theId) {
		
		Session currentSession=sessionFactory.getCurrentSession();
		Query<Customer> theQuery=
		currentSession.createQuery("from Customer where id=:cusId").setParameter("cusId", theId);
		Customer  customer=theQuery.getSingleResult();
		return customer;
	}




	


	

}
