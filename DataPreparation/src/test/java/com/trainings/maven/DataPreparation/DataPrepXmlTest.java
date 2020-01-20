package com.trainings.maven.DataPreparation;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.testng.annotations.Test;

import com.thoughtworks.xstream.XStream;

public class DataPrepXmlTest {

	@Test
	public void assertIPhone() throws IOException {
		XStream xstream = new XStream();
		// create new shop ShopItem and set properties
		ShopItem item = new ShopItem();
		item.setName("IPhone");
		item.setBrand("Apple");
		item.setPrice("$123.20");
		item.setProductCode("product 11");
		// write shopitem to xml file(serialize)
		FileUtils.writeStringToFile(new File("src/test/java/resources/iPhone.xml"), xstream.toXML(item));
		// read from xml file(deserialize)
		ShopItem iPhone = (ShopItem) xstream
				.fromXML(FileUtils.readFileToString(new File("src/test/java/resources/iPhone.xml")));
		// use test data in tests
		Assert.assertEquals("Apple", iPhone.getBrand());
	}

}
