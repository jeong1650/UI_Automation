package osc.v7000;

import org.junit.Test;

public class OSC_700_CAT_01780 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-08
	 * @ ExpectedResult = 쇼핑 배송상품 상세 > 타이틀 영역 정상 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_CAT_01780() throws Exception {
		TCID = "OSC700_03_쇼핑_01780 타이틀 영역 확인";
		result = "FAIL";
		size = driver.manage().window().getSize();

		popupCheck();

		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search_layout").click();

		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext");

		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("완전무선 블루투스 이어폰 E8 3.0*");
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();

		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/search_result_item_shop_title").click();

		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_up_indicator").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/action_detail_search").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/action_detail_option").isDisplayed();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/action_detail_search").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").isDisplayed();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_gnb_back").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_up_indicator").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/search_result_item_shop_title").isDisplayed();
		
		result = "PASS";

	}
}