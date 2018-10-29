package com.kysely.kyselyprojekti;

import com.kysely.kyselyprojekti.domain.KyselyRepository;
import com.kysely.kyselyprojekti.model.Kysely;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

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


			String kys1 = "Onko tämä kysymys?";


			String kys2 ="Onko tämäkin kysymys?";


			String kys3 = "Onko tämä mukamas kysymys?";


			List<String> kysymysLista = new ArrayList<>();
			List<String> kysymysLista2 = new ArrayList<>();
			kysymysLista.add(kys1);
			kysymysLista.add(kys2);
			kysymysLista.add(kys3);

			kysymysLista2.add(kys1);
			kysymysLista2.add(kys3);

			Kysely kysely1 = new Kysely(kysymysLista);
			Kysely kysely2 = new Kysely(kysymysLista2);


			repo.save(kysely1);
			repo.save(kysely2);

			log.info("kysely1 kysymys1");

			log.info("blah" +kysely1.getKysymykset());

		};
	}
}
