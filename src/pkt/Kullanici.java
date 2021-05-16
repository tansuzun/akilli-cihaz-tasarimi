package pkt;

public class Kullanici {

		private String kullaniciAdi;
	    private String sifre;
	    private String email;

		private Kullanici(KullaniciBuilder builder) {

	        this.kullaniciAdi = builder.kullaniciAdi;
	        this.sifre = builder.sifre;
	        this.email = builder.email;
	    }

	    public String getKullaniciAdi() {
			return kullaniciAdi;
		}

		public void setKullaniciAdi(String kullaniciAdi) {
			this.kullaniciAdi = kullaniciAdi;
		}

		public String getSifre() {
			return sifre;
		}

		public void setSifre(String sifre) {
			this.sifre = sifre;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

	    @Override
	    public String toString() {
	        return "Kullanici Bilgileri: \nKullanici Adi:"
	        		+kullaniciAdi+"\nSifre:"+" "+sifre+"\nEmail: "+email;
	    }

	    public static class KullaniciBuilder
	    {
			private String kullaniciAdi;
		    private String sifre;
		    private String email;

	        public KullaniciBuilder(String kullaniciAdi,String sifre) {
	        	this.kullaniciAdi = kullaniciAdi;
				this.sifre = sifre;
	        }
	        public KullaniciBuilder email(String email) {
				this.email = email;
	            return this;
	        }
	        public Kullanici build() {
	            return new Kullanici(this);
	        }
	  }
}



