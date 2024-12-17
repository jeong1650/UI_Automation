package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_MKT_00470 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-10-14
	 * @ ExpectedResult = 혜택 수신 미 동의자  > 혜택 > [혜택 알림 받아 보기] 선택 시 팝업 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MKT_00470() throws Exception {
		TCID = "OSC700_08_마케팅_00470 동의하기 링크 선택 (혜택 수신 미동의자인 경우)";
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
		
		try {
			driver.findElementByXPath("//*[@text='혜택 알림 받아보기']").click();
			
			Thread.sleep(3000);
			driver.findElementByXPath("//*[@text='놓치지 말자! 혜택 알림']").isDisplayed();
			driver.findElementByXPath("//*[@text='원스토어가 드리는 캐쉬백, 특가 상품, 맞춤 쿠폰 등 혜택과 새소식을 알려드릴게요.']").isDisplayed();
			driver.findElementByXPath("//*[@text='동의안함']").isDisplayed();
			driver.findElementByXPath("//*[@text='동의']").isDisplayed();
			
			Thread.sleep(3000);
			driver.findElementByXPath("//*[@text='동의안함']").click();
			
			Thread.sleep(3000);
			
			assertTrue(driver.findElements(By.xpath("//*[@text='동의']")).size() == 0);
		} catch (Exception e) {
			driver.findElementByXPath("//*[@content-desc='혜택 알림 받아보기']").click();
			
			Thread.sleep(3000);
			driver.findElementByXPath("//*[@content-desc='놓치지 말자! 혜택 알림']").isDisplayed();
			driver.findElementByXPath("//*[@content-desc='원스토어가 드리는 캐쉬백, 특가 상품, 맞춤 쿠폰 등 혜택과 새소식을 알려드릴게요.']").isDisplayed();
			driver.findElementByXPath("//*[@content-desc='동의안함']").isDisplayed();
			driver.findElementByXPath("//*[@content-desc='동의']").isDisplayed();
			
			Thread.sleep(3000);
			driver.findElementByXPath("//*[@content-desc='동의안함']").click();
			
			Thread.sleep(3000);
			
			assertTrue(driver.findElements(By.xpath("//*[@content-desc='동의']")).size() == 0);
		}
																				
		result = "PASS";

	}
}