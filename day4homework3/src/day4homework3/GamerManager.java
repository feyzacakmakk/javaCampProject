package day4homework3;

public class GamerManager implements GamerService{

	GamerCheckService gamerCheckManager;
	
	public GamerManager(GamerCheckService gamerCheckManager) {
		this.gamerCheckManager=gamerCheckManager;
	}

	
	@Override
	public void register(Gamer gamer) {
		
		if (gamerCheckManager.IfisRealPerson(gamer)) {
			System.out.println(gamer.getFirstName()+" isimli kullanýcý kayýt oldu.");
		}
		else {
			System.out.println("kullanýcý kayýt olamadý, kullanýcý bilgileri yanlýþ.");
		}
		
	}

	@Override
	public void update(Gamer gamer) {
		System.out.println(gamer.getFirstName()+" isimli kullanýcý bilgilerini güncelledi.");
		
	}

	@Override
	public void delete(Gamer gamer) {
		System.out.println(gamer.getFirstName()+" isimli kullanýcý bilgilerini sildi.");
		
	}
	@Override
	public void show(Gamer gamer, Game game) {
		System.out.println("Adý: "+gamer.getFirstName());
		System.out.println("Soyadý: "+gamer.getLastName());
		System.out.println("Doðum yýlý: "+gamer.getYearOfBirth());
		System.out.println("Adlýðý oyun: "+game.getGameName());
		System.out.println("Aldýðý oyun fiyatý: "+game.getPrice());	
	}

}
