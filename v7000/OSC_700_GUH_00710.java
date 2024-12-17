package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;

public class OSC_700_GUH_00710 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-08-31
	 * @ ExpectedResult = 앱 메인화면 > 상단 배너 정상 노출
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_GUH_00710() throws Exception {
		TCID = "OSC700_01_Home_00710 상단 배너 확인";
		result = "FAIL";
		size = driver.manage().window().getSize();

		popupCheck();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_app_life").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/app_tap_layout").click();
				
		Thread.sleep(3000);
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/btn_app_life").isSelected());
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/app_tap_layout").isSelected());
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/backgroundImageView").isDisplayed();
				
		result = "PASS";

	}
}