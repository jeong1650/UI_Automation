package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;

public class OSC_700_CAT_01840 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-08
	 * @ ExpectedResult = 쇼핑 배송상품 상세 > 할인율이 있는 경우 가격 정보 영역 정상 노출
	 * @ Editor = 
	 * @ EditDate = 2020-10-13
	 * @ 상품 변경
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_CAT_01840() throws Exception {
		TCID = "OSC700_03_쇼핑_01840 가격 정보 영역 확인 (할인율이 0%가 아닌 경우)";
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
		driver.findElementById("com.skt.skaf.A000Z00040:id/main_info_discount_rate").isDisplayed();
		assertEquals("%", driver.findElementById("com.skt.skaf.A000Z00040:id/main_info_percent_string").getText());
		driver.findElementById("com.skt.skaf.A000Z00040:id/main_info_sale_price").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/main_info_fixed_price").isDisplayed();
				
		result = "PASS";

	}
}