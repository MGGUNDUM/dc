package cn.nmb.draw;

import java.util.ArrayList;
import java.util.List;

public class Draw {
	ArrayList<String> cardid;
	int ssr=300;
	int sr=1000;
	Draw(int num){
		cardid = new ArrayList<String>();
		for(;num>0;num--) {
			if(Roll()<=ssr) {
				cardid.add("ssr");
			}else if(Roll()<=sr){
				cardid.add("sr");
			}else {
				cardid.add("r");
			}
		}
	}
	public String getId() {
		String idlist=cardid.toString();
		return idlist;
	}
	public static void main(String[] args) {
		Draw d = new Draw(1);
		System.out.println(d.getId());
	}
	public double Roll() {
		double temp = Math.floor(Math.random()*10000+1);
		return temp;
	}
}
