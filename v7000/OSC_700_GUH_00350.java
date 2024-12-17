package osc.v7000;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class OSC_700_GUH_00350 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-08-31
	 * @ ExpectedResult = 게임 메인 > 상단 배너 정상 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_GUH_00350() throws Exception {
		TCID = "OSC700_01_Home_00350 상단 배너 확인";
		result = "FAIL";
		size = driver.manage().window().getSize();

		popupCheck();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_game").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/btn_game").isSelected());
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_image").isDisplayed();
		driver.findElementByXPath("//android.widget.Button[@text='추천']").isDisplayed();
		driver.findElementByXPath("//android.widget.Button[@text='랭킹']").isDisplayed();
		driver.findElementByXPath("//android.widget.Button[@text='신규']").isDisplayed();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/backgroundImageView").isDisplayed();
		
		result = "PASS";

	}
}