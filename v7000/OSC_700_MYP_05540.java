package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_MYP_05540 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-14
	 * @ ExpectedResult = 마이페이지 > 고객센터 > 이메일 문의 > 발생 채널 영역 입력 가능
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MYP_05540() throws Exception {
		TCID = "OSC700_04_설정_05540 발생채널 영역 확인";
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
		downscroll(By.xpath("//*[@text='발생채널']"));
		assertEquals("예) 휴대기기, 웹 등", driver.findElementById("com.skt.skaf.A000Z00040:id/cs_question_channel").getText());
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/cs_question_channel").sendKeys("test");
		
		assertEquals("test", driver.findElementById("com.skt.skaf.A000Z00040:id/cs_question_channel").getText());
																
		result = "PASS";
	}
}