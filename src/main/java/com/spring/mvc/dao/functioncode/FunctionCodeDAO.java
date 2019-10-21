package com.spring.mvc.dao.functioncode;

import java.util.List;

import com.spring.mvc.domain.FunctionCodes;

public interface FunctionCodeDAO {

	public void save(FunctionCodes fc);
	public void update(FunctionCodes fc);
	public void delete(int fcId);
	public List<FunctionCodes> findByProperty(String searchobj, Object searchparam);
	public List<FunctionCodes> findAll();
}
