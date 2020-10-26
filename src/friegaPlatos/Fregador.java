package friegaPlatos;


import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Random;

public class Fregador implements Runnable {
	private Bandeja bandeja;
	private int num = 1;

	public Fregador(Bandeja bandeja) {
		this.bandeja = bandeja;
	}

	@Override
	public void run() {

		while (true) {

			try {

				nuevoPlatoLimpio(fregar());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				return;
			}

		}

	}

	private void nuevoPlatoLimpio(Plato plato) throws InterruptedException {
		bandeja.nuevoPlatoLimpio(plato);

	}

	private Plato fregar() throws InterruptedException {
		LocalTime hora = LocalTime.now();
		DateTimeFormatter formato = DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM);
		Thread.sleep((new Random().nextInt(8) + 4) * 1000);
		Plato plato = new Plato(num++);
		System.out.printf("el hilo %s ha limpiado el plato: %d a las %s \n", this.getClass().getSimpleName(),
				plato.getNumSerie(), formato.format(hora));

		return plato;
	}

}
