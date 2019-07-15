package cn.nmb.draw;

import java.util.ArrayList;
import java.util.List;

public class Draw {
	ArrayList<String> cardid;
	int ssr=300;
	int sr=1000;
	Draw(int num){
		cardid = new ArrayList<String>();
		CardDao dao = new CardDao();
		List<Card> cssr = dao.findAll(3);
		List<Card> csr = dao.findAll(2);
		List<Card> cr = dao.findAll(1);
		for(;num>0;num--) {
			if(Roll(10000)<ssr) {
				String t = cssr.get((int) Roll(cssr.size())).getCname()+":" + cssr.get((int) Roll(cssr.size())).getProfession();
				cardid.add(t);
			}else if(Roll(10000)<sr){
				String t = csr.get((int) Roll(csr.size())).getCname()+":" + csr.get((int) Roll(csr.size())).getProfession();
				cardid.add(t);
			}else {
				String t = cr.get((int) Roll(cr.size())).getCname()+":" + cr.get((int) Roll(cr.size())).getProfession();
				cardid.add(t);
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
	public double Roll(int range) {
		double temp = Math.floor(Math.random()*range);
		return temp;
	}
}
