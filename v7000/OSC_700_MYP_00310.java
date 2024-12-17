package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;

public class OSC_700_MYP_00310 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-10
	 * @ ExpectedResult = 마이페이지 > 내 쿠폰 선택 시 쿠폰 화면 이동
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MYP_00310() throws Exception {
		TCID = "OSC700_04_MY_00310 내 쿠폰 선택 (보유중인 쿠폰이 있는경우)";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();

		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my_layout").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my").isSelected());
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/menu_my_coupon").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_up_indicator").isDisplayed();
		assertEquals("내 쿠폰", driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_title").getText());
		assertEquals("편집", driver.findElementById("com.skt.skaf.A000Z00040:id/appbar_edit_actionlayout").getText());
		driver.findElementByXPath("//*[@text='보유 쿠폰']").isDisplayed();
		driver.findElementByXPath("//*[@text='지난 쿠폰']").isDisplayed();
		
		assertEquals("발급 순", driver.findElementById("com.skt.skaf.A000Z00040:id/text").getText());
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/price_layout").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/titleTextView").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/validityTextView").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/right_layout").isDisplayed();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/titleTextView").click();
		
		Thread.sleep(3000);
		assertEquals("쿠폰보기", driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_title").getText());
		
		result = "PASS";

	}
}