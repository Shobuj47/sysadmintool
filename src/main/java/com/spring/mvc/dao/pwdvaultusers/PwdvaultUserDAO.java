package com.spring.mvc.dao.pwdvaultusers;

import java.util.List;
import com.spring.mvc.domain.PwdVaultUsers;

public interface PwdvaultUserDAO {
	public void save(PwdVaultUsers pwdvaultuser);
	public void update(PwdVaultUsers pwdvaultuser);
	public void delete(int pwdvaultuserid);
	public List<PwdVaultUsers> findByProperty(String searchobj, Object searchparam);
	public List<PwdVaultUsers> findAll();
}
