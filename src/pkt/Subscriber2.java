package pkt;

public class Subscriber2 implements IObserver{

	@Override
	public void update(String bildirim) {
		System.out.println("Bildirim (Abone 2): "+bildirim);
		
	}

}
