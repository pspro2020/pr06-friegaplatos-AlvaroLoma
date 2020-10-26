package friegaPlatos;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Random;

public class Secador implements Runnable {
	private Bandeja bandeja;

	public Secador(Bandeja bandeja) {

		this.bandeja = bandeja;
	}

	@Override
	public void run() {

		while (true) {
			try {
				nuevoPlatoSeco(secarPlato(cogerPlatoLimpio()));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				return;
			}
		}
	}

	private void nuevoPlatoSeco(Plato platoSecado) throws InterruptedException {
		bandeja.nuevoPlatoSeco(platoSecado);

	}

	private Plato secarPlato(Plato plato) throws InterruptedException {
		Thread.sleep((new Random().nextInt(3) + 1) * 1000);
		LocalTime hora = LocalTime.now();
		DateTimeFormatter formato = DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM);
		System.out.printf("el hilo %s ha secado el plato: %d a las %s \n", this.getClass().getSimpleName(),
				plato.getNumSerie(), formato.format(hora));
		return plato;

	}

	private Plato cogerPlatoLimpio() throws InterruptedException {

		return bandeja.cogerPlatoLimpio();

	}

}
