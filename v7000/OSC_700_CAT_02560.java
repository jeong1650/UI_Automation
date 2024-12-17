package osc.v7000;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class OSC_700_CAT_02560 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-08
	 * @ ExpectedResult = 구매옵션 1개 고정 쇼핑 상품 상세 > 하단 플로팅 영역 정상 노출
	 * @ Editor = 
	 * @ EditDate = 2020-10-20
	 * @ 상품 변경
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_CAT_02560() throws Exception {
		TCID = "OSC700_03_쇼핑_02560 하단 플로팅 영역 확인 (구매옵션 이 1개로 고정)";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();

		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search_layout").click();

		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext");

		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("SWITCH 테크라인 링 피트 파우치");
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();

		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/search_result_item_shop_title").click();

		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/shopping_option_purchase").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/shopping_option_selected_item").isDisplayed();
		assertEquals("1개", driver.findElementById("com.skt.skaf.A000Z00040:id/shopping_option_count").getText());
		driver.findElementById("com.skt.skaf.A000Z00040:id/shopping_option_price").isDisplayed();
				
		result = "PASS";

	}
}