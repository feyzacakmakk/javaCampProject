package day4homework3;

public class Campaign {
	private String campaignName;
	private int discount;
	private Gamer gamer;
	private Game game;
	
	public Campaign() {
		
	}

	public Campaign(String campaignName, int discount, Gamer gamer, Game game) {
		super();
		this.campaignName = campaignName;
		this.discount = discount;
		this.gamer = gamer;
		this.game = game;
	}

	public String getCampaignName() {
		return campaignName;
	}

	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public Gamer getGamer() {
		return gamer;
	}

	public void setGamer(Gamer gamer) {
		this.gamer = gamer;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public double getUnitPriceAfterDiscount() {
		return game.getPrice()-(game.getPrice()*discount/100);
	}
	

}
