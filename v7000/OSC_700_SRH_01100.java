package osc.v7000;

import org.junit.Test;

public class OSC_700_SRH_01100 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-17
	 * @ ExpectedResult = 메인 > 검색 > 검색 결과 화면 > 검색 결과 스크롤시 검색창 영역 고정
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_SRH_01100() throws Exception {
		TCID = "OSC700_05_검색_01100 겸색 결과 스크롤";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();
				
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search").click();
		
		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext");
		
		try {
			driver.findElementById("com.skt.skaf.A000Z00040:id/search_history_all_delete").click();
		} catch (Exception e) {}
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("겨울");

		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_gnb_back").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_delete_icon").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").isDisplayed();
		
		upSwipe(0.90);
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_gnb_back").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_delete_icon").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").isDisplayed();
						
		result = "PASS";
	}
}