package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;

public class Program {
    public static void main(String[] args) {
        //criando um SellerDao, mas chamando uma classe
        //que instancia ele lá.
        var sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== teste 1: seller findById===");
        Seller seller = sellerDao.findById(3);

        System.out.print(seller);
    }
}
