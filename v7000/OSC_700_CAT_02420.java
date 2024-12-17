package osc.v7000;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class OSC_700_CAT_02420 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-08
	 * @ ExpectedResult = 구매옵션 제공 쇼핑 상품 상세 > 하단 플로팅 영역 정상 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_CAT_02420() throws Exception {
		TCID = "OSC700_03_쇼핑_02420 하단 플로팅 영역 확인 (구매옵션을 제공하는 상품)";
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
		driver.findElementById("com.skt.skaf.A000Z00040:id/shopping_option_gift_view").isDisplayed();
		assertEquals("구매", driver.findElementById("com.skt.skaf.A000Z00040:id/shopping_option_purchase").getText());
		
		result = "PASS";

	}
}