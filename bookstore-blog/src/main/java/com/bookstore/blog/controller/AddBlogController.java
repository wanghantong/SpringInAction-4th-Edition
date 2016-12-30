package com.bookstore.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bookstore.blog.domain.Article;
import com.bookstore.blog.repository.ArticleRepository;

@Controller
@RequestMapping(value = "/")
public class AddBlogController {

	// 目前暂时使用数据层
	private ArticleRepository articleRepository;

	@Autowired
	public AddBlogController(ArticleRepository articleRepository) {
		this.articleRepository = articleRepository;
	}
	/**
	 * 1.拦截"/publish/blog"的GET请求,跳转到"publish.jsp",同时URL不发生变化
	 * @return
	 */
	@RequestMapping(value = "/publish/blog", method = { RequestMethod.GET })
	public String forwardToAdd() {
		return "publish";
	}

	/**
	 * 1.拦截了post请求 2.防止重复提交,重定向到了详情页 3.采用面向资源式设计
	 * 
	 * @param article
	 * @return
	 */
	@RequestMapping(value = "/publish/blog", method = { RequestMethod.POST })
	public String processBlogForm(Article article) {
		articleRepository.saveArticle(article);
		System.err.println("id ....   " + article.getId());

		return "redirect:/detail/" + article.getId();
	}
	/**
	 * 拦截"/index"请求,跳转到"index.jsp"
	 * @return
	 */
	
	@RequestMapping(value = "/index", method = { RequestMethod.GET })
	public String index() {
		return "index";
	}

}
