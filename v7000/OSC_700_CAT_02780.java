package osc.v7000;

import static org.junit.Assert.*;
import org.junit.Test;

public class OSC_700_CAT_02780 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-10-29
	 * @ ExpectedResult = 쇼핑 상품권 / 교환권 상품 상세 > 하단 플로팅 영역 정상 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_CAT_02780() throws Exception {
		TCID = "OSC700_03_쇼핑_02780 하단 플로팅 영역 확인 (구매 옵션 제공)";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();

		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search_layout").click();

		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext");

		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("아이스 카페 아메리카노 Tall");
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();

		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/search_result_item_shop_title").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/shopping_option_gift_view").isDisplayed();
		assertEquals("구매", driver.findElementById("com.skt.skaf.A000Z00040:id/shopping_option_purchase").getText());
				
		result = "PASS";

	}
}