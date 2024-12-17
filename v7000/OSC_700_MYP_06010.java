package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_MYP_06010 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-15
	 * @ ExpectedResult = 마이페이지 > 설정 > 혜택 알림 수신 동의
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MYP_06010() throws Exception {
		TCID = "OSC700_04_설정_06010 맞춤형 혜택 수신 동의 해체 (맞춤형 혜택 수신 동의 상태)";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();
				
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my_layout").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my").isSelected());
		
		downscroll(By.id("com.skt.skaf.A000Z00040:id/menu_setting")).click();
		
		Thread.sleep(3000);
		if(downscroll(By.id("com.skt.skaf.A000Z00040:id/setting_privacy_personalized_push_agree_switch")).getAttribute("checked").equals("true")) {
		}
		else {
			driver.findElementById("com.skt.skaf.A000Z00040:id/setting_privacy_personalized_push_agree_switch").click();
		}
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/setting_privacy_personalized_push_agree_switch").click();
		
		Thread.sleep(3000);
		assertEquals("맞춤형 혜택 수신 동의를 철회하시면 원스토어에서 제공하는 다양한 맞춤형 혜택을 받아 보실 수 없습니다. 계속하시겠습니까?", 
				driver.findElementById("com.skt.skaf.A000Z00040:id/description").getText());
		assertEquals("아니요", driver.findElementById("com.skt.skaf.A000Z00040:id/btn1").getText());
		assertEquals("예", driver.findElementById("com.skt.skaf.A000Z00040:id/btn2").getText());
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn1").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElements(By.id("com.skt.skaf.A000Z00040:id/btn1")).size() == 0);
		assertTrue(downscroll(By.id("com.skt.skaf.A000Z00040:id/setting_privacy_push_agree_switch")).getAttribute("checked").equals("true"));
		
		
		result = "PASS";
	}
}