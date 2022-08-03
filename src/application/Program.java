package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;

public class Program {
    public static void main(String[] args) {
        var obj = new Department(1, "Books");

        var seller = new Seller(21, "Bob", "Bob@gmail.com",
                new Date(), 3000.0, obj);

        //criando um SellerDao, mas chamando uma classe
        //que instancia ele lá.
        var sellerDao = DaoFactory.createSellerDao();

        System.out.print(seller);
    }
}
