package com.dragon.coorperation.service;

import java.util.List;

import com.ganji.refactoring.base.request.demo.BaseServiceImpl;

public class AuthorityServiceImpl extends BaseServiceImpl implements AuthorityService {

	@Override
	public void editAuthority(AuthorityPO authority) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<AuthorityPO> findAllByUserId(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AuthorityPO> findAllByRoleId(long roleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addAuthorityToRole(RolePO role, long authorityId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addAuthoritiesToRole(RolePO role, long[] authorityIds) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeAuthorityFromRole(RolePO role, long authorityId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeAuthoritiesFromRole(RolePO role, long[] authorityIds) {
		// TODO Auto-generated method stub

	}

}
