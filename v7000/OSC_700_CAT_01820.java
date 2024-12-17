package osc.v7000;

import org.junit.Test;

public class OSC_700_CAT_01820 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-08
	 * @ ExpectedResult = 쇼핑 배송상품 상세 > 대표 이미지 영역 정상 노출
	 * @ Editor = 
	 * @ EditDate = 2020-10-13
	 * @ 상품 변경
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_CAT_01820() throws Exception {
		TCID = "OSC700_03_쇼핑_01820 대표이미지 영역 확인 (대표 이미지 2개 이상)";
		result = "FAIL";
		size = driver.manage().window().getSize();

		popupCheck();

		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search_layout").click();

		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext");

		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("게이밍 헤드셋 GSP500");
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();

		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/search_result_item_shop_title").click();

		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/main_info_product_image_viewpager").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/main_info_product_image_viewpager_indicator").isDisplayed();
				
		result = "PASS";

	}
}