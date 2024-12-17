package osc.v7000;

import org.junit.Test;

public class OSC_700_SRH_01070 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-17
	 * @ ExpectedResult = 메인 > 검색 > 임의의 검색 필터 선택  > 북스 외 카테고리 존재 시 북스 카테고리 최후순위 노출
	 * @ Editor = 
	 * @ EditDate = 2020-10-28
	 * @ 노출순서 변경
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_SRH_01070() throws Exception {
		TCID = "OSC700_05_검색_01070 북스 카테고리 필터 확인 (북스 + 웹툰 검색결과가 있는 경우, 검색어 대표카테고리가 북스, 웹툰 외 인 경우)";
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
		driver.findElementByXPath("//*[@resource-id='com.skt.skaf.A000Z00040:id/search_result_category_list']/*[@index='0']/*[@text='전체']").isDisplayed();
		driver.findElementByXPath("//*[@resource-id='com.skt.skaf.A000Z00040:id/search_result_category_list']/*[@index='1']/*[@text='앱']").isDisplayed();
		driver.findElementByXPath("//*[@resource-id='com.skt.skaf.A000Z00040:id/search_result_category_list']/*[@index='2']/*[@text='게임']").isDisplayed();
		driver.findElementByXPath("//*[@resource-id='com.skt.skaf.A000Z00040:id/search_result_category_list']/*[@index='3']/*[@text='쇼핑']").isDisplayed();
		driver.findElementByXPath("//*[@resource-id='com.skt.skaf.A000Z00040:id/search_result_category_list']/*[@index='4']/*[@text='북스']").isDisplayed();
						
		result = "PASS";
	}
}