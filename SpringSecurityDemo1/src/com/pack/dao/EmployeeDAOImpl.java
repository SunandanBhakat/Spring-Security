package com.pack.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;


import com.pack.model.Employee;
import com.pack.model.Login;


@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public void addEmployee(Employee e) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(e);
		
	}

	@Override
	public List<Employee> listEmployees() {
		
		return sessionFactory.getCurrentSession().createQuery("FROM Employee").list();
	}

	@Override
	public void deleteEmployee(int id) {
		Session session=sessionFactory.getCurrentSession();
		Employee employee=(Employee) session.get(Employee.class, id);
		
		if(employee!=null)
		{
			session.delete(employee);
		}
		
	}
	
public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException,DataAccessException
{
	System.out.println("Getting access details from employee dao!!!!");
	System.out.println(username);
	Session session=this.sessionFactory.openSession();
	
	Transaction transaction=session.beginTransaction();
	
	Query query=(Query) session.createQuery("from Login login where login.username=:user");
	query.setParameter("user", username);
	Login login1=(Login) ((org.hibernate.Query) query).uniqueResult();
	UserDetails user=null;
	if(login1!=null)
	{
		user=new User(login1.getUsername(),login1.getPassword(),true,true,true,true,new GrantedAuthority[]{ new GrantedAuthorityImpl(login1.getRole())});
	}
	transaction.commit();
	
	return user;
}
	
}
