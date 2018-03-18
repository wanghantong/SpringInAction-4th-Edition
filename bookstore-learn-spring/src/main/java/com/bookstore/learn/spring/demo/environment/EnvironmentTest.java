package com.bookstore.learn.spring.demo.environment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
// @ActiveProfiles("")
@ContextConfiguration(classes = EnviromentConfig.class)
public class EnvironmentTest {
	@Autowired
	private Environment env;

	@Test
	public void testCheckActiveProfiles() {
		String[] activeProfiles = env.getActiveProfiles();

		System.out.println(activeProfiles.length);
	}

	@Test
	public void testCheckDefaultProfiles() {
		String[] defaultProfiles = env.getDefaultProfiles();
		System.out.println(defaultProfiles.length);
		System.out.println(defaultProfiles[0]);
	}

	@Test
	public void testCheckProperties() {
		String property = env.getProperty("");
		String defaultValue = env.getProperty("", "defaultValue");
		Audi property2 = env.getProperty("", Audi.class);
		Audi property3 = env.getProperty("", Audi.class, new Audi());

	}

	@Test
	public void testReadProperties() throws URISyntaxException {
		boolean acceptsProfiles = env.acceptsProfiles("env");
		String property = env.getProperty("title");
		System.err.println(property);

		try {
			Properties properties = PropertiesLoaderUtils.loadAllProperties("environment/env.properties");
			String property2 = properties.getProperty("title");
			System.err.println(property2);
			Object object = properties.get("title");
			System.err.println(object);
			properties.put("new23", "new23");
			properties.store(new FileOutputStream(new File("")), "");
					//			PropertiesLoaderUtils.fillProperties(properties,
//					new EncodedResource(new ClassPathResource("environment/env.properties"), "UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
