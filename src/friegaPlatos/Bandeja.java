package friegaPlatos;

import java.util.ArrayList;

public class Bandeja {

	ArrayList<Plato> platosLimpios = new ArrayList<Plato>();
	ArrayList<Plato> platosSecos = new ArrayList<Plato>();

	public synchronized void nuevoPlatoLimpio(Plato plato) throws InterruptedException {
		platosLimpios.add(plato);
		notifyAll();

	}

	public synchronized Plato cogerPlatoLimpio() throws InterruptedException {
		while (platosLimpios.isEmpty()) {

			wait();

		}
		return platosLimpios.remove(0);
	}

	public synchronized void nuevoPlatoSeco(Plato platoSecado) throws InterruptedException {
		platosSecos.add(platoSecado);
		notifyAll();
	}

	public synchronized Plato cogerPlatoSeco() throws InterruptedException {
		while (platosSecos.isEmpty()) {
			wait();
		}
		return platosSecos.remove(0);
	}

}
