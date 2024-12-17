package osc.v7000;

import org.junit.Test;

public class OSC_700_SRH_01180 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-17
	 * @ ExpectedResult = 메인 > 검색 > 외부결제 영역 정상 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_SRH_01180() throws Exception {
		TCID = "OSC700_05_검색_01180 외부 결제 영역 (외부결제 지원하는 상품인 경우)";
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
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("웨이브");

		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/search_result_item_app_star_icon").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/search_result_item_app_star").isDisplayed();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/search_result_item_tag_external_pay").isDisplayed();
		driver.findElementByXPath("//*[@text='외부결제']").isDisplayed();
		
		result = "PASS";
	}
}