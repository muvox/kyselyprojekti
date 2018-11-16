package com.kysely.kyselyprojekti;

import com.kysely.kyselyprojekti.repository.KyselyRepository;
import com.kysely.kyselyprojekti.repository.KysymysRepository;
import com.kysely.kyselyprojekti.model.Kysely;
import com.kysely.kyselyprojekti.model.Kysymys;
import com.kysely.kyselyprojekti.service.KyselyService;
import com.kysely.kyselyprojekti.service.KysymysService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
	public CommandLineRunner insertTestData(KyselyRepository kyselyRepo, KysymysRepository kysymysRepo){
		return (args) -> {
			log.info("Inserting a question");

			List<Kysymys> kysymysLista = new ArrayList<>();
			List<Kysymys> kysymysLista2 = new ArrayList<>();

			Kysely kysely1 = new Kysely("Kysely 1");
			Kysely kysely2 = new Kysely("Kysely 2");


			kyselyRepo.save(kysely1);
			kyselyRepo.save(kysely2);


            Kysymys kys1 = new Kysymys(kysely1,"Missä toteutusmuodossa opsikelet?", "radio");
            Kysymys kys2 = new Kysymys(kysely1,"Olen osallistunut kursseille, jotka ovat","checkbox" );
            Kysymys kys3 = new Kysymys(kysely1,"Jos et, minkä takia?","text");
            Kysymys kys4 = new Kysymys(kysely1,"Jos mahdollista, valitsisin enemmän","radio");
            Kysymys kys5 = new Kysymys(kysely1,"Jos olet osallistunut virtuaalikurssille, miten arvioisit niiden laatua yleisesti?","radio");
            Kysymys kys6 = new Kysymys(kysely1, "Millainen on hyvä virtuaalikurssi?","text");
            Kysymys kys7 = new Kysymys(kysely1, "Vapaa sana.","text");

            kysymysLista.add(kys1);
            kysymysLista.add(kys2);
            kysymysLista.add(kys3);
            kysymysLista.add(kys4);
            kysymysLista.add(kys5);
            kysymysLista.add(kys6);
            kysymysLista.add(kys7);

            for(Kysymys k : kysymysLista) {
                kysymysRepo.save(k);
            }

		};
	}
}
