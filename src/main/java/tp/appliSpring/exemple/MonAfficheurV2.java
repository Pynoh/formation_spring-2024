package tp.appliSpring.exemple;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import tp.appliSpring.annotation.Aff;
import tp.appliSpring.annotation.LogExecutionTime;

@Component
@Profile({"v2"})
@Aff
public class MonAfficheurV2 implements MonAfficheur {

	@Override
	@LogExecutionTime
	public void afficher(String message) {
		System.out.println("*v2* "+message);

	}

	@Override
	public void afficherMaj(String message) {
		System.out.println("**"+message.toUpperCase());
	}

}
