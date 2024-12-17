package osc.v7000;

import org.junit.Test;

public class OSC_700_CAT_00400 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-03
	 * @ ExpectedResult = 게임 / 앱 상품 상세 > 스크린샷 선택 시 전체보기 팝업으로 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_CAT_00400() throws Exception {
		TCID = "OSC700_03_APP_00400 스크린샷 이미지 선택";
		result = "FAIL";
		size = driver.manage().window().getSize();

		popupCheck();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search_layout").click();
		
		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext");
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("아시아나항공");
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();
		
		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/search_result_item_app_title");
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/screenshot_view_container_layout").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/item_screenshot_image_image_view").isDisplayed();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/item_screenshot_image_image_view").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/screenshot_view_pager").isDisplayed();
		
		result = "PASS";

	}
}