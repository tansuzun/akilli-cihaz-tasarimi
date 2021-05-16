package pkt;

import java.util.Scanner;

public class AgArayuzu implements IAgArayuzu{
	int secim;
	private AnaIslemPlatformu anaIslemPlatformu;
	private IVeritabani veritabani;
	private IAgArayuzu agArayuzu;
	
	private static final int SOGUTUCU_AC = 1;
	private static final int SOGUTUCU_KAPAT = 2;
	private static final int SICAKLIK_GORUNTULE = 3;
	private static final int KULLANICI_EKLE = 4;
	private static final int CIKIS = 5;
	
	public AgArayuzu() {
		anaIslemPlatformu=AnaIslemPlatformu.getInstance();
		veritabani=PostgreSQLConnection.getInstance();
	}
	
	public void menu() {
		System.out.println("__________________________");
		System.out.println("1-Sogutucuyu ac.");
		System.out.println("2-Sogutucuyu kapat.");
		System.out.println("3-Sicaklik goruntule.");
		System.out.println("4-Kullanici ekle.");
		System.out.println("5-Cikis");
		System.out.println("__________________________\n");
	}
	
	@Override
	public void secimEkrani() {
		agArayuzu=new AgArayuzu();
		if(veritabani.kullaniciDogrulama()==false) {
			System.out.println("Hatali bilgi girdiniz. Lutfen tekrar deneyin!");
			agArayuzu.secimEkrani();
		}else {
			do{
				menu();
				Scanner scn = new Scanner(System.in); 
			    System.out.println("Lutfen 1 ile 5 arasýnda secim yapiniz:");
			    secim = scn.nextInt(); 
				switch (secim) {
					case SOGUTUCU_AC:
						anaIslemPlatformu.EyleyiciyeGonder(SOGUTUCU_AC);
						break;
					case SOGUTUCU_KAPAT:
						anaIslemPlatformu.EyleyiciyeGonder(SOGUTUCU_KAPAT);
						break;
					case SICAKLIK_GORUNTULE:
						anaIslemPlatformu.SicaklikAlgilayiciyaGonder(SICAKLIK_GORUNTULE);
						break;
					case KULLANICI_EKLE:
						veritabani.kullaniciEkle();
						break;
					case CIKIS:
						System.out.println("Cikis yapiliyor...");
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println("Cikis yapildi.");
						return;
					default:
						System.out.println("1 ile 5 arasýnda bir deger girmelisiniz!\n");
				}
			}while(secim!=5);
		}
			 
	}
	
	public void sicaklikGonder() {
		anaIslemPlatformu.SicaklikAlgilayiciyaGonder(secim);
	}
	
}
