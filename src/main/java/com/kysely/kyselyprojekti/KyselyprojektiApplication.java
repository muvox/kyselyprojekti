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

			List<String> vaihtoehdot1 = new ArrayList<String>();
            List<String> vaihtoehdot2 = new ArrayList<String>();
            List<String> vaihtoehdot3 = new ArrayList<String>();
            List<String> vaihtoehdot4 = new ArrayList<String>();
            List<String> vaihtoehdot5 = new ArrayList<String>();
            List<String> vaihtoehdot6 = new ArrayList<String>();
            List<String> vaihtoehdot7 = new ArrayList<String>();

            vaihtoehdot1.add("päivätoteutuksessa");
            vaihtoehdot1.add("monimuotototeutuksessa");
            vaihtoehdot1.add("avoimessa amk:ssa");

            vaihtoehdot2.add("kokonaan virtuaalisia");
            vaihtoehdot2.add("osittain virtuaalisia");
            vaihtoehdot2.add("en ole osallistunut");

            vaihtoehdot3.add("tesktivastaus");

            vaihtoehdot4.add("virtuaalikursseja");
            vaihtoehdot4.add("lähiopetuskursseja");
            vaihtoehdot4.add("ei väliä");

            vaihtoehdot5.add("5 (erittäin tyytyväinen)");
            vaihtoehdot5.add("4");
            vaihtoehdot5.add("3");
            vaihtoehdot5.add("2");
            vaihtoehdot5.add("1 (erittäin tyytymätön)");

            vaihtoehdot6.add("tesktivastaus");
            vaihtoehdot7.add("tesktivastaus");
// Ilman vaihtoehtoja
//            Kysymys kys1 = new Kysymys(kysely1,"Missä toteutusmuodossa opsikelet?", "radio");
//            Kysymys kys2 = new Kysymys(kysely1,"Olen osallistunut kursseille, jotka ovat","checkbox" );
//            Kysymys kys3 = new Kysymys(kysely1,"Jos et, minkä takia?","text");
//            Kysymys kys4 = new Kysymys(kysely1,"Jos mahdollista, valitsisin enemmän","radio");
//            Kysymys kys5 = new Kysymys(kysely1,"Jos olet osallistunut virtuaalikurssille, miten arvioisit niiden laatua yleisesti?","radio");
//            Kysymys kys6 = new Kysymys(kysely1, "Millainen on hyvä virtuaalikurssi?","text");
//            Kysymys kys7 = new Kysymys(kysely1, "Vapaa sana.","text");

            //Vaihtoehtojen kanssa
            Kysymys kys1 = new Kysymys(kysely1,"Missä toteutusmuodossa opiskelet?", "radio",vaihtoehdot1);
            Kysymys kys2 = new Kysymys(kysely1,"Olen osallistunut kursseille, jotka ovat","checkbox",vaihtoehdot2 );
            Kysymys kys3 = new Kysymys(kysely1,"Jos et, minkä takia?","text",vaihtoehdot3);
            Kysymys kys4 = new Kysymys(kysely1,"Jos mahdollista, valitsisin enemmän","radio",vaihtoehdot4);
            Kysymys kys5 = new Kysymys(kysely1,"Jos olet osallistunut virtuaalikurssille, miten arvioisit niiden laatua yleisesti?","radio",vaihtoehdot5);
            Kysymys kys6 = new Kysymys(kysely1, "Millainen on hyvä virtuaalikurssi?","text",vaihtoehdot6);
            Kysymys kys7 = new Kysymys(kysely1, "Vapaa sana.","text",vaihtoehdot7);

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
