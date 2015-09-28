/**
 * 
 */
package com.joaoemedeiros.dao;

import com.joaoemedeiros.entity.Carro;

/**
 * @author joaomedeiros95
 *
 */
public class CarroDao extends AbstractDao<Carro> {

	public static AbstractDao<Carro> getInstance() {
		if(instance == null) {
			instance = new CarroDao();
		}
		return instance;
	}

	
}
