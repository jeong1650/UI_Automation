package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;

public class OSC_700_PAD_00600 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-22
	 * @ ExpectedResult = 쇼핑 상세 > [선물하기] > 선물메시지 팝업 [확인] 선택 시 결제 화면 이동
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_PAD_00600() throws Exception {
		TCID = "OSC700_06_쇼핑_00600 선물 메시지 팝업 [확인] 선택(선물 메시지 입력 또는 미입력 상태인 경우)";
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
		driver.findElementById("com.skt.skaf.A000Z00040:id/contact_name").sendKeys("홍길동");
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/contact_number").sendKeys("010-9999-9999");
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/text_confirm").click();
				
		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/btn2");
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn1").click();
		
		Thread.sleep(3000);
		driver.findElementByXPath("//*[@text='쇼핑']").isDisplayed();
		driver.findElementByXPath("//*[@text='" + itemTitle + "']").isDisplayed();
		driver.findElementByXPath("//*[@text='e쿠폰']").isDisplayed();
		
		driver.navigate().back();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.OA00018282:id/btn_Positive").click();
		
		Thread.sleep(3000);
		assertEquals(itemTitle, driver.findElementById("com.skt.skaf.A000Z00040:id/main_info_title").getText());
						
		result = "PASS";
	}
}