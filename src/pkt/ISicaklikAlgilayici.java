package pkt;

public interface ISicaklikAlgilayici {
	int sicaklikOku();
	void sicaklikIslemi();
	void kisiEkle(IObserver kisi);
}

