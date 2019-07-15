package cn.nmb.draw;

public class Card {
	private String cname;
	private int rarity;
	private String cID;
	private String profession;
	private int level;
	private int rank;
	
	
	public Card(String cname, int rarity, String cID, String profession, int level, int rank) {
		super();
		this.cname = cname;
		this.rarity = rarity;
		this.cID = cID;
		this.profession = profession;
		this.level = level;
		this.rank = rank;
	}
	
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getRarity() {
		return rarity;
	}
	public void setRarity(int rarity) {
		this.rarity = rarity;
	}
	public String getcID() {
		return cID;
	}
	public void setcID(String cID) {
		this.cID = cID;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	
}
