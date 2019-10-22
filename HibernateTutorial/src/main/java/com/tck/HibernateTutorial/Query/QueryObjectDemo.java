package com.tck.HibernateTutorial.Query;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.tck.HibernateTutorial.HibernateUtils;
import com.tck.HibernateTutorial.entities.Department;
import com.tck.HibernateTutorial.entities.Employee;

public class QueryObjectDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getDepartment();
//		SessionFactory factory=HibernateUtils.getSessionFactory();
//		Session session = factory.getCurrentSession();
//		try {
//			session.getTransaction().begin();
//			String sql="Select e from "+Employee.class.getName()+" e "
//					+ "order by e.empName, e. empNo";
//			Query<Employee> query = session.createQuery(sql);
//			List<Employee> employees=query.getResultList();
//			for(Employee emp:employees) {
//				System.out.println("Emp: "+emp.getEmpName()+ " : "+emp.getEmpNo());
//			}
//			session.getTransaction().commit();
//		} catch(Exception ex)
//		{
//			ex.printStackTrace();
//			session.getTransaction().rollback();
//		}
	}
	public static void getDepartment() {
		SessionFactory factory=HibernateUtils.getSessionFactory();
		Session session=factory.getCurrentSession();
		try {
			session.getTransaction().begin();
			String sql="Select d from "+Department.class.getName()+" d "
					+"where d.deptId = 10";
			Query<Department> query=session.createQuery(sql);
			List<Department> department =query.getResultList();
			for(Department dept : department) {
				System.out.println("Dept: "+dept.getDeptName()+ " : "+dept.getDeptNo());
			}
			session.getTransaction().commit();
		}catch(Exception ex)
		{
			ex.printStackTrace();
			session.getTransaction().rollback();
		}
	}

}
