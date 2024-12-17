package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;

public class OSC_700_CAT_02440 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-08
	 * @ ExpectedResult = 구매옵션 제공 쇼핑 상품 상세 > 선물 / 구매 선택 시 구매 옵션 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_CAT_02440() throws Exception {
		TCID = "OSC700_03_쇼핑_02440 구매 옵션 선택";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();

		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search_layout").click();

		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext");

		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("멀티 디바이스 블루투스 키보드 K380");
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();

		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/search_result_item_shop_title").click();

		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/shopping_option_purchase").click();
		
		Thread.sleep(3000);
		assertEquals("옵션을 선택하세요", driver.findElementById("com.skt.skaf.A000Z00040:id/shopping_detail_option_title").getText());
		driver.findElementById("com.skt.skaf.A000Z00040:id/shopping_detail_option_item_name").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/shopping_detail_option_item_price").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/shopping_option_gift_view").isDisplayed();
		assertEquals("구매", driver.findElementById("com.skt.skaf.A000Z00040:id/shopping_option_purchase").getText());
		
		result = "PASS";

	}
}