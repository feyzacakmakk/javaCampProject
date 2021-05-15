package day4homework3;

public class GameSaleManager implements GameSaleService{

	Gamer gamer;
	public GameSaleManager(Gamer gamer) {
		this.gamer=gamer;
	}
	
	@Override
	public void buy(Game game) {
		System.out.println(gamer.getFirstName()+" isimli kullanýcý "+game.getGameName()+" isimli oyunu satýn aldý.");
		
	}

	@Override
	public void delete(Game game) {
		System.out.println(gamer.getFirstName()+" isimli kullanýcý "+game.getGameName()+" isimli oyunu iade etti.");
		
	}

	

}
