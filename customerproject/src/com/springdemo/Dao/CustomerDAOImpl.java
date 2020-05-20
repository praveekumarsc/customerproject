package com.springdemo.Dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		
		//get the current hibernate session
		Session currentSession=sessionFactory.getCurrentSession();
		
		//creatre query
		Query<Customer> theQuery=currentSession.createQuery("from Customer order by firstName",Customer.class);
		
		//execute query and get the result list
		List<Customer> customers=theQuery.getResultList();
		
		//return result
		return customers;
	}

	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		
		
		//get the current hibernate session
		Session currentSession=sessionFactory.getCurrentSession();
		
		//save the customer
		currentSession.saveOrUpdate(theCustomer);
		
		
	}

	@Override
	@Transactional
	public Customer getCustomer(int theId) {
		
		//get the current hibernate session
		Session currentSession=sessionFactory.getCurrentSession();
		
		
		//now retrieve/read the from database using the primary key
		Customer theCustomer=currentSession.get(Customer.class,theId);
		
		
		return theCustomer;
	}

	@Override
	@Transactional
	public void deleteCustomer(int theId) {
		
		//get the current hibernate session
		Session currentSession=sessionFactory.getCurrentSession();
		
		Query theQuery=currentSession.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", theId);
		theQuery.executeUpdate();
		
		
		
	}

}
