package com.bookstore.data.tools;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

public class FileOperate {
	/**
	 * 
	 * @param fileSource
	 *            "src/test/java/city1.txt"
	 * @param fileDest
	 *            "src/test/java/city2.txt"
	 */
	public void fileCopy(String fileSource, String fileDest) {
		BufferedReader reader = null;
		BufferedWriter writer = null;

		try {
			reader = new BufferedReader(new FileReader(fileSource));
			writer = new BufferedWriter(new FileWriter(fileDest));
			String line = null;
			while ((line = reader.readLine()) != null) {
				writer.write(line);
				writer.newLine();
				writer.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("read or write error!");
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
					throw new RuntimeException("reader close error!");
				}
			}
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
					throw new RuntimeException("writer close error!");
				}
			}
		}
	}

	/**
	 * 
	 * @param fileSource
	 *            "src/test/java/city.txt"
	 * @throws InterruptedException
	 */
	public void fileRead(String fileSource) throws InterruptedException {
		File file = new File(fileSource);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			while ((tempString = reader.readLine()) != null) {
				// String[] split = StringUtils.split(tempString);
				// String from = split[0];
				// String to = split[1];
				// System.out.println(from + "  " + to);
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("read or write error!");
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
					throw new RuntimeException("reader close error!");
				}
			}
		}
	}

	/**
	 * 
	 * @param fileDest
	 *            "src/test/java/city.txt"
	 */
	public void fileWrite(String fileDest) {

		FileWriter fileWriter = null;
		BufferedWriter writer = null;
		try {
			fileWriter = new FileWriter(new File(fileDest), true);
			writer = new BufferedWriter(fileWriter);
			// writer.write("ben 蛋");
			writer.newLine();
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (writer != null) {
					writer.close();
				}
				if (fileWriter != null) {
					fileWriter.close();
				}
			} catch (IOException e1) {
			}
		}
	}

	/**
	 * 
	 * @param fileSource
	 *            "src/test/java/city.properties"
	 */
	public void fileReadProperties(String fileSource) {
		Properties prop = new Properties();
		try {
			// prop.load(TestQunar.class.getClassLoader().getResourceAsStream("city.properties"));
			prop.load(new FileInputStream(fileSource));
			Set<Entry<Object, Object>> set = prop.entrySet();
			Iterator<Entry<Object, Object>> iterator = set.iterator();
			while (iterator.hasNext()) {
				Entry<Object, Object> next = iterator.next();
				Object key = next.getKey();
				Object value = next.getValue();
				// System.out.println(key+"   ---   "+prop.getProperty((String)
				// key));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
