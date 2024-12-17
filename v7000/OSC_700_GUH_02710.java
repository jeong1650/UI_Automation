package osc.v7000;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class OSC_700_GUH_02710 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-01
	 * @ ExpectedResult = 메인 > [마이] 선택 시 마이 화면 이동
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */ 

	@Test
	public void OSC_GUH_02710() throws Exception {
		TCID = "OSC700_01_Home_02710  [마이] 선택";
		result = "FAIL";
		size = driver.manage().window().getSize();

		popupCheck();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my").isSelected());
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/navi_user_id").isDisplayed();
		
		result = "PASS";

	}
}