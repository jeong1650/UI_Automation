package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;

public class OSC_700_SRH_01470 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-18
	 * @ ExpectedResult = 메인 > 검색 > 쇼핑상품 부가정보 #태그 선택 시 상품목록 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_SRH_01470() throws Exception {
		TCID = "OSC700_05_검색_01470 비슷한 상품, #추천태그 tap";
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
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("뚜레쥬르");

		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();
		
		Thread.sleep(3000);
		String tagXPath = "//*[@resource-id='com.skt.skaf.A000Z00040:id/search_result_tag_list_view']/*";
		driver.findElementByXPath(tagXPath + "/*[@index='1']/*[@resource-id='com.skt.skaf.A000Z00040:id/search_tag_keyword']").click();
		assertTrue(driver.findElementByXPath(tagXPath + "/*[@index='1']/*[@resource-id='com.skt.skaf.A000Z00040:id/search_tag_keyword']").isSelected());		
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/search_result_detail_shop_similar_icon").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/search_result_detail_shop_similar_product_name").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/search_result_detail_shop_similar_price").isDisplayed();
				
		result = "PASS";
	}
}