package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;

public class OSC_700_CAT_02540 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-08
	 * @ ExpectedResult = 구매옵션 2개 제공 쇼핑 상품 상세 > 옵션 선택 완료시 선택 옵션 표기 / 가격정보 노출
	 * @ Editor = 
	 * @ EditDate = 2020-10-20
	 * @ 상품 변경
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_CAT_02540() throws Exception {
		TCID = "OSC700_03_쇼핑_02540 옵션 선택 완료 (두개의 구매옵션을 제공하는 상품)";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();

		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search_layout").click();

		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext");

		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("빨아쓰는 호텔토퍼");
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();

		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/search_result_item_shop_title").click();

		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/shopping_option_purchase").click();
		
		Thread.sleep(3000);
		String option1 = driver.findElementById("com.skt.skaf.A000Z00040:id/shopping_detail_option_item_name").getText();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/shopping_detail_option_item_name").click();
		
		Thread.sleep(3000);
		String option2 = driver.findElementById("com.skt.skaf.A000Z00040:id/shopping_detail_option_item_name").getText();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/shopping_detail_option_item_name").click();
		
		Thread.sleep(3000);
		assertEquals(option1 + " / " + option2, driver.findElementById("com.skt.skaf.A000Z00040:id/shopping_option_selected_item").getText());
		driver.findElementById("com.skt.skaf.A000Z00040:id/shopping_option_price").isDisplayed();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/shopping_option_gift_view").isDisplayed();
		assertEquals("구매", driver.findElementById("com.skt.skaf.A000Z00040:id/shopping_option_purchase").getText());
		
		result = "PASS";

	}
}