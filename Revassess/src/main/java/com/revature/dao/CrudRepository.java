package com.revature.dao;

import java.util.Set;

public interface CrudRepository<T> {

	public void Save(T t);
	public Set<T> finaAll();
	
	public void findById(int id);
	
	public boolean update(T t);
	
	public boolean deleteById(int id);
	
	
	
}