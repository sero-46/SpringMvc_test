package com.luv2code.springdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.context.spi.CurrentSessionContext;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.entity.Staff;


@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<Customer> getCustomers() {
		
		Session currentSession=sessionFactory.getCurrentSession();
		String HQL="select c from Customer c LEFT JOIN  FETCH c.staff";
		Query<Customer> theQuery=currentSession.createQuery(HQL,Customer.class);
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
	public List<Customer> searchCustomerId(String theName) {
		
		Session currentSession=sessionFactory.getCurrentSession();
		Query  theQuery= null;
		if (theName != null && theName.trim().length() > 0) {
		theQuery=currentSession.createQuery("from Customer where lower(firstname) =:cusId", Customer.class);
		theQuery.setParameter("cusId", theName.toLowerCase());
		}
		else {
		theQuery =currentSession.createQuery("from Customer", Customer.class);			
		}
		List<Customer> customer =theQuery.getResultList();
		return customer;
	}
	
	@Override
	public List<Staff> queryCustomerId(int theCusId) {
		
		Session currentSession=sessionFactory.getCurrentSession();
		Query  theQuery= null;
		theQuery =currentSession.createQuery("from Staff where stfIid=:cus_id", Staff.class);
		theQuery.setParameter("cus_id", theCusId);
			
		
		List<Staff> customer =theQuery.getResultList();
		return customer;
	}
	
	@Override
	public List<Customer> searchcusStaff(int theCusId) {
		
		Session currentSession=sessionFactory.getCurrentSession();
		//String HQL="select c from Customer c LEFT JOIN  FETCH c.staff where c.id=:stf_id";
		//currentSession.createQuery(HQL,Customer.class);
		//theQuery.setParameter("stf_id", theCusId);
		Query<Customer> theQuery=null;
		List<Customer> customer=new ArrayList<Customer>();
		theQuery = currentSession.createSQLQuery("CALL user_query(:customerCode)")
			.addEntity(Customer.class)
			.setParameter("customerCode", theCusId);
		 customer=theQuery.getResultList();
		
		return customer;
	}
	
	

}
