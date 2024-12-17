package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;

public class OSC_700_MYP_00510 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-10
	 * @ ExpectedResult = 마이페이지 > 내 쿠폰 > 편집모드 > 쿠폰 삭제
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MYP_00510() throws Exception {
		TCID = "OSC700_04_MY_00510 [삭제] 선택";
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
		
		String cpnName = driver.findElementById("com.skt.skaf.A000Z00040:id/titleTextView").getText();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/my_coupon_item_delete_button").click();
		
		Thread.sleep(3000);
		assertNotEquals(cpnName, driver.findElementById("com.skt.skaf.A000Z00040:id/titleTextView").getText());
						
		result = "PASS";

	}
}