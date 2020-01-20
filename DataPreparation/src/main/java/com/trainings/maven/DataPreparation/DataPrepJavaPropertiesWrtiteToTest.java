package com.trainings.maven.DataPreparation;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class DataPrepJavaPropertiesWrtiteToTest {

	public static void main(String[] args) throws IOException {
		OutputStream output = new FileOutputStream("config.properties");
		try  {

			Properties prop = new Properties();

			// set the properties value
			prop.setProperty("db.url", "localhost");
			prop.setProperty("db.user", "mkyong");
			prop.setProperty("db.password", "password");

			// save properties to project root folder
			prop.store(output, null);

			System.out.println(prop);

		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			output.close();
		}

	}

}
