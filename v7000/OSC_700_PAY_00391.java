package osc.v7000;

import org.junit.Test;

public class OSC_700_PAY_00391 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-29
	 * @ ExpectedResult = 쇼핑 상품권 상품 결제 페이지 > 상품 정보 정상 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_PAY_00391() throws Exception {
		TCID = "OSC600_09_쇼핑_00391 쇼핑권 상품 구매하기 선택";
		result = "FAIL";
		size = driver.manage().window().getSize();

		popupCheck();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search_layout").click();
		
		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext");
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("모바일문화상품권_5만원권");
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/search_result_item_shop_title").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/shopping_option_purchase").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/shopping_option_purchase").click();
		
		Thread.sleep(3000);
		driver.findElementByXPath("//*[@text='쇼핑']").click();
		driver.findElementByXPath("//*[@text='모바일문화상품권_5만원권']").click();
		driver.findElementByXPath("//*[@text='e쿠폰']").click();
		driver.findElementByXPath("//*[@text='50,000 원']").click();
		
		result = "PASS";

	}
}