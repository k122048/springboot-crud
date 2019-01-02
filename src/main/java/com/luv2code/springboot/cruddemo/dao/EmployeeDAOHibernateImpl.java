package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOHibernateImpl(EntityManager theEntityManager) {
        this.entityManager = theEntityManager;
    }

    @Override
    public Employee getEmployeeById(int Id) {
        Session session = entityManager.unwrap(Session.class);


        Employee employee = session.get(Employee.class,Id);

        return employee;
    }

    @Override
    public void save(Employee employee) {

        Session session = entityManager.unwrap(Session.class);

        session.saveOrUpdate(employee);
    }

    @Override
    public void deleteById(int Id) {
        Session session = entityManager.unwrap(Session.class);

        Query theQuery = session.createQuery("delete from Employee where id=:Id")
                .setParameter("Id",Id);

        theQuery.executeUpdate();
    }

    @Override
    public List<Employee> findAll(){
        Session session = entityManager.unwrap(Session.class);

        Query<Employee> theQuery = session.createQuery("from Employee",Employee.class);

        List<Employee> employeeList = theQuery.getResultList();

        return employeeList;
    }
}
