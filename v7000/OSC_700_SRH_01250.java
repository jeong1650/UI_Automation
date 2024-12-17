package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;

public class OSC_700_SRH_01250 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-18
	 * @ ExpectedResult = 메인 > 검색 > 상품 부가정보 영역 정상 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_SRH_01250() throws Exception {
		TCID = "OSC700_05_검색_01250 부가 정보 영역 (최상위 결과인 경우)";
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
		driver.findElementById("com.skt.skaf.A000Z00040:id/search_result_item_app_img").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/search_result_item_app_title").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/search_result_item_app_seller").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/search_result_item_app_price").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/search_result_item_app_star_container").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/search_result_item_download_button").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/search_result_tag_list_view").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/search_result_detail_container").isDisplayed();
				
		String tagXPath = "//*[@resource-id='com.skt.skaf.A000Z00040:id/search_result_tag_list_view']/*";
		assertTrue(driver.findElementByXPath(tagXPath + "/*[@index='0']/*[@resource-id='com.skt.skaf.A000Z00040:id/search_tag_keyword']").isSelected());
				
		result = "PASS";
	}
}