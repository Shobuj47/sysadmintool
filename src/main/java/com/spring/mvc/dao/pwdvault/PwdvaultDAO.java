package com.spring.mvc.dao.pwdvault;

import java.util.List;

import com.spring.mvc.domain.Pwdvault;

public interface PwdvaultDAO {
	public void save(Pwdvault pwdvault);
	public void update(Pwdvault pwdvault);
	public void delete(int pwdvault);
	public Pwdvault findById(int id);
	public List<Pwdvault> findByProperty(String searchobj, Object searchparam);
	public List<Pwdvault> findAll();
}
