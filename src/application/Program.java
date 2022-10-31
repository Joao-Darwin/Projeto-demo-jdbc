package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TEST 1: seller findById ===");
		Seller seller = sellerDao.findById(3);
		
		System.out.println(seller);
		
		System.out.println("\n=== TEST 2: seller findByDepartment ===");
		Department department = new Department(1, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for(Seller selle : list ) {
			System.out.println(selle);
		}
		
		System.out.println("\n=== TEST 3: seller findAll ===");
		list = sellerDao.findAll();
		for(Seller selle : list ) {
			System.out.println(selle);
		}
		
		System.out.println("\n=== TEST 4: seller insert ===");
		Seller sellenewSeller = new Seller(null, "Darwin", "darwin@gmail.com", new Date(), 4000.00, department);
		sellerDao.insert(sellenewSeller);
		System.out.println("Inserted! New Seller Id = " + sellenewSeller.getId());
		
		System.out.println("\n=== TEST 5: seller update ===");
		seller = sellerDao.findById(23);
		seller.setName("Monkey D Luffy");
		sellerDao.update(seller);
		
		System.out.println("\n=== TEST 6: seller delete ===");
		System.out.print("Informe um código: ");
		int codigo = sc.nextInt();
		sellerDao.deleteById(codigo);
		sc.close();
	}

}
