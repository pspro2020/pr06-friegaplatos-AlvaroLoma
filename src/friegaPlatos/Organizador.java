package friegaPlatos;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Random;

public class Organizador implements Runnable {
	private Bandeja bandeja;

	public Organizador(Bandeja bandeja) {

		this.bandeja = bandeja;
	}

	@Override
	public void run() {
		while (true) {

			try {
				
				colocarPlato(cogerPlatoSeco());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				return;
			}

		}

	}

	private void colocarPlato(Plato plato) throws InterruptedException {
		Thread.sleep((new Random().nextInt(2) + 1) * 1000);
		LocalTime hora = LocalTime.now();
		DateTimeFormatter formato = DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM);
		System.out.printf("el hilo %s ha colocado el plato: %d en la alacena a las %s \n",
				this.getClass().getSimpleName(), plato.getNumSerie(), formato.format(hora));

	}

	private Plato cogerPlatoSeco() throws InterruptedException {
		return bandeja.cogerPlatoSeco();

	}

}
