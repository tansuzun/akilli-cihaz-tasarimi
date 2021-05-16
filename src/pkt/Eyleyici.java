package pkt;

public class Eyleyici implements IEyleyici {

	private IIslem islem;
	
	public Eyleyici(IIslem islem)
	{
		this.islem=islem;
	}

	@Override
	public void sogutucuIslemi() {
		islem.islemYap();	
	}

}

