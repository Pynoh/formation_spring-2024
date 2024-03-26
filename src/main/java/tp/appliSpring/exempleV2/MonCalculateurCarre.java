package tp.appliSpring.exempleV2;

import org.springframework.stereotype.Component;


public class MonCalculateurCarre implements MonCalculateur {

	@Override
	public double calculer(double x) {
		return x*x;
	}

}
