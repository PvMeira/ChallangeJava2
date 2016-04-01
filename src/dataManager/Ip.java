package dataManager;

public class Ip {

	private String IpEndress;
	

	public Ip(String ipEndress) {
		IpEndress = ipEndress;
	
	}

	public String getIpEndress() {
		return IpEndress;
	}

	public void setIpEndress(String ipEndress) {
		IpEndress = ipEndress;
	}

	@Override
	public String toString() {
		return "Ip NAO DEU MERDA" + IpEndress + "]";
	}



}
