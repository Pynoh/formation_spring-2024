package tp.appliSpring.exempleV2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ExempleAppV2 {
    public static void main(String[] args) {

        System.setProperty("spring.profiles.active", "V2");
        ApplicationContext contextSpring = new AnnotationConfigApplicationContext(ExempleConfigExplicite.class);
        //contextSpring représente un ensemble de composants pris en charge par spring
        //et qui est initialisé selon une ou plusieurs classes de configuration.


        MonCalculateur monCalculateur = contextSpring.getBean(MonCalculateur.class);
        System.out.println("resCalculAppv2 = " + monCalculateur.calculer(4));//4*4=16.0 ou autre
        //A completer ...


        Coordinateur coordinateur = contextSpring.getBean(Coordinateur.class);
        coordinateur.calculerEtAfficher();


        //CoordinateurAvecInjectionParConstructeur coordinateur = contextSpring.getBean(CoordinateurAvecInjectionParConstructeur.class);
        //CoordinateurAvecInjectionParConstructeur coordinateur = (CoordinateurAvecInjectionParConstructeur) contextSpring.getBean("coordinateurAvecInjectionParConstructeur");
        //coordinateur.calculerEtAfficher();


        ((AnnotationConfigApplicationContext) contextSpring).close();
    }
}
