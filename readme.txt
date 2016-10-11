1.项目介绍:bookstore——二手图书交易平台，
2.项目目录结构
bookstore-parent —— 根项目
bookstore-data —— 数据抓取项目,继承自bookstore-parent
3.配置文件介绍
bookstore-parent —— pom.xml 父pom,定义了编码、JDK版本、依赖、依赖的插件(插件和类有重复，待测试)、本地仓库(暂未开启配置)
bookstore-data —— pom.xml 数据项目的依赖配置,继承自parent
4.项目计划
bookstore-data 进行数据抓取和存储,先实现亚马逊数据的抓取,暂不考虑后期业务
5.当前进展
2016.09.10基础环境bookstore-parent、bookstore-data 搭建完成(类路径等还未调试),依赖部分引入,bookstore-data的domain进行了基本定义,WebDriverListener还未实现,
目前调起URL出现问题,页面不跳转(未解决)
——————————————————————————————————————————————————————
6.在bookstore-data下创建了一个source目录<META-INF>,存放spring的applicationContext.xml配置文件,文件源于海峰
7.新建了一个module，bookstore-learn-spring用于学习spring, 参考spring IN Action一书
8.骑士类Knight 运行正常, 入口 KnightMain,实现了构造器注入
9.切入点<诗人类>Minstrel运行正常,入口AOPMinstrelMain,实现了AOP
10.在parent&learn-spring中更新的pom引用,参考的是spring的官方文档的2.2.1&2.2.2章节;http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/
11.在parent包中引入spring-messaging
2016.10.10
——————————————————————————————————————————————————————
12.spring在不同环境下的切换,使用spring3的profile
功能:目前配置了macMysql&winMysql,调用的Quest的实现类不相同,调用方式:传入不同的profile名称
DamselRescuingKnight类没有使用注入,是直接在构造函数中new的实例,所以配置的时候不需要参数，RescueDamselQuest也不需要参数
原理:spring的applicationContext.xml文件中在根节点<beans><beans/>中嵌套<beans>节点,在内部的<beans profile="">中
增加一个profile属性来区别各个<beans>配置,然后在代码中使用GenericXmlApplicationContext类来实现加载,注意先设置激活的profile，
再去调用context的load方法加载applicationContext.xml文件,然后刷新(调用refresh方法).
注意:GenericXmlApplicationContext类也带有参构造,如果在参数中直接写入了applicationContext.xml文件,就默认调用了刷新方法,
而且不能设置激活的profile,这样就会在applicationContext.xml文件中找对应的bean,但是我们的配置文件applicationContext.xml中
已经用<beans>多包了一层了,所以肯定找不到了.就会报错找不到类异常
对应的类和配置文件:EnvMain.java / environment.xml
(未完成)不足:1.使用maven直接参数化打包 2.web应用中如何自动切换 3.maven web工程的自动切换
reference:
http://zilongsky-gmail-com.iteye.com/blog/2032001 ——— Maven 整合 spring profile实现多环境自动切换

13.自动扫描
新建包目录com.bookstore.learn.spring.demo.autoscan
此代码不涉及配置文件,采用一个Config类作为基础配置,默认情况下只扫描该类所在包下的全部类,在测试时配置调用这个类就可以
(未清楚)如何在注解中增加参数进行多包下的扫描




