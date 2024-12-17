package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;

public class OSC_700_MYP_00500 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-10
	 * @ ExpectedResult = 마이페이지 > 내 쿠폰 > [편집] 선택 시 편집모드 진입
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MYP_00500() throws Exception {
		TCID = "OSC700_04_MY_00500 [편집] 선택 (보유중인 쿠폰이 있는 경우)";
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
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/appbar_edit_actionlayout").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/action_mode_close_button").isDisplayed();
		assertEquals("완료", driver.findElementById("com.skt.skaf.A000Z00040:id/appbar_complete_actionlayout").getText());
		
		driver.findElementByXPath("//*[@text='보유 쿠폰']").isDisplayed();
		driver.findElementByXPath("//*[@text='지난 쿠폰']").isDisplayed();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/text").isDisplayed();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/my_coupon_item_delete_button").isDisplayed();
						
		result = "PASS";

	}
}