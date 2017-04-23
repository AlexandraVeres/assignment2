package main.java.furniture.dao;

import main.java.furniture.model.Produs;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProdusDao {

    public List<Produs> toateProdusele() {
        try {
            return DataAccess.getInstance().list("Select * from produs", new Mapper<Produs>() {

                @Override
                public Produs map(ResultSet resultSet) throws SQLException {
                    Produs p = new Produs();
                    p.setId(resultSet.getInt(1));
                    p.setNume(resultSet.getString(2));
                    p.setDescriere(resultSet.getString(3));
                    p.setCuloare(resultSet.getString(4));
                    p.setInaltime(resultSet.getDouble(5));
                    p.setLatime(resultSet.getDouble(6));
                    p.setLungime(resultSet.getDouble(7));
                    p.setPret(resultSet.getDouble(8));
                    p.setStock(resultSet.getInt(9));
                    return p;
                }
            });
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
    
    public void create(Produs prod) {
    	
    	try {
			DataAccess.getInstance().update("Insert into produs (nume,descriere,culoare,inaltime,latime,lungime,pret,stock,user,data)"
					+ " VALUES (?,?,?,?,?,?,?,?,?,?)",new Object[] { prod.getNume(), 
					prod.getDescriere(), prod.getCuloare(), prod.getInaltime(), prod.getLatime(), prod.getLungime(), prod.getPret(), 
					prod.getStock(), prod.getUser().getId(), prod.getData()});
		} catch (SQLException e) {
			throw new DaoException(e);
		}
    }

}
