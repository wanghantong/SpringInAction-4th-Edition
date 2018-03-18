package com.dragon.coorperation.service;

import java.util.List;

public interface ContractService {

	/**
	 * 保存合同、新建合同
	 * 
	 * @param contract
	 */
	public void saveContract(Contract contract);

	/**
	 * 终止合同
	 * 
	 * @param contractNO
	 */
	public Contract endContract(long contractNO, UserPO user);

	/**
	 * 修改合同
	 * 
	 * @param contractNO
	 * @param user
	 */
	public void editContract(long contractNO, UserPO user);

	/**
	 * 根据用户ID查询当前用户所有的合同
	 * 
	 * @param user
	 * @return
	 */
	public List<Contract> getContracts(long userId);

	/**
	 * 根据用户ID查询有效的合同
	 * 
	 * @param userId
	 * @return
	 */
	public List<Contract> getValidContracts(long userId);

}
