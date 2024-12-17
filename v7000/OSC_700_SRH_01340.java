package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;

public class OSC_700_SRH_01340 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-18
	 * @ ExpectedResult = 메인 > 검색 > 부가정보 #추천태그 선택 > 상품 영역 선택 시 상세페이지 이동
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_SRH_01340() throws Exception {
		TCID = "OSC700_05_검색_01340 상품영역 tap";
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
		String tagXPath_3 = "//*[@resource-id='com.skt.skaf.A000Z00040:id/search_result_tag_list_view']/*/*[@index='2']/*[@resource-id='com.skt.skaf.A000Z00040:id/search_tag_keyword']";
				
		Thread.sleep(3000);
		driver.findElementByXPath(tagXPath_3).click();
		assertTrue(driver.findElementByXPath(tagXPath_3).isSelected());
		
		Thread.sleep(3000);
		String similarTitle = driver.findElementById("com.skt.skaf.A000Z00040:id/search_result_detail_similar_text").getText();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/search_result_detail_similar_text").click();
				
		Thread.sleep(3000);
		assertEquals(similarTitle, driver.findElementById("com.skt.skaf.A000Z00040:id/main_info_product_name_text_view").getText());	
		
		result = "PASS";
	}
}