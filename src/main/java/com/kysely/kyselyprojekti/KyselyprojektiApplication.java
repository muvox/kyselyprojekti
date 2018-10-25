package com.kysely.kyselyprojekti;

import com.kysely.kyselyprojekti.domain.KyselyRepository;
import com.kysely.kyselyprojekti.model.Kysely;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KyselyprojektiApplication {

	private static Logger log = LoggerFactory.getLogger(KyselyprojektiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(KyselyprojektiApplication.class, args);
	}

	@Bean
	public CommandLineRunner insertTestData(KyselyRepository repo){
		return (args) -> {
			log.info("Inserting a question");

			repo.save(new Kysely("Kysymys"));
			log.info("Fetcing all book info");

		};
	}
}
