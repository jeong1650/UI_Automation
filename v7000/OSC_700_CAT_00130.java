package osc.v7000;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class OSC_700_CAT_00130 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-03
	 * @ ExpectedResult = 무료 상품, 인앱 결제가 있는 게임 / 앱 상품 상세 > 메인정보 영역 정상 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_CAT_00130() throws Exception {
		TCID = "OSC700_03_APP_00130 메인정보 영역 확인 (무료 상품, 인앱 결제가 있는 경우)";
		result = "FAIL";
		size = driver.manage().window().getSize();

		popupCheck();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search_layout").click();
		
		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext");
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("EA SPORTS FC Online M");
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();
		
		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/search_result_item_app_title");
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/main_info_image_view").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/main_info_product_name_text_view").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/main_info_seller_name_text_view").isDisplayed();
		assertEquals("무료", driver.findElementById("com.skt.skaf.A000Z00040:id/main_info_price_text_view").getText());
		assertEquals("인앱구매", driver.findElementById("com.skt.skaf.A000Z00040:id/main_info_iab_text_view").getText());
		
		result = "PASS";

	}
}