package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;

public class OSC_700_SRH_01510 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-21
	 * @ ExpectedResult = 메인 > 검색 > 부가정보 on > 상품 상세 > 상단 back 선택 시 부가정보 on 상태 검색 결과 화면 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_SRH_01500() throws Exception {
		TCID = "OSC700_05_검색_01500 상단 Back 버튼 선택 (부가정보 on 상태인 경우)";
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
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("바람의나라");

		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();
		
		Thread.sleep(3000);
		String tagXPath = "//*[@resource-id='com.skt.skaf.A000Z00040:id/search_result_tag_list_view']/*";
		if(driver.findElementByXPath(tagXPath + "/*[@index='2']/*[@resource-id='com.skt.skaf.A000Z00040:id/search_tag_keyword']").isSelected()) {}
		else {
			driver.findElementByXPath(tagXPath + "/*[@index='2']/*[@resource-id='com.skt.skaf.A000Z00040:id/search_tag_keyword']").click();	
			Thread.sleep(3000);
			assertTrue(driver.findElementByXPath(tagXPath + "/*[@index='2']/*[@resource-id='com.skt.skaf.A000Z00040:id/search_tag_keyword']").isSelected());
		}
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/search_result_detail_container").isDisplayed();
		
		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/search_result_item_app_title");
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_up_indicator").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/search_result_detail_container").isDisplayed();
		assertTrue(driver.findElementByXPath(tagXPath + "/*[@index='2']/*[@resource-id='com.skt.skaf.A000Z00040:id/search_tag_keyword']").isSelected());
						
		result = "PASS";
	}
}