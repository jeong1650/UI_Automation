package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_MYP_06040 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-15
	 * @ ExpectedResult = 마이페이지 > 설정 > 맞춤형 혜택 전문보기 선택 시 맞춤형 혜택 동의 안내 노출
	 * @ Editor = 
	 * @ EditDate = 2020-10-15
	 * @ 타이틀 상이하게 인식되는 단말 대응
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MYP_06040() throws Exception {
		TCID = "OSC700_04_설정_06040 맞춤형 혜택 수신 동의 전문보기 선택";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();
				
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my_layout").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my").isSelected());
		
		downscroll(By.id("com.skt.skaf.A000Z00040:id/menu_setting")).click();
		
		Thread.sleep(3000);
		downscroll(By.xpath("//*[@text='전문보기']")).click();
		
		Thread.sleep(3000);
		try {
			driver.findElementByXPath("//*[@text='이전페이지 맞춤형 혜택 동의 안내']").isDisplayed();
		} catch (Exception e) {
			driver.findElementByXPath("//*[@text='맞춤형 혜택 동의 안내']").isDisplayed();
		}
		
		result = "PASS";
	}
}