package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;

public class OSC_700_CAT_02810 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-09
	 * @ ExpectedResult = 복수 판매자 쇼핑 상품권 / 교환권 상품 상세 > 선물 / 구매 선택 시 구매 옵션 노출
	 * @ Editor = 
	 * @ EditDate = 2020-10-13
	 * @ 상품 변경
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_CAT_02810() throws Exception {
		TCID = "OSC700_03_쇼핑_02810 판매자 드롭 다운 메뉴 선택";
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
		driver.findElementById("com.skt.skaf.A000Z00040:id/shopping_option_purchase").click();
		
		Thread.sleep(3000);
		assertEquals("판매자를 선택해 주세요", driver.findElementById("com.skt.skaf.A000Z00040:id/shopping_detail_option_title").getText());
		driver.findElementById("com.skt.skaf.A000Z00040:id/shopping_detail_option_item_name").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/shopping_detail_option_item_price").isDisplayed();
				
		result = "PASS";

	}
}