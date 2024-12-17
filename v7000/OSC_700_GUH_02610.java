package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_GUH_02610 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-01
	 * @ ExpectedResult = 앱&라이프 추천 화면 > 고객센터 선택 시 고객센터 화면 이동
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */ 

	@Test
	public void OSC_GUH_02610() throws Exception {
		TCID = "OSC700_01_Home_02610  최하단 Footer 영역";
		result = "FAIL";
		size = driver.manage().window().getSize();

		popupCheck();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_app_life").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/app_tap_layout").click();
				
		Thread.sleep(3000);
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/btn_app_life").isSelected());
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/app_tap_layout").isSelected());
		
		for(int i = 0; i < 10; i++) {
			upSwipe(0.80);
		}
		
		Thread.sleep(3000);
		assertEquals("고객센터", upscroll(By.id("com.skt.skaf.A000Z00040:id/footer_cs")).getText());
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/footer_cs").click();
		
		Thread.sleep(3000);
		assertEquals("고객센터", driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_title").getText());
				
		result = "PASS";

	}
}