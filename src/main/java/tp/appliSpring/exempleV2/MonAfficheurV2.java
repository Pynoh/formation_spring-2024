package tp.appliSpring.exempleV2;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;


public class MonAfficheurV2 implements MonAfficheur {

	@Override
	public void afficher(String message) {
		System.out.println("*v2* "+message);

	}

	@Override
	public void afficherMaj(String message) {
		System.out.println("**"+message.toUpperCase());
	}

}
