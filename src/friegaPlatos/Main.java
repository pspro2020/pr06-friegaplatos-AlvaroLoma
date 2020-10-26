package friegaPlatos;

public class Main {

	public static void main(String[] args) {
		Thread[] hilos = new Thread[3];
		try {
			Bandeja bandeja = new Bandeja();
			hilos[0] = new Thread(new Fregador(bandeja));
			hilos[1] = new Thread(new Secador(bandeja));
			hilos[2] = new Thread(new Organizador(bandeja));
			for (int i = 0; i < hilos.length; i++) {
				hilos[i].start();
			}
			Thread.sleep(60000);
			for (int i = 0; i < hilos.length; i++) {
				hilos[i].interrupt();
			}

	
			System.out.println("Cumpleaños feliz");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
