package day4homework3;


public class Main {

	public static void main(String[] args) {
		Gamer gamer=new Gamer("11111111", "feyza", "çakmak", 1999, 1);
		GamerManager gamerManager=new GamerManager(new GamerCheckManager());
		Game game=new Game("Valorant",100);
		gamerManager.register(gamer);
		gamerManager.show(gamer,game);
		
		GameSaleManager gameManager=new GameSaleManager(gamer);
		Game game1=new Game("Resident Evil Village", 270);
		gameManager.buy(game1);
		
		Campaign campaign=new Campaign("yaz kampanyasý", 10, gamer, game1);
		CampaignManager campaignManager=new CampaignManager();
		campaignManager.campaignAdd(campaign);
		campaignManager.campaigndiscount(campaign,game1);
		
		
		
		
		

	}

}
