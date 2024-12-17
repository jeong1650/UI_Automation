package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_MKT_00450 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-10-14
	 * @ ExpectedResult = 혜택 수신 미 동의자  > 혜택 > [혜택 알림 받아 보기] 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MKT_00450() throws Exception {
		TCID = "OSC700_08_마케팅_00450 동의하기 링크 선택 (혜택 수신 미동의자인 경우)";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();

		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my_layout").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my").isSelected());
		
		downscroll(By.id("com.skt.skaf.A000Z00040:id/menu_setting")).click();
		
		if(downscroll(By.id("com.skt.skaf.A000Z00040:id/setting_privacy_push_agree_switch")).getAttribute("checked").equals("true")) {
			driver.findElementById("com.skt.skaf.A000Z00040:id/setting_privacy_push_agree_switch").click();
			
			Thread.sleep(3000);
			Click("com.skt.skaf.A000Z00040:id/btn2");
			
			Thread.sleep(3000);
			Click("com.skt.skaf.A000Z00040:id/btn2");
		}	
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_up_indicator").click();
				
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_benefit").click();
		
		Thread.sleep(3000);
		try {
			driver.findElementByXPath("//*[@text='혜택 알림 받아보기']").isDisplayed();
		} catch (Exception e) {
			driver.findElementByXPath("//*[@content-desc='혜택 알림 받아보기']").isDisplayed();
		}
																						
		result = "PASS";

	}
}