package com.bookstore.learn.spring.task.packagescan.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * @author Dragon
 * 
 *         <Date> Jul 26, 2017
 * 
 *         <Specification> : Spring Root Configuration class
 * 
 *         这个类是用来初始化Spring容器的,之所以放在一个单独的包中,是准备采用包扫描的方式来检测配置类的存在
 *         
 *         注意:正常项目中会把Configuration类和业务类分开存储,此处是为了方便演示和学习所以写在了一起
 * 
 *         <status> :
 */

@Configuration
@ComponentScan(basePackages = { "com.bookstore.learn.spring.task.packageConfiguration" })
public class PackageRootConfig {

}
