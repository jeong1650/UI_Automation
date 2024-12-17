package osc.v7000;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class OSC_700_GUH_00330 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-08-31
	 * @ ExpectedResult = 앱 랭킹 > 다른 화면 이동 > Back Key 선택 시 앱 랭킹 화면으로 이동
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_GUH_00330() throws Exception {
		TCID = "OSC700_01_Home_00330 단말 Back key 선택";
		result = "FAIL";
		size = driver.manage().window().getSize();

		popupCheck();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_app_life").click();
		
		Thread.sleep(3000);
		driver.findElementByXPath("//android.widget.Button[@text='랭킹']").click();
		
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/btn_app_life").isSelected());
		assertTrue(driver.findElementByXPath("//android.widget.Button[@text='랭킹']").isSelected());
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search").click();
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search").isSelected());
		
		Thread.sleep(3000);
		driver.navigate().back();
		
		Thread.sleep(3000);
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/btn_app_life").isSelected());
		assertTrue(driver.findElementByXPath("//android.widget.Button[@text='랭킹']").isSelected());
		
		result = "PASS";

	}
}