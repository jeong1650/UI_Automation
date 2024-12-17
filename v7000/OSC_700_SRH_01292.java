package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;

public class OSC_700_SRH_01292 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-18
	 * @ ExpectedResult = 메인 > 검색 > 부가정보 영역에 성인 상품 썸네일 선택 시 상품 상세 진입
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_SRH_01292() throws Exception {
		TCID = "OSC700_05_검색_01292 게임/앱 성인 상품 썸네일 선택";
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
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("로한m");

		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();
		
		Thread.sleep(3000);
		String tagXPath_similar = "//*[@resource-id='com.skt.skaf.A000Z00040:id/search_result_tag_list_view']//*[@text='비슷한 게임']";
		
		if(driver.findElementByXPath(tagXPath_similar).isSelected()) {}
		else {
			driver.findElementByXPath(tagXPath_similar).click();
		}
		Thread.sleep(3000);
		assertTrue(driver.findElementByXPath(tagXPath_similar).isSelected());
		
		driver.findElementByXPath("//*[@resource-id='com.skt.skaf.A000Z00040:id/search_result_similar_container']//*[@resource-id='com.skt.skaf.A000Z00040:id/adultBadgeView']").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/main_info_product_name_text_view").isDisplayed();
		
		result = "PASS";
	}
}