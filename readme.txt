1.项目介绍:bookstore——图书数据爬取,从Amazon、jd、dangdang中爬取图书相关数据存入到数据库中,做数据储备
相关技术:
java,
jsoup,webdriver,
spring,hibernate
mysql
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
学习spring 通过spring in action一书

6.在bookstore-data下创建了一个source目录<META-INF>,存放spring的applicationContext.xml配置文件,文件源于海峰
7.新建了一个module，bookstore-learn-spring用于学习spring, 参考spring IN Action一书
8.骑士类Knight 运行正常, 入口 KnightMain,实现了构造器注入
9.切入点<诗人类>Minstrel运行正常,入口AOPMinstrelMain,实现了AOP
10.在parent&learn-spring中更新的pom引用,参考的是spring的官方文档的2.2.1&2.2.2章节;http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/
11.在parent包中引入spring-messaging
注意:此时使用的是xml的方式,xml目录src/main/sources/spring/....
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
补充:自动扫描的核心
a.在实现类上增加注解@Component,将该bean声明为组件,这样就交给spring管理
b.再声明一个配置类,该类只做为启动配置使用,不参与其它工作,在该类上增加注解@Configuration@ComponentScan,第一个注解表示
该类为配置类,第二个注解表示让spring进行扫描,不写参数默认扫描本包下,如果跨包需要加参数:方案A:增加包名的字符串@ComponentScan("")
方案B:@ComponentScan(basePackages="xxx,yyy")方案C:@ComponentScan(BasePackageClasses={A.Class,B.class})
总结:字符串容易写错,用类名又得写很多
c.在测试的时候要在测试类上加上该注解,表示让spring知道并且调用这个配置类@ContextConfiguration(classes = CDPlayerConfig.class)
代码路径:com.bookstore.learn.spring.demo.autoscan
2016.10.11
_______________________________________________________
14.引入了SystemOutRule类,源自system-rule包,方便测试,可以接收控制台输出,减少测试代码的System.out.print
用法:(注意结尾的\n,没有这个会报错)
@Rule
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
	String log = systemOutRule.getLog();——返回的是全部的打印信息
		Assert.assertEquals("SgtPeppers lovely heart...The winner\n", log);
_______________________________________________________		
15.通过Java代码进行装配
思路核心:
a.不再需要将bean声明为组件,即取消@Component注解,然后在配置类中通过@Bean注解进行标识,让spring实例化这个bean
b.在配置类中实例化这个bean时可以采用任意的方法,new ..(),或者加各种逻辑只要返回的是正确的实例就可以
代码路径:com.bookstore.learn.spring.demo.javaConfig(代码已经提交)

16.通过xml进行装配(结合c|p|util三个标签的使用)
a.在哪引入spring标签的命名空间?http://www.springframework.org/schema/一般都在这了,但是没有c,p,可以这个确实好用
xmlns:p="http://www.springframework.org/schema/p"
xmlns:c="http://www.springframework.org/schema/c"
xmlns:util="http://www.springframework.org/schema/util"
附:c标签是用来替代构造函数注入的 
代码路径:com.bookstore.learn.spring.demo.basexml
附:p标签是用来替代属性注入的
属性注入是基于setXXX()方法注入的,所以要将bean中的set方法实现,同时要保证bean有一个无参构造器的实现-原理就是反射嘛
p标签同样不能实现集合类的注入,此时对于集合类可以使用<property name="">来注入
附:使用util标签来注入集合类
引入命名空间
xmlns:util="http://www.springframework.org/schema/util"
...
http://www.springframework.org/schema/util
		http://www.springframework.org/schema/util/spring-util.xsd">
使用util标签声明属性
<util:list id="list">
		<value>wang</value>
		<value>han</value>
		<value>tong</value>
</util:list>
使用p标签引用属性-根据ID引用
<bean id="blankDisc" class="com.bookstore.learn.spring.demo.basexml.BlankDisc"
		p:title="abc" p:artist="dragon" p:list-ref="list" p:set-ref="set">
17.Java代码中混合xml进行装配
使用@ImportResource("classpath:xx/xx.xml")注解来加入XML配置的bean
a.这个注解可以加在原来的JavaConfig类上,也可以再创建一个Config类,引入之前的Config类和这个新增的xml配置,
分别使用注解@Import(xxx.class,yyy.class)@ImportResource("classpath:xx/xx.xml")
b.同时也可以使用@Import注解来进行多个javaConfig直接的引入
代码目录:com.bookstore.learn.spring.demo.javaconfigImportXML
18.测试xml中混合Java代码装配--混合的自动装配
在xml中混合Java代码、自动发现的代码其本质逻辑是在xml中配置一个bean,这个bean就是在自动发现和Java配置时用的config类
至于在Config类上的@ComponentScan和XML中配置的<context:component-scan base-package="">是一样的,但是在XML优先原则时,
Config类上的@ComponentScan配置的包可能小于等于整个项目全部的包,所以这里尽量应该以XML为主,或者Config类上的@ComponentScan只
负责Java配置类这一部分的包的引用,这样可以互不干扰,保持项目清晰整洁
注:在XML配置时,系统优先检查XML,也就是说不可以配置成某个bean的参数引用了另一个bean--但是他是Java配置的或者自动扫描的,这样XML解析就会
出现异常
代码目录:com.bookstore.learn.spring.demo.XMLImportJavaconfig
————————end Chapter 2——————
19.基于注解的profile使用
profile两种使用方式:一、基于注解的 二、基于xml的



20.设置Profile属性的6中方式

21.条件化bean @Conditional-@Condition类的功能和使用-ConditionContext类能干嘛-Environment类能干嘛

22.解决装配的歧义@Qualifier,自定义Qualifier子注解

23.bean的作用域
			^
			|
完成对 第三部分 后端中的spring 学习后,再进行学习

24.运行时注入
用Environment读取properties
代码目录:com.bookstore.learn.spring.demo.autoInject
方法:一、使用@PropertySource注解进行指定properties文件的位置
e.g. @PropertySource("classpath:/setter.properties")
二、创建Environment引用,由spring注入,使用getProperty()方法
e.g. 
@Autowired
Environment env;
env.getProperty("");
三、可以检查属性是否存在,获取不同类型的属性值
env.containsProperty()

使用spring表达式
字面值
bean、属性、方法
使用类类型
运算符
正则

—————————————————chapter 3 end —————————————————————————————————————————————————————————
计算集合
—————————————————chapter 4 start —————————————————————————————————————————————————————————
1.静态代理
2.动态代理-jdk
3.动态代理-cglib
4.aop
前置通知
后置通知
环绕通知
—————————————————chapter 4 end —————————————————————————————————————————————————————————
—————————————————chapter 10 start ——————————————————————————————————————————————————————
学习内容:spring与jdbc,dbcp,c3p0,druid
代码模块:bookstore-learn-spring-chapter10
内容拆分:
1.使用Java配置的方式配置数据库连接池,获取数据源
2.使用xml的方式配置数据库连接池
细节:参考模块内readme
—————————————————chapter 10 end —————————————————————————————————————————————————————————









