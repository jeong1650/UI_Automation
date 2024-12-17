package osc.v7000;

import org.junit.Test;

public class OSC_700_SRH_01149 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-17
	 * @ ExpectedResult = 메인 > 검색 > 19세 앱상품 검색 시 썸네일에 18세 뱃지 노출
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_SRH_01149() throws Exception {
		TCID = "OSC700_01_Home_01149 기본정보 영역 확인 (19세 뱃지)";
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
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("앙톡 앱인");

		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/adultBadgeView").isDisplayed();
						
		result = "PASS";
	}
}