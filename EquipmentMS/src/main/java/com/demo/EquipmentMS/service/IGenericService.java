package com.demo.EquipmentMS.service;

public interface IGenericService<T> {
	
	public T add(T t );
	public T remove(long id);
	public T update(T t);
	public T getById(Long id);
	
	

}
