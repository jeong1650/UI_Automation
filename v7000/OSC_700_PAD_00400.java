package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;

public class OSC_700_PAD_00400 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-22
	 * @ ExpectedResult = 쇼핑 상세 > [선물하기] 선택 시 수신인 입력 화면 이동
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_PAD_00400() throws Exception {
		TCID = "OSC700_06_쇼핑_00400 [선물하기] 선택(선물 가능 개수가 있는 경우)";
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
		String itemTitle = driver.findElementById("com.skt.skaf.A000Z00040:id/main_info_title").getText();
		driver.findElementById("com.skt.skaf.A000Z00040:id/shopping_option_gift_view").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/shopping_option_gift_view").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_up_indicator").isDisplayed();
		assertEquals("받는 사람 선택", driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_title").getText());
		
		driver.findElementByXPath("//*[@text='받는 사람']").isDisplayed();
		assertEquals("주소록", driver.findElementById("com.skt.skaf.A000Z00040:id/contact_button").getText());
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/listitem_layout").isDisplayed();
		assertEquals("이름", driver.findElementById("com.skt.skaf.A000Z00040:id/contact_name").getText());
		assertEquals("휴대전화번호", driver.findElementById("com.skt.skaf.A000Z00040:id/contact_number").getText());
		driver.findElementById("com.skt.skaf.A000Z00040:id/removeButton").isDisplayed();
		
		assertEquals("추가하기", driver.findElementById("com.skt.skaf.A000Z00040:id/addtext").getText());
		
		assertEquals("총 0명", driver.findElementById("com.skt.skaf.A000Z00040:id/user_count").getText());
		assertEquals("최대 10명", driver.findElementById("com.skt.skaf.A000Z00040:id/user_max_count").getText());
		
		assertEquals("취소", driver.findElementById("com.skt.skaf.A000Z00040:id/text_cancel").getText());
		assertEquals("확인", driver.findElementById("com.skt.skaf.A000Z00040:id/text_confirm").getText());
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_up_indicator").click();
		
		Thread.sleep(3000);
		assertEquals(itemTitle, driver.findElementById("com.skt.skaf.A000Z00040:id/main_info_title").getText());
				
		result = "PASS";
	}
}