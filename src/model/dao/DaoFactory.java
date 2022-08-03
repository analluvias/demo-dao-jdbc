package model.dao;

import model.dao.impl.SellerDaoJDBC;

//instancia os nossos DAOS;
public class DaoFactory {

    public static SellerDao createSellerDao(){
        return new SellerDaoJDBC();
    }

}
