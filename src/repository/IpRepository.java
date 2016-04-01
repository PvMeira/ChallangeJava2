package repository;

import java.util.List;

import dataManager.Ip;

public class IpRepository {
private List<Ip>IpList;

public void add(Ip ip){
	IpList.add(ip);
}

public List<Ip> getIpList() {
	return IpList;
}

public void setIpList(List<Ip> ipList) {
	IpList = ipList;
}


}
