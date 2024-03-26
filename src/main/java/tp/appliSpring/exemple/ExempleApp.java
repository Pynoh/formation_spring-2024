package tp.appliSpring.exemple;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ExempleApp {
	public static void main(String[] args) {
		
		System.setProperty("spring.profiles.active", "v2,perf");
		ApplicationContext contextSpring = new AnnotationConfigApplicationContext(ExempleConfig.class);
		//contextSpring représente un ensemble de composants pris en charge par spring
		//et qui est initialisé selon une ou plusieurs classes de configuration.
		
		//MonCalculateur monCalculateur = contextSpring.getBean(MonCalculateur.class); // Ne fonctionne pas sans distinguer l'ambiguité entre les deux Calculateurs
		//MonCalculateur monCalculateur = contextSpring.getBean(MonCalculateur.class); //Ne fonctionne pas si les Aspect sont activés (classe de proxy à la place des classes normales s'il y a interface)
		//MonCalculateur monCalculateur = (MonCalculateur) contextSpring.getBean("monCalculateurCarre"); // Fonctionne avec les aspects, le nom logique est conservé
		//System.out.println("resCalcul="+monCalculateur.calculer(4));//4*4=16.0 ou autre

		CoordinateurAvecInjectionParConstructeur coordinateur = contextSpring.getBean(CoordinateurAvecInjectionParConstructeur.class); // Fonctionne avec les aspects, car la classe n'implémente pas d'interface
		//CoordinateurAvecInjectionParConstructeur coordinateur = (CoordinateurAvecInjectionParConstructeur) contextSpring.getBean("coordinateurAvecInjectionParConstructeur");
		coordinateur.calculerEtAfficher();

		//A completer ...
		
		((AnnotationConfigApplicationContext) contextSpring).close();
	}
}
