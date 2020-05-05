package com.batch.api;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

public class Api {
	public static void main(String[] args) {
		try {
			File fXmlFile = new File("src/main/resources/xml/report.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			System.out.println(doc.getTextContent());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
