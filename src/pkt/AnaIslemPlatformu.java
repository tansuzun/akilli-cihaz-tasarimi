package pkt;

public class AnaIslemPlatformu {
	private IEyleyici sogutucuAc;
	private IEyleyici sogutucuKapat;
	private ISicaklikAlgilayici sicaklikGoruntule;
	private static AnaIslemPlatformu instance;
	
	public AnaIslemPlatformu() {
		sogutucuAc=new Eyleyici(new SogutucuAcma());
		sogutucuKapat=new Eyleyici(new SogutucuKapatma());
		sicaklikGoruntule=new SicaklikAlgilayici(new SicaklikGoruntule());
	}
	public static AnaIslemPlatformu getInstance() {
		if(instance==null) {
			instance=new AnaIslemPlatformu();
		}
		return instance;
	}
	
	public void EyleyiciyeGonder(int secim) {
		if(secim==1) {
			sogutucuAc.sogutucuIslemi();
			
		}else if(secim==2) {
			sogutucuKapat.sogutucuIslemi();
		}
	}
	
	public void SicaklikAlgilayiciyaGonder(int secim)
	{
		if(secim==3)
		{
			sicaklikGoruntule.sicaklikIslemi();
		}
	}
}

