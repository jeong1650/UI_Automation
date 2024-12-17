package osc.v7000;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_MYP_06000 extends OSC_Base_text {

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
	public void OSC_MYP_06000() throws Exception {
		TCID = "OSC700_04_설정_06000 혜택 알림 수신 동의 (혜택 알림 수신 미동의 상태)";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();
				
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my_layout").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my").isSelected());
		
		downscroll(By.id("com.skt.skaf.A000Z00040:id/menu_setting")).click();
		
		Thread.sleep(3000);
		if(downscroll(By.id("com.skt.skaf.A000Z00040:id/setting_privacy_push_agree_switch")).getAttribute("checked").equals("false")) {
		}
		else {
			driver.findElementById("com.skt.skaf.A000Z00040:id/setting_privacy_push_agree_switch").click();
			Thread.sleep(3000);
			Click("com.skt.skaf.A000Z00040:id/btn2");
			Thread.sleep(3000);
			Click("com.skt.skaf.A000Z00040:id/btn2");
		}
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/setting_privacy_push_agree_switch").click();
		
		Thread.sleep(3000);
		assertEquals("다음과 같이 혜택 알림 수신을\n" + 
				"동의하였습니다.", driver.findElementById("com.skt.skaf.A000Z00040:id/title").getText());
		
		assertEquals("전송자 - 원스토어\n" + 
				"일자 -"+ Calendar.getInstance().get(Calendar.YEAR) + "년 " + 
				String.format("%02d", Calendar.getInstance().get(Calendar.MONTH) + 1) + "월 " + 
				String.format("%02d", Calendar.getInstance().get(Calendar.DAY_OF_MONTH)) + "일", 
				driver.findElementById("com.skt.skaf.A000Z00040:id/description").getText());
		
		assertEquals("확인", driver.findElementById("com.skt.skaf.A000Z00040:id/btn2").getText());
		
		Click("com.skt.skaf.A000Z00040:id/btn2");
		
		Thread.sleep(3000);
		
		assertTrue(driver.findElements(By.id("com.skt.skaf.A000Z00040:id/btn2")).size() == 0);
		assertTrue(downscroll(By.id("com.skt.skaf.A000Z00040:id/setting_privacy_push_agree_switch")).getAttribute("checked").equals("true"));
		
		
		result = "PASS";
	}
}