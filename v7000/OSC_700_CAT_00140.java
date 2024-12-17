package osc.v7000;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class OSC_700_CAT_00140 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-03
	 * @ ExpectedResult = 단품 무료 상품이며, 외부결제를 지원하는 게임 / 앱 상품 상세 > 메인정보 영역 정상 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_CAT_00130() throws Exception {
		TCID = "OSC700_03_APP_00140 메인정보 영역 확인 (단품 무료 상품이며, 외부결제를 지원)";
		result = "FAIL";
		size = driver.manage().window().getSize();

		popupCheck();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search_layout").click();
		
		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext");
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("토닥토닥(영유아 스마트폰 관리앱)");
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();
		
		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/search_result_item_app_title");
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/main_info_image_view").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/main_info_product_name_text_view").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/main_info_seller_name_text_view").isDisplayed();
		assertEquals("무료", driver.findElementById("com.skt.skaf.A000Z00040:id/main_info_price_text_view").getText());
		assertEquals("인앱구매", driver.findElementById("com.skt.skaf.A000Z00040:id/main_info_iab_text_view").getText());
		driver.findElementById("com.skt.skaf.A000Z00040:id/main_info_external_payment_layout").isDisplayed();
		driver.findElementByXPath("//android.widget.TextView[@text='외부결제']").isDisplayed();
		
		result = "PASS";

	}
}