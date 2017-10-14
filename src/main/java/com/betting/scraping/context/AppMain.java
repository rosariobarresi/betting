package com.betting.scraping.context;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.betting.scraping.reader.EurobetReader;
import com.betting.scraping.writer.WriterMongo;

public class AppMain {

	public static void main(String args[]) {
		@SuppressWarnings("resource")
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		EurobetReader eurobetReader = context.getBean("eurobetReader", EurobetReader.class);
		WriterMongo writerMongo = context.getBean("writerMongo", WriterMongo.class);
		Thread t = new Thread(eurobetReader);
		Thread t2 = new Thread(writerMongo);
		t.start();
		t2.start();
	}

}
