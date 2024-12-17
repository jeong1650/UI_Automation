package osc.v7000;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class OSC_700_GUH_00380 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-08-31
	 * @ ExpectedResult = 게임 메인 화면 > 하단 영역 정상 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_GUH_00380() throws Exception {
		TCID = "OSC700_01_Home_00380 하단 영역 확인";
		result = "FAIL";
		size = driver.manage().window().getSize();

		popupCheck();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_game").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/btn_game").isSelected());
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_game_layout").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_app_life_layout").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_benefit_layout").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search_layout").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my_layout").isDisplayed();
				
		result = "PASS";

	}
}