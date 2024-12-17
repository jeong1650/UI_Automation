package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;

public class OSC_700_GUH_00490 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-08-31
	 * @ ExpectedResult = 앱&라이프 메인 > 상단 배너 영역 정상 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_GUH_00490() throws Exception {
		TCID = "OSC700_01_Home_00490 상단 배너 확인";
		result = "FAIL";
		size = driver.manage().window().getSize();

		popupCheck();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_app_life").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/btn_app_life").isSelected());
				
		driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_image").isDisplayed();
		assertEquals("앱", driver.findElementById("com.skt.skaf.A000Z00040:id/app_tab_text").getText());
		assertEquals("쇼핑", driver.findElementById("com.skt.skaf.A000Z00040:id/shopping_tab_text").getText());
		assertEquals("툰앤북", driver.findElementById("com.skt.skaf.A000Z00040:id/books_tab_text").getText());
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/backgroundImageView").isDisplayed();
				
		result = "PASS";

	}
}