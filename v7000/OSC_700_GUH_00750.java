package osc.v7000;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class OSC_700_GUH_00750 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-01
	 * @ ExpectedResult = 게임 메인 > [랭킹] 선택 시 랭킹 리스트 화면 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_GUH_00750() throws Exception {
		TCID = "OSC700_01_Home_00750 [랭킹] 선택";
		result = "FAIL";
		size = driver.manage().window().getSize();

		popupCheck();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_game").click();
		
		Thread.sleep(3000);
		driver.findElementByXPath("//android.widget.Button[@text='랭킹']").click();
				
		Thread.sleep(3000);
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/btn_game").isSelected());
		assertTrue(driver.findElementByXPath("//android.widget.Button[@text='랭킹']").isSelected());
		
		driver.findElementByXPath("//android.widget.TextView[@text='인기']").isDisplayed();
		driver.findElementByXPath("//android.widget.TextView[@text='최고매출']").isDisplayed();
		driver.findElementByXPath("//android.widget.TextView[@text='최신출시']").isDisplayed();
		
		assertEquals("설치된 게임 표시", driver.findElementById("com.skt.skaf.A000Z00040:id/tv_order").getText());
		driver.findElementById("com.skt.skaf.A000Z00040:id/sw_installed").isDisplayed();
				
		driver.findElementById("com.skt.skaf.A000Z00040:id/rankingNumberView").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/iconTitle").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/publisherTextView").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/priceTagView1").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/downloadButton").isDisplayed();
				
		result = "PASS";

	}
}