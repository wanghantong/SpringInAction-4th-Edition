package com.dragon.coorperation.service;

import java.util.List;

import com.ganji.refactoring.base.request.demo.BaseServiceImpl;
import com.learn.generic.base.PartnerPO;

public class UserServiceImpl extends BaseServiceImpl implements UserService {

	@Override
	public PartnerPO findByPartnerId(Long partnerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PartnerPO> findPartners() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserPO findUserById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RolePO> getRole(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AuthorityPO> getAuthority(List<RolePO> list) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PartnerPO> addPartner(List<PartnerPO> partners) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PartnerPO> removePartner(List<PartnerPO> partners, long PartnerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserPO> addSubUser(List<UserPO> users, UserPO user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserPO> removeSubUser(List<UserPO> users, UserPO user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserPO getParent() {
		// TODO Auto-generated method stub
		return null;
	}


}
