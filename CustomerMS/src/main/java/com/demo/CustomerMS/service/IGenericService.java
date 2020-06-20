package com.demo.CustomerMS.service;

import java.util.Optional;

public interface IGenericService<T> {
	
	public T add(T t );
	public T remove(long id);
	public T update(T t);
	public Optional<T> getById(Long id);
	
	

}
