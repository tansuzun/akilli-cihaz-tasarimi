package pkt;
import java.util.Random;

public class SicaklikAlgilayici implements ISicaklikAlgilayici{

	private static SicaklikAlgilayici instance;
	private IIslem islem;
	private int sicaklik;
	private ISubject publisher;
	
	public SicaklikAlgilayici(ISubject publisher) {
		this.publisher = publisher;
	}

	public SicaklikAlgilayici(IIslem islem)
	{
		this.islem=islem;
	}

	public static SicaklikAlgilayici getInstance(ISubject publisher) {
		if(instance==null) {
			instance=new SicaklikAlgilayici(publisher);
		}
		return instance;
	}
	
	public void sicaklikIslemi() {
		islem.islemYap();	
	}

	public void kisiEkle(IObserver kisi) {
		
		publisher.attach(kisi);
	}
    Random random = new Random();

	public int sicaklikOku() {
        sicaklik = random.nextInt(80);
	   // int sicaklik=80;
        if(sicaklik>50)
        {
        	publisher.notify("Sicaklik 50 derecenin üzerinde. Lutfen sogutucuyu aciniz!");
        }
        return sicaklik;    
	}
}


