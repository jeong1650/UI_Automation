package osc.v7000;

import org.junit.Test;

public class OSC_700_SRH_01370 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-18
	 * @ ExpectedResult = 메인 > 검색 > 쇼핑상품 기본정보 영역 정상 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_SRH_01370() throws Exception {
		TCID = "OSC700_05_검색_01370 기본정보 영역 확인 (구성이 fold 형식인 경우)";
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
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("핫후라이드+치즈볼+콜라1.25L");

		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/search_result_item_shop_img").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/search_result_item_shop_title").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/search_result_item_shop_brand").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/search_result_item_shop_price").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/search_result_tag_list_view").isDisplayed();
		
		result = "PASS";
	}
}