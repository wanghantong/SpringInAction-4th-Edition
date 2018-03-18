package com.dragon.coorperation.service;

import java.util.List;

import com.ganji.refactoring.base.request.demo.BaseService;

/**
 * 
 * @author Dragon
 * 
 *         <Date> Jan 5, 2017
 * 
 *         <Specification> :角色业务层接口
 */
public interface RoleService extends BaseService {

	/**
	 * 编辑角色
	 * 
	 * @param role
	 * @return
	 */
	public RolePO editRole(RolePO role);

	/**
	 * 为用户授予角色
	 * 
	 * @param user
	 */
	public void awardRole(UserPO user, long roleId);

	/**
	 * 为批量用户授予角色
	 * 
	 * @param users
	 */
	public void awardRole(List<UserPO> users, long roleId);

	/**
	 * 撤销单一用户单一角色
	 * 
	 * @param user
	 */
	public void cancelRole(UserPO user, long roleId);

	/**
	 * 批量撤销用户单一角色
	 * 
	 * @param users
	 */
	public void cancelRoles(List<UserPO> users, long roleId);

	/**
	 * 为单一用户批量赋予角色
	 * 
	 * @param user
	 * @param ids
	 */
	public void awardRoles(UserPO user, List<Long> ids);

	/**
	 * 为批量用户批量赋予角色
	 * 
	 * @param users
	 * @param ids
	 */
	public void awardRoles(List<UserPO> users, List<Long> ids);

	/**
	 * 查看角色列表
	 * 
	 * @return
	 */
	public List<RolePO> findAll();

	/**
	 * 查询某一用户的角色
	 * 
	 * @param userId
	 * @return
	 */
	public List<RolePO> findRoleByUserId(long userId);

	public List<RolePO> findAllRoles();

	public List<AuthorityPO> findAllAuthority();

	public List<RolePO> findAllRoles(long userId);

	public List<AuthorityPO> findAllAuthority(long userId);

}
