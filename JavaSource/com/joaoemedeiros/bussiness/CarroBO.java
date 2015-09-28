/**
 * 
 */
package com.joaoemedeiros.bussiness;

import java.util.List;

import com.joaoemedeiros.dao.CarroDao;
import com.joaoemedeiros.entity.Carro;
import com.joaoemedeiros.entity.Entidade;

/**
 * @author joaomedeiros95
 *
 */
public class CarroBO {
	
	CarroDao dao;

	public List<? extends Entidade> getAll() {
		dao = (CarroDao) CarroDao.getInstance();
		return dao.getAll(Carro.class);
	}
	
	public void insert(Carro objeto) {
		dao = (CarroDao) CarroDao.getInstance();
		dao.save(objeto);
	}
	
	public void update(Carro objeto) {
		dao = (CarroDao) CarroDao.getInstance();
		dao.update(objeto);
	}
	
	public void remove(Carro objeto) {
		dao = (CarroDao) CarroDao.getInstance();
		dao.delete(objeto);
	}
	
	public Carro getById(Integer id) {
		dao = (CarroDao) CarroDao.getInstance();
		return dao.getById(id, Carro.class);
	}
	
}
