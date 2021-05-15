package day4homework3;

public class CampaignManager implements CampaignService{
	

	@Override
	public void campaignAdd(Campaign campaign) {
		System.out.println(campaign.getCampaignName()+" isimli kampanya eklendi.");
		
	}

	@Override
	public void campaignDelete(Campaign campaign) {
		System.out.println(campaign.getCampaignName()+" isimli kampanya silindi.");
		
	}

	@Override
	public void campaignUpdate(Campaign campaign) {
		System.out.println(campaign.getCampaignName()+" isimli kampanya güncellendi.");	
	}

	@Override
	public void campaigndiscount(Campaign campaign, Game game) {
		System.out.println( game.getGameName()+" isimli oyunun indirimden sonraki fiyatý "+campaign.getUnitPriceAfterDiscount()+" oldu.");
		
	}

}
