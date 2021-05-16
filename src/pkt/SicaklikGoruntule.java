package pkt;

public class SicaklikGoruntule implements IIslem{
	
	private ISicaklikAlgilayici sicaklikAlgilayici;
	
	public SicaklikGoruntule() {
		sicaklikAlgilayici=SicaklikAlgilayici.getInstance(new Publisher());
		sicaklikAlgilayici.kisiEkle(new Subscriber1());
		sicaklikAlgilayici.kisiEkle(new Subscriber2());
	}
	
	public void islemYap() {

		System.out.println("Sicaklik: "+sicaklikAlgilayici.sicaklikOku());
		
	}
}

