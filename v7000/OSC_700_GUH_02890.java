package osc.v7000;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class OSC_700_GUH_02890 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-01
	 * @ ExpectedResult = 메인 > [마이] 선택 > [내쿠폰] 선택 > [편집] 선택 시 편집 기능 제공
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */ 

	@Test
	public void OSC_GUH_02890() throws Exception {
		TCID = "OSC700_01_Home_02890  [마이] 선택";
		result = "FAIL";
		size = driver.manage().window().getSize();

		popupCheck();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my").isSelected());
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/menu_my_coupon").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_up_indicator").isDisplayed();
		assertEquals("내 쿠폰", driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_title").getText());
		assertEquals("편집", driver.findElementById("com.skt.skaf.A000Z00040:id/appbar_edit_actionlayout").getText());
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/appbar_edit_actionlayout").click();
		
		Thread.sleep(3000);
		assertEquals("완료", driver.findElementById("com.skt.skaf.A000Z00040:id/appbar_complete_actionlayout").getText());
		
		result = "PASS";

	}
}