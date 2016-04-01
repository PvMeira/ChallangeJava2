package dataManager;

public class BandWidth {
private String nameFIle;
private int band;
public BandWidth(String nameFIle, int band) {
	super();
	this.nameFIle = nameFIle;
	this.band = band;
}
public String getNameFIle() {
	return nameFIle;
}
public void setNameFIle(String nameFIle) {
	this.nameFIle = nameFIle;
}
public int getBand() {
	return band;
}
public void setBand(int band) {
	this.band = band;
}


}
