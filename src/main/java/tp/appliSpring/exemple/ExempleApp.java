package tp.appliSpring.exemple;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ExempleApp {
	public static void main(String[] args) {
		
		System.setProperty("spring.profiles.active", "v2");
		ApplicationContext contextSpring = new AnnotationConfigApplicationContext(ExempleConfig.class);
		//contextSpring représente un ensemble de composants pris en charge par spring
		//et qui est initialisé selon une ou plusieurs classes de configuration.
		
		//MonCalculateur monCalculateur = contextSpring.getBean(MonCalculateur.class);
		//System.out.println("resCalcul="+monCalculateur.calculer(4));//4*4=16.0 ou autre

		CoordinateurAvecInjectionParConstructeur coordinateur = contextSpring.getBean(CoordinateurAvecInjectionParConstructeur.class);
		//CoordinateurAvecInjectionParConstructeur coordinateur = (CoordinateurAvecInjectionParConstructeur) contextSpring.getBean("coordinateurAvecInjectionParConstructeur");
		coordinateur.calculerEtAfficher();

		//A completer ...
		
		((AnnotationConfigApplicationContext) contextSpring).close();
	}
}
