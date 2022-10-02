package com.exo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.exo.calcule.Calcule;
import com.exo.entities.Admin;
import com.exo.entities.Evaluation;
import com.exo.entities.Participant;
import com.exo.entities.Recommandation;
import com.exo.entities.Role;
import com.exo.entities.Sortie;
import com.exo.service.AccountService;
import com.exo.service.EvaluationService;
import com.exo.service.ParticipantService;
import com.exo.service.RecommandationService;
import com.exo.service.SortieService;

@SpringBootApplication
public class ProjetFinaleApplication implements CommandLineRunner {
	@Autowired
	AccountService api;
	@Autowired
	SortieService sortieService;
	@Autowired 
	RecommandationService recommandationService;
	@Autowired
	ParticipantService participantService;
	@Autowired
	EvaluationService evaluationService;
//	@Autowired
//	Calcule calcule = new Calcule();
	
	

	public static void main(String[] args) {
		SpringApplication.run(ProjetFinaleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
//		api.saveAdmin(new Admin("admin1", 1, "1234", "nom1", "adresse1", "tele1", null));
//		api.saveAdmin(new Admin("admin2", 1, "3456", "nom2", "adresse2", "tele2", null));
//		api.saveRole(new Role("guide"));
//		api.saveRole(new Role("organisateur"));
//		api.addRoleToAdmin("admin2", "user");
//		api.addRoleToAdmin("admin1", "admin");
//		sortieService.addsortie(new Sortie("titre1", "destination1", "depart1", "retour1","50", null, "description1"));
//		recommandationService.addrecommandation(new Recommandation("titre1", "texte1", "date1"));
//		participantService.addparticipent(new Participant("nom1", "prenom1", "email1@gamil.com", "tel1", 20, null));
//		evaluationService.addevaluation(new Evaluation("titre1", 3, "remarque1", "nom1"));
		
//		System.out.println("la moyenne des prix des sorties est: "+ calcule.moyenneprix());
//		System.out.println("la moyenne des evaluation est: "+calcule.moyenneevaluation());
//		System.out.println("le nombre des participants est: "+calcule.nombredesparticipant());
	}

}
