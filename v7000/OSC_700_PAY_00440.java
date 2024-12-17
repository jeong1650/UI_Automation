package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;

public class OSC_700_PAY_00440 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-22
	 * @ ExpectedResult = 쇼핑 선물하기 결제화면 > 수신자 및 상품 정보 정상 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_PAY_00440() throws Exception {
		TCID = "OSC600_09_쇼핑_00440 쿠폰 상품 선물하기 선택";
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
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/contact_number").sendKeys("010-1234-5678");
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/text_confirm").click();
				
		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/btn2");
				
		Thread.sleep(3000);
		driver.findElementByXPath("//*[@text='이전화면']").isDisplayed();
		
		driver.findElementByXPath("//*[@text='쇼핑']").isDisplayed();
		driver.findElementByXPath("//*[@text='" + itemTitle + "']").isDisplayed();
		driver.findElementByXPath("//*[@text='e쿠폰']").isDisplayed();
		driver.findElementByXPath("//*[@text='1,400 원']").isDisplayed();
		
		driver.findElementByXPath("//*[@text='받는 사람']").isDisplayed();
		driver.findElementByXPath("//*[@text='홍길동(010-1234-5678)']").isDisplayed();
		
		driver.navigate().back();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.OA00018282:id/btn_Positive").click();
		
		Thread.sleep(3000);
		assertEquals(itemTitle, driver.findElementById("com.skt.skaf.A000Z00040:id/main_info_title").getText());
						
		result = "PASS";
	}
}