package com.spring.mvc.services.pwdvaultuser;

import java.util.List;
import org.springframework.stereotype.Service;
import com.spring.mvc.dao.BaseDAO;

@Service
public class PwdVaultUserServiceImpl extends BaseDAO  implements PwdVaultUserService{

	@Override
	public List<Integer> getPwdVaultList(Integer user) {
		String  sql ="SELECT 	pwdvaultid FROM sysadmintool.pwdvaultusers WHERE userid = "+ user;
		List<Integer> m = getJdbcTemplate().queryForList(sql, Integer.class);
		System.out.println(sql);
		System.out.println("Listing From PwdVaultUserServiceImpl function getPwdVaultList for user " + user);
		for (int l : m) {
			System.out.println(l);
		}
		System.out.println("Listing Finished");
		return m;
	}

	
}
