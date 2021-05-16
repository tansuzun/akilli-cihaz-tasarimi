package pkt;

public class Subscriber1 implements IObserver{

	@Override
	public void update(String bildirim) {
		System.out.println("Bildirim (Abone 1): "+bildirim);
		
	}

}
