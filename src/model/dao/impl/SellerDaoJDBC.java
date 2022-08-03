package model.dao.impl;

import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SellerDaoJDBC implements SellerDao {

    private Connection conn;

    public SellerDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Seller obj) {

    }

    @Override
    public void update(Seller obj) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Seller findById(Integer id) {
        PreparedStatement st = null; //"enviador de clausulas"
        ResultSet rs = null; // "recebedor de resultados"

        try {
            st = conn.prepareStatement("SELECT seller.*, department.name AS DepName " +
                    "FROM seller " +
                    "INNER JOIN department " +
                    "ON seller.DepartmentId = department.Id " +
                    "WHERE seller.id = ?");

            st.setInt(1, id);

            rs = st.executeQuery();

            //testando se veio algum registro
            if (rs.next()){

                //criando o departamento no java
                Department dep = instantiateDepartment(rs);


                //instanciando o vendedor no java
                Seller seller = instantiateSeller(rs, dep);

                return seller;
            }

            //se não veio registro
            return null;
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            //fechando o enviador de clausulas
            DB.closeStatement(st);

            //fechando o recebedor de resultados
            DB.closeResultSet(rs);
        }
    }

    private Seller instantiateSeller(ResultSet rs, Department dep) throws SQLException {
        Seller seller = new Seller();
        //setanto o id do vendedor para o valor
        //guardado no ResultSet
        seller.setId(rs.getInt("Id"));

        //setanto o nome do vendedor para o valor
        //guardado no ResultSet
        seller.setName(rs.getString("Name"));

        //setanto o email do vendedor para o valor
        //guardado no ResultSet
        seller.setEmail(rs.getString("Email"));

        //setanto o salario base do vendedor para o valor
        //guardado no ResultSet
        seller.setBaseSalary(rs.getDouble("BaseSalary"));

        //setanto o aniversario do vendedor para o valor
        //guardado no ResultSet
        seller.setBithDate(rs.getDate("BirthDate"));

        //setanto o departamento do vendedor para o dep
        //criado acima
        seller.setDepartment(dep);

        return seller;
    }

    private Department instantiateDepartment(ResultSet rs) throws SQLException {
        Department dep = new Department();
        //setando o id de dep para o valor dentro do ResultSet
        //no campo DepartmentId
        dep.setId(rs.getInt("DepartmentId"));

        //setando o nome de dep para o valor dentro do ResultSet
        //no campo DepName
        dep.setName(rs.getString("DepName"));

        return dep;
    }

    @Override
    public List<Seller> findAll() {
        return null;
    }
}
