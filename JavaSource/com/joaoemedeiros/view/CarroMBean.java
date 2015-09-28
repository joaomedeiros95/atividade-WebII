/**
 * 
 */
package com.joaoemedeiros.view;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.joaoemedeiros.bussiness.CarroBO;
import com.joaoemedeiros.entity.Carro;

/**
 * @author joaomedeiros95
 *
 */
@ManagedBean
@SessionScoped
public class CarroMBean extends AbstractMBean<Carro> {
	
	public static final String FORM_PAGE = "/pages/carro/form.xhtml";
	
	private CarroBO bo;
	
	public CarroMBean() {
		reset();
	}

	public void reset() {
		all = new ArrayList<Carro>();
		obj = new Carro();
	}
	
	public String preInsert() {
		obj = new Carro();
		setSubmitButton("Adicionar");
		return FORM_PAGE;
	}
	
	public String insert() {
		bo = new CarroBO();
		if(obj.getId() == null) {
			bo.insert(obj);
		} else {
			bo.update(obj);
		}
		return "/index.xhtml";
	}
	
	public String delete() {
		Integer id = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id"));
		bo = new CarroBO();
		Carro c = bo.getById(id);
		bo.remove(c);
		return null;
	}
	
	public String preUpdate() {
		setSubmitButton("Atualizar");
		Integer id = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id"));
		bo = new CarroBO();
		obj = bo.getById(id);
		return FORM_PAGE;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Carro> getAll() {
		bo = new CarroBO();
		all = (List<Carro>) bo.getAll();
		return all;
	}
	
}
