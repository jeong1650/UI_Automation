package osc.v7000;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class OSC_700_GUH_02670 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-01
	 * @ ExpectedResult = 메인 > [게임] 선택 시 게임 추천화면 이동
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */ 

	@Test
	public void OSC_GUH_02670() throws Exception {
		TCID = "OSC700_01_Home_02670  [게임] 선택";
		result = "FAIL";
		size = driver.manage().window().getSize();

		popupCheck();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_game").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/btn_game").isSelected());
		assertTrue(driver.findElementByXPath("//android.widget.Button[@text='추천']").isSelected());
			
		result = "PASS";

	}
}