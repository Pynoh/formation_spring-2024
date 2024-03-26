package tp.appliSpring.exempleV2;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;


public class MonAfficheurV1 implements MonAfficheur {

	@Override
	public void afficher(String message) {
		System.out.println(">v1> "+message);

	}

	@Override
	public void afficherMaj(String message) {
		System.out.println(">>"+message.toUpperCase());
	}

}
