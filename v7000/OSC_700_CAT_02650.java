package osc.v7000;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class OSC_700_CAT_02650 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-09
	 * @ ExpectedResult = 쇼핑 상품권 / 교환권 상품 상세 > 가격 정보 영역 정상 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_CAT_02640() throws Exception {
		TCID = "OSC700_03_쇼핑_02650 가격 정보 영역 확인 (할인율이 0%가 아닌 경우)";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();

		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search_layout").click();

		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext");

		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("슈퍼슈프림(씬)L+ 콜라 1.25L ");
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