package com.dragon.coorperation.service;

import java.util.List;

import com.ganji.refactoring.base.request.demo.BaseService;
import com.learn.generic.base.PartnerPO;

/**
 * @author Dragon
 * 
 *         <Date> Jan 5, 2017
 * 
 *         <Specification> : 用户业务层接口
 * 
 */
public interface UserService extends BaseService {

	/**
	 * @param partnerId
	 * 
	 *            根据合作方ID查询合作方的基本信息
	 * 
	 * @return
	 */
	public PartnerPO findByPartnerId(Long partnerId);

	/**
	 * 查询当前用户对接的全部合作方
	 * 
	 * @return
	 */
	public List<PartnerPO> findPartners();

	/**
	 * @param id
	 *            根据用户ID查询用户的基本信息
	 * 
	 * @return
	 */
	public UserPO findUserById(long id);

	/**
	 * @param id
	 *            根据用户ID查询当前用户所有的角色
	 * 
	 * @return
	 */
	public List<RolePO> getRole(long userId);

	/**
	 * @param list
	 *            根据角色查询当前用户的全部权限
	 * 
	 * @return
	 */
	public List<AuthorityPO> getAuthority(List<RolePO> list);

	/**
	 * @param partners
	 *            增加关联的合作方
	 * 
	 * @return
	 */
	public List<PartnerPO> addPartner(List<PartnerPO> partners);

	/**
	 * @param partners
	 * @param PartnerId
	 *            根据PartnerId移除partner
	 * 
	 * @return
	 */
	public List<PartnerPO> removePartner(List<PartnerPO> partners, long PartnerId);

	/**
	 * @param users
	 * @param user
	 *            添加下属员工
	 * 
	 * @return
	 */
	public List<UserPO> addSubUser(List<UserPO> users, UserPO user);

	/**
	 * @param users
	 * @param user
	 *            移除下级员工
	 * 
	 * @return
	 */
	public List<UserPO> removeSubUser(List<UserPO> users, UserPO user);

	/**
	 * 获取上级
	 * 
	 * @return
	 */
	public UserPO getParent();

}
