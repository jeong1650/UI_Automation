package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_GUH_02600 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-01
	 * @ ExpectedResult = 앱&라이프 추천 화면 > 개인정보처리방침 선택 시 개인정보처리방침 화면 이동
	 * @ Editor = 
	 * @ EditDate = 2020-10-15
	 * @ 타이틀 상이하게 인식되는 단말 대응
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_GUH_02600() throws Exception {
		TCID = "OSC700_01_Home_02600  최하단 Footer 영역";
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
		assertEquals("개인정보처리방침", upscroll(By.id("com.skt.skaf.A000Z00040:id/footer_information")).getText());
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/footer_information").click();
		
		Thread.sleep(5000);
		try {
			driver.findElementByXPath("//*[@text='이전페이지 개인정보처리방침']").isDisplayed();
		} catch(Exception e) {
			try {
				driver.findElementByXPath("//*[@text='개인정보처리방침']").isDisplayed();
			} catch(Exception ee) {
				driver.findElementByXPath("//*[@content-desc='개인정보처리방침']").isDisplayed();
			}
		}	
		result = "PASS";

	}
}