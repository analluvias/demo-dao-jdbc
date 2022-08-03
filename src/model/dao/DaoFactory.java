package model.dao;

import db.DB;
import model.dao.impl.SellerDaoJDBC;

//instancia os nossos DAOS;
public class DaoFactory {

    public static SellerDao createSellerDao(){
        return new SellerDaoJDBC(DB.getConnection());
    }

}
