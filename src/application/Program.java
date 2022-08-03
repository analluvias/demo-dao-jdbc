package application;

import model.dao.DaoFactory;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        //criando um SellerDao, mas chamando uma classe
        //que instancia ele lá.
        var sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== teste 1: seller findById===");
        Seller seller = sellerDao.findById(3);

        System.out.print(seller);

        
        System.out.println("\n=== teste 2: seller findByDepartment===");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);

        for (Seller vendedor: list) {
            System.out.println(vendedor);
        }

        System.out.println("\n=== teste 3: seller findAll===");
        list = sellerDao.findAll();

        for (Seller vendedor: list) {
            System.out.println(vendedor);
        }


        System.out.println("\n=== teste 4: seller insert===");
        Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(),
                4000.0, department);

        sellerDao.insert(newSeller);
        System.out.println("Inserção: " + newSeller.getId());

    }
}
