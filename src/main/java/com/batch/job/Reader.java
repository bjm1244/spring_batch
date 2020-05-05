package com.batch.job;

import org.springframework.batch.item.xml.StaxEventItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.batch.model.VO;

public class Reader {
	
	@Bean
	public StaxEventItemReader<VO> itemReader() throws ClassNotFoundException {
		StaxEventItemReader<VO> reader = new StaxEventItemReader<VO>();
		reader.setResource(new ClassPathResource("classpath:/xml/report.xml"));
		reader.setFragmentRootElementName("record");
		reader.setUnmarshaller(reportUnmarshaller());
		return reader;
	}
	private Jaxb2Marshaller reportUnmarshaller() throws ClassNotFoundException {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setClassesToBeBound(VO.class);
		return marshaller;
	}

}
