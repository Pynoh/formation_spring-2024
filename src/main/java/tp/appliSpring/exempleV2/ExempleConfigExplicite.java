package tp.appliSpring.exempleV2;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
@PropertySource("classpath:exemples.properties")
//@ComponentScan(basePackages = { "tp.appliSpring.exemple" })
//@EnableAspectJAutoProxy //pour prendre en compte les @Aspect
public class ExempleConfigExplicite {
/* @ComponentScan() pour demander à spring de parcourir les classes de certains
packages pour y trouver des annotations @Component , @Service , @Autowired à
analyser et interpréter */

    @Value("${exemple.calculateur}")
    private String calculateurClassName;

    public MonCalculateur calculateurDouble() {
        MonCalculateurDouble monCalculateurDouble = new MonCalculateurDouble();
        return monCalculateurDouble;
    }

    public MonCalculateur calculateurCarre() {
        MonCalculateurCarre monCalculateurCarre = new MonCalculateurCarre();
        return monCalculateurCarre;
    }

    @Bean
    public MonCalculateur calculateur() {
        MonCalculateur monCalculateur = null;
        if (this.calculateurClassName == null) return null;
//        if (calculateurClassName.equals(MonCalculateurDouble.class.getName())) {
//            System.out.println("double");
//            return this.calculateurDouble();
//        } else  {
//            System.out.println("carre");
//            return this.calculateurCarre();
//        }

        try {
            monCalculateur = (MonCalculateur) Class.forName(this.calculateurClassName).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return monCalculateur;
    }

    @Bean
    @Profile("V1")
    public MonAfficheur afficheurV1() {
        MonAfficheurV1 monAfficheur = new MonAfficheurV1();
        return monAfficheur;
    }

    @Bean
    @Profile("V2")
    public MonAfficheur afficheurV2() {
        MonAfficheurV2 monAfficheur = new MonAfficheurV2();
        return monAfficheur;
    }

    @Bean
    public Coordinateur coordinateur(MonCalculateur calculateur, MonAfficheur afficheur) {
        Coordinateur coordinateur = new Coordinateur();
        coordinateur.setMonCalculateur(calculateur);
        coordinateur.setMonAfficheur(afficheur);
        return coordinateur;
    }


}
