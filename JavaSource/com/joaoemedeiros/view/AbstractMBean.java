/**
 * 
 */
package com.joaoemedeiros.view;

import java.util.List;

/**
 * @author joaomedeiros95
 *
 */
public abstract class AbstractMBean<T> {

	protected T obj;
	protected List<T> all;
	protected String submitButton;
	
	public T getObj() {
		return obj;
	}
	public void setObj(T obj) {
		this.obj = obj;
	}
	public List<T> getAll() {
		return all;
	}
	public void setAll(List<T> all) {
		this.all = all;
	}
	public String getSubmitButton() {
		return submitButton;
	}
	public void setSubmitButton(String submitButton) {
		this.submitButton = submitButton;
	}
	
}
