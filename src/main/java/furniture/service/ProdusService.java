package main.java.furniture.service;

import java.util.Date;
import java.util.List;

import main.java.furniture.dao.ProdusDao;
import main.java.furniture.model.Produs;

public class ProdusService {

	private ProdusDao productDao = new ProdusDao();
	private UserService userService = new UserService();
	
	public List<Produs> toateProdusele() {
		return productDao.toateProdusele();
	}
	
	public void creazaProdus(Produs produs) {
		produs.setUser(userService.getUserLogat());
		produs.setData(new Date());
		productDao.create(produs);
	}
	
}
