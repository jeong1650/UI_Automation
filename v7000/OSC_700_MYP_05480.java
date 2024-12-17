package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_MYP_05480 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-14
	 * @ ExpectedResult = 마이페이지 > 고객센터 > 이메일 문의 > 모델명 / 번호 자동 입력 되어 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MYP_05480() throws Exception {
		TCID = "OSC700_04_설정_05480 이메일 문의";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();
				
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my_layout").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my").isSelected());
		
		downscroll(By.id("com.skt.skaf.A000Z00040:id/menu_customer_center")).click();
		
		Thread.sleep(3000);
		downscroll(By.id("com.skt.skaf.A000Z00040:id/custom_email")).click();
		
		Thread.sleep(3000);
		driver.findElementByXPath("//*[@text='모델명']").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/cs_phone_type").isDisplayed();
		assertFalse(driver.findElementById("com.skt.skaf.A000Z00040:id/cs_phone_type").getText().isEmpty());
		
		assertEquals("휴대폰 번호", driver.findElementById("com.skt.skaf.A000Z00040:id/cs_phone_number_title").getText());
		driver.findElementById("com.skt.skaf.A000Z00040:id/cs_phone_number").isDisplayed();
		assertFalse(driver.findElementById("com.skt.skaf.A000Z00040:id/cs_phone_type").getText().isEmpty());
																
		result = "PASS";
	}
}