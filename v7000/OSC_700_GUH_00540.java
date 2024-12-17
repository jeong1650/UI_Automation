package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;

public class OSC_700_GUH_00540 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-08-31
	 * @ ExpectedResult = 앱&라이프 메인 > [랭킹] 선택 시 랭킹 리스트 화면 노출
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_GUH_00540() throws Exception {
		TCID = "OSC700_01_Home_00540 [랭킹] 선택";
		result = "FAIL";
		size = driver.manage().window().getSize();

		popupCheck();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_app_life").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/app_tap_layout").click();
		
		Thread.sleep(3000);
		driver.findElementByXPath("//*[@text='랭킹']").click();
				
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_up_indicator").isDisplayed();
		assertEquals("앱 랭킹", driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_title").getText());
		driver.findElementById("com.skt.skaf.A000Z00040:id/action_landing_search").isDisplayed();
		
		driver.findElementByXPath("//*[@text='인기']").isDisplayed();
		driver.findElementByXPath("//*[@text='최고매출']").isDisplayed();
		driver.findElementByXPath("//*[@text='급상승']").isDisplayed();
		
		assertEquals("설치된 앱 표시", driver.findElementById("com.skt.skaf.A000Z00040:id/tv_order").getText());
		driver.findElementById("com.skt.skaf.A000Z00040:id/sw_installed").isDisplayed();
				
		driver.findElementById("com.skt.skaf.A000Z00040:id/rankingNumberView").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/iconTitle").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/publisherTextView").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/priceTagView1").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/downloadButton").isDisplayed();
				
		result = "PASS";

	}
}