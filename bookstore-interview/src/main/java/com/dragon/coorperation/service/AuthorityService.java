package com.dragon.coorperation.service;

import java.util.List;

import com.ganji.refactoring.base.request.demo.BaseService;

public interface AuthorityService extends BaseService {

	public void editAuthority(AuthorityPO authority);

	/**
	 * 根据用户ID查询某一用户的全部权限
	 * 
	 * @param userId
	 * @return
	 */
	public List<AuthorityPO> findAllByUserId(long userId);

	/**
	 * 根据角色ID查询权限
	 * 
	 * @param roleId
	 * @return
	 */
	public List<AuthorityPO> findAllByRoleId(long roleId);

	/**
	 * 为角色赋予权限
	 * 
	 * @param role
	 * @param authorityId
	 */
	public void addAuthorityToRole(RolePO role, long authorityId);

	/**
	 * 为角色赋予多个权限
	 * 
	 * @param role
	 * @param authorityIds
	 */
	public void addAuthoritiesToRole(RolePO role, long[] authorityIds);

	/**
	 * 移除角色的某个权限
	 * 
	 * @param role
	 * @param authorityId
	 */
	public void removeAuthorityFromRole(RolePO role, long authorityId);

	/**
	 * 批量移除角色的权限
	 * 
	 * @param role
	 * @param authorityIds
	 */
	public void removeAuthoritiesFromRole(RolePO role, long[] authorityIds);

}
