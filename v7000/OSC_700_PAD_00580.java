package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;

public class OSC_700_PAD_00580 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-22
	 * @ ExpectedResult = 쇼핑 상세 > [선물하기] > 메시지 입력 팝업 > 메시지 입력 영역 선택 시 기본 제공 메시지 사라짐
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_PAD_00580() throws Exception {
		TCID = "OSC700_06_쇼핑_00580 선물 메시지 입력 영역 선택";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();
				
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search").click();

		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext");
		
		try {
			driver.findElementById("com.skt.skaf.A000Z00040:id/search_history_all_delete").click();
		} catch (Exception e) {}
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("CU 바나나우유");
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/search_result_item_shop_title").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/shopping_option_gift_view").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/shopping_option_gift_view").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/contact_name").sendKeys("홍길동");
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/contact_number").sendKeys("010-1234-5678");
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/text_confirm").click();
				
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/gift_message").click();
		
		Thread.sleep(3000);
		assertEquals("", driver.findElementById("com.skt.skaf.A000Z00040:id/gift_message").getText());
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/gift_message").getAttribute("focused").equals("true"));
		
		result = "PASS";
	}
}