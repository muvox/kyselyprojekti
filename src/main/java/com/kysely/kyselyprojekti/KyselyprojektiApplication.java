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

			String kys1 = "Millä linjalla opiskelet?";
			String kys2 ="Opiskeletko päivätoteutuksessa vai monimuodossa?";
			String kys3 = "Oletko osallistunut kursseille, jotka ovat osittain tai kokonaan virtuaalisia?";
			String kys4 = "Valitsisitko enemmän virtuaalikursseja, kuin lähiopetuskursseja jos mahdollista.";
			String kys5 = "Onko mielestäsi virtuaalisia toteutuksia riittävästi kurssivalikoimassa?";

			List<String> kysymysLista = new ArrayList<>();
			List<String> kysymysLista2 = new ArrayList<>();

			kysymysLista.add(kys1);
			kysymysLista.add(kys2);
			kysymysLista.add(kys3);
			kysymysLista.add(kys4);
			kysymysLista.add(kys5);

			kysymysLista2.add(kys1);
			kysymysLista2.add(kys3);
			kysymysLista2.add(kys5);

			Kysely kysely1 = new Kysely(kysymysLista);
			Kysely kysely2 = new Kysely(kysymysLista2);


			repo.save(kysely1);
			repo.save(kysely2);

			log.info("kysely1 kysymys1");

			log.info("blah" +kysely1.getKysymykset());

		};
	}
}
