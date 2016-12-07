package com.bookstore.data.tools;

public class SystemInfo {
	/**
	 * 
	 * @return 操作系统名称
	 */
	public String getOSName() {
		return System.getProperty("os.name");
	}

	/**
	 * 
	 * @return 操作系统版本
	 */
	public String getOSVersion() {
		return System.getProperty("os.version");
	}

	/**
	 * 
	 * @return 用户账户名称
	 */
	public String getOSUserName() {
		return System.getProperty("user.name");
	}

	/**
	 * 
	 * @return 用户主目录
	 */
	public String getOSUserHome() {
		return System.getProperty("user.home");
	}

	/**
	 * 
	 * @return 用户当前工作目录
	 */
	public String getOSUserDir() {
		return System.getProperty("user.dir");
	}

	/**
	 * 
	 * @return 默认临时文件路径
	 */
	public String getJavaTempDir() {
		return System.getProperty("java.io.tmpdir");
	}

	/**
	 * 
	 * @return 类路径
	 */
	public String getJavaClassPath() {
		return System.getProperty("java.class.path");
	}

	/**
	 * 
	 * @return 虚拟机实现名称
	 */
	public String getJavaVMName() {
		return System.getProperty("java.vm.name");
	}

	/**
	 * 
	 * @return 安装目录
	 */
	public String getJavaHome() {
		return System.getProperty("java.home");
	}

	/**
	 * 
	 * @return 运行环境版本
	 */
	public String getJavaVersion() {
		return System.getProperty("java.version");
	}

	/**
	 * 
	 * @return 运行环境供应商
	 */
	public String getJavaVendor() {
		return System.getProperty("java.vendor");
	}

	/**
	 * 
	 * @return 运行环境供应商url
	 */
	public String getJavaVendorUrl() {
		return System.getProperty("java.vendor.url");
	}

}
