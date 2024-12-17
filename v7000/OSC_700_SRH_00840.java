package osc.v7000;

import org.junit.Test;

public class OSC_700_SRH_00840 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-17
	 * @ ExpectedResult = 메인 > 검색 > 임의의 검색 필터 선택  > 카테고리 필터 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_SRH_00840() throws Exception {
		TCID = "OSC700_05_검색_00840 카테고리 필터 확인 (카테고리 필터가 존재하는 경우)";
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
		driver.findElementById("com.skt.skaf.A000Z00040:id/search_result_category_list").isDisplayed();
		
		driver.findElementByXPath("//*[@text='게임']").isDisplayed();
		driver.findElementByXPath("//*[@text='앱']").isDisplayed();
		driver.findElementByXPath("//*[@text='쇼핑']").isDisplayed();
		driver.findElementByXPath("//*[@text='북스']").isDisplayed();		
				
		result = "PASS";
	}
}