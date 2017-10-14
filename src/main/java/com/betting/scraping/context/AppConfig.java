package com.betting.scraping.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import com.betting.scraping.CodaElaborazione;
import com.betting.scraping.connection.bean.response.PartiteLega;
import com.betting.scraping.reader.EurobetReader;
import com.betting.scraping.writer.WriterMongo;

@Configuration
@ImportResource("classpath:META-INF/applicationContext.xml")
public class AppConfig {

	@Bean(name = "eurobetReader")
	public EurobetReader eurobetReader() {
		return new EurobetReader();
	}

	@Bean(name = "writerMongo")
	public WriterMongo writerMongo() {
		return new WriterMongo();
	}

	@Bean(name = "codaElaborazione")
	public CodaElaborazione<PartiteLega> codaElaborazione() {
		return new CodaElaborazione<PartiteLega>();
	}

}
