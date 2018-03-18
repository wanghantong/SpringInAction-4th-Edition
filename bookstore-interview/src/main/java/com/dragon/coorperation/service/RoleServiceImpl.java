package com.dragon.coorperation.service;

import java.util.List;

import com.ganji.refactoring.base.request.demo.BaseServiceImpl;

public class RoleServiceImpl extends BaseServiceImpl implements RoleService {

	@Override
	public RolePO editRole(RolePO role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void awardRole(UserPO user, long roleId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void awardRole(List<UserPO> users, long roleId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelRole(UserPO user, long roleId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelRoles(List<UserPO> users, long roleId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void awardRoles(UserPO user, List<Long> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void awardRoles(List<UserPO> users, List<Long> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<RolePO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RolePO> findRoleByUserId(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RolePO> findAllRoles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AuthorityPO> findAllAuthority() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RolePO> findAllRoles(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AuthorityPO> findAllAuthority(long userId) {
		// TODO Auto-generated method stub
		return null;
	}


}
