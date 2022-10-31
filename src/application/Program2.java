package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== TESTE 01: department findById ===");
		Department dep = departmentDao.findById(7);
		System.out.println(dep);
		
		System.out.println("\n=== TESTE 02: department findAll ===");
		List<Department> list = departmentDao.findAll();
		for(Department dep1 : list) {
			System.out.println(dep1);
		}
		
		System.out.println("\n=== TESTE 03: department insert ===");
		Department dep3 = new Department(null, "D3");
		//departmentDao.insert(dep3);
		System.out.println("Inserted! Department Id = " + dep.getId()); 
		
		System.out.println("\n=== TESTE 04: department update ===");
		//dep.setName("Internet");
		departmentDao.update(dep);
		
		System.out.println("\n=== TESTE 05: department delete ===");
		departmentDao.deleteById(8);
	}

}
