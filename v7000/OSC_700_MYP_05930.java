package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_MYP_05930 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-15
	 * @ ExpectedResult = 마이페이지 > 설정 > 잠금 설정 영역 정상 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MYP_05930() throws Exception {
		TCID = "OSC700_04_설정_05930 잠금 설정 영역 확인 (잠금 비밀번호 등록되지 않은 경우)";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();
				
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my_layout").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my").isSelected());
		
		downscroll(By.id("com.skt.skaf.A000Z00040:id/menu_setting")).click();
		
		Thread.sleep(3000);
		downscroll(By.xpath("//*[@text='잠금 설정']"));
		downscroll(By.xpath("//*[@text='로그인 잠금']"));
		downscroll(By.id("com.skt.skaf.A000Z00040:id/setting_security_login_lock_switch"));
					
		result = "PASS";
	}
}