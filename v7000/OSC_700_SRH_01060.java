package osc.v7000;

import org.junit.Test;

public class OSC_700_SRH_01060 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-17
	 * @ ExpectedResult = 메인 > 검색 > 검색 결과 화면 > 대표 카테고리 북스 / 웹툰 일 경우 카테고리 필터 1순위 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_SRH_01060() throws Exception {
		TCID = "OSC700_05_검색_01060 북스 카테고리 필터 확인 (북스 + 웹툰 검색결과가 있는 경우, 검색어 대표카테고리가 북스 or 웹툰인 경우)";
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
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("베르나르 베르베르");

		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();
		
		Thread.sleep(3000);
		driver.findElementByXPath("//*[@resource-id='com.skt.skaf.A000Z00040:id/search_result_category_list']/*[@index='0']/*[@text='전체']").isDisplayed();
		driver.findElementByXPath("//*[@resource-id='com.skt.skaf.A000Z00040:id/search_result_category_list']/*[@index='1']/*[@text='북스']").isDisplayed();
		
				
		result = "PASS";
	}
}