package com.bookstore.learn.springmvc.controller;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.servlet.http.Part;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.bookstore.learn.springmvc.domain.BaseUser;

@Controller
@RequestMapping(value = "/")
public class FormController {

	@RequestMapping(value = "/register", method = { RequestMethod.POST })
	public String acceptForm(BaseUser baseUser) {

		System.err.println(baseUser.getIdCard());
		System.err.println(baseUser.getName());
		System.err.println(baseUser.getSalary());
		System.err.println(baseUser.getTax());

		return "success";
	}

	@RequestMapping(value = "/register_formBean", method = { RequestMethod.POST })
	public String acceptFormBean(BaseUser baseUser) {

		System.err.println(baseUser.getIdCard());
		System.err.println(baseUser.getName());
		System.err.println(baseUser.getSalary());
		System.err.println(baseUser.getTax());

		return "success";
	}

	/**
	 * 文件上传<基础版>, @RequestPart("filePicture") byte[]
	 * filePicture,为这个字段增加一个注解,名称与表单相对应
	 * 
	 * 
	 * 注意:这种方式虽然能获得到上传的文件,但是不能获取到更多的信息:比如文件名,类型;参考下个方法
	 * 
	 * @param baseUser
	 * @param filePicture
	 * @param errors
	 * @return
	 */
	@RequestMapping(value = "/registerMutipart", method = { RequestMethod.POST })
	public String acceptMutipartForm(BaseUser baseUser, @RequestPart("filePicture") byte[] filePicture, Errors errors) {

		System.err.println(filePicture.length);
		return "success";
	}

	/**
	 * 文件上传<基础版>, @RequestPart("filePicture") byte[]
	 * filePicture,为这个字段增加一个注解,名称与表单相对应
	 * 
	 * 
	 * 注意:这种方式虽然能获得到上传的文件,但是不能获取到更多的信息:比如文件名,类型;参考下个方法
	 * 
	 * @param baseUser
	 * @param filePicture
	 * @param errors
	 * @return
	 */
	@RequestMapping(value = "/registerMutipart", method = { RequestMethod.GET })
	public String acceptMutipartForm() {
		return "register_mutipart";
	}

	/**
	 * 文件上传<增强版>,Spring为支持文件上传提供了一个MutipartFile接口,能够获取到上传文件的详细信息
	 * 
	 * 此时直接把文件上传的这个字段封装到formbean中,然后处理
	 * 
	 * 问题一:此时只能用formBean处理上传的文件,要注意字段不填的问题
	 * 
	 * 问题二:文件上传问题解决了,但是如果硬件服务器故障,磁盘写满的问题,还会影响到上传功能,如何在集群中同步文件?参考下一个方法<上传到亚马逊云>
	 * 
	 * 
	 * @param baseUser
	 * @param errors
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@RequestMapping(value = "/registerMutipart2", method = { RequestMethod.POST })
	public String acceptMutipartForm(BaseUser baseUser, 
			Errors errors) throws IllegalStateException, IOException {
		if (errors.hasErrors()) {
			return "registerForm";
		}

		System.err.println("getContentType  : " + baseUser.getFilePicture().getContentType());
		System.err.println("getName  : " + baseUser.getFilePicture().getName());
		System.err.println("getOriginalFilename  : " + baseUser.getFilePicture().getOriginalFilename());
		System.err.println("getSize  : " + baseUser.getFilePicture().getSize());
		System.err.println("getFilePicture  : " + baseUser.getFilePicture());
		File targetFile = new File("/here/aaa/");
		baseUser.getFilePicture().transferTo(targetFile);

		return "success";
	}
//	@RequestMapping(value = "/registerMutipart2", method = { RequestMethod.POST })
//	public String acceptMutipartForm(BaseUser baseUser, @RequestPart("filePicture") MultipartFile filePicture,
//			Errors errors) throws IllegalStateException, IOException {
//		if (errors.hasErrors()) {
//			return "registerForm";
//		}
//		
//		System.err.println("getContentType  : " + filePicture.getContentType());
//		System.err.println("getName  : " + filePicture.getName());
//		System.err.println("getOriginalFilename  : " + filePicture.getOriginalFilename());
//		System.err.println("getSize  : " + filePicture.getSize());
//		
//		System.err.println("getFilePicture  : " + baseUser.getFilePicture());
//		filePicture.transferTo(new File("/" + filePicture.getOriginalFilename()));
//		
//		return "success";
//	}

	@RequestMapping(value = "/registerMutipart2", method = { RequestMethod.GET })
	public String acceptMutipartForm2() {
		return "register_mutipart2";
	}

	/**
	 * 上传到云
	 * 
	 * @param baseUser
	 * @param errors
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@RequestMapping(value = "/registerMutipart3", method = { RequestMethod.POST })
	public String acceptMutipartFormToAmazons(BaseUser baseUser, Errors errors)
			throws IllegalStateException, IOException {
		if (errors.hasErrors()) {
			return "registerForm";
		}
		MultipartFile profilePicture = baseUser.getFilePicture();
		profilePicture.transferTo(new File("/tmp/spittr/" + baseUser.getName() + ".jpg"));
		return "success";
	}

	@RequestMapping(value = "/register_map", method = { RequestMethod.GET })
	public String form_map() {
		return "register_map";
	}

	/**
	 * 
	 * @param baseUser
	 * @return
	 */
	@RequestMapping(value = "/register_map", method = { RequestMethod.POST })
	public String acceptForm_map(@RequestParam Map baseUser) {

		System.err.println(baseUser.size());

		System.err.println(baseUser.get("idCard"));
		System.err.println(baseUser.get("name"));
		System.err.println(baseUser.get("salary"));
		System.err.println(baseUser.get("tax"));

		return "success";
	}

	@RequestMapping(value = "/mutipart", method = { RequestMethod.GET })
	public String mutipart() {

		return "success";
	}

	/**
	 * 
	 * @param picture
	 * @return
	 * @throws IOException
	 * @throws IllegalStateException
	 */
	@RequestMapping(value = "/mutipart", method = { RequestMethod.POST })
	public String mutipart(@RequestParam MultipartFile picture) throws IllegalStateException, IOException {

		picture.transferTo(new File("/Users/Dragon"));
		return "success";
	}

	/**
	 * 使用Part处理文件上传,不要在WebConfig.class中进行配置,注释之后测试
	 * 
	 * @param picture
	 * @return
	 */
	@RequestMapping(value = "/mutipartPart", method = { RequestMethod.POST })
	public String mutipart_Part(Part picture) {

		return "success";
	}

}
