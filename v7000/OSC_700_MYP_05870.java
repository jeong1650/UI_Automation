package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_MYP_05870 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-15
	 * @ ExpectedResult = 마이페이지 > 설정 > 동영상 자동 재생 설정 영역 정상 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MYP_05870() throws Exception {
		TCID = "OSC700_04_설정_05870 설정";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();
				
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my_layout").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my").isSelected());
		
		downscroll(By.id("com.skt.skaf.A000Z00040:id/menu_setting")).click();
		
		Thread.sleep(3000);
		if(downscroll(By.id("com.skt.skaf.A000Z00040:id/txt_auto_play")).getText().equals("Wi-Fi 에서만")) {
		}
		else {
			driver.findElementById("com.skt.skaf.A000Z00040:id/btn_auto_play").click();
			Thread.sleep(3000);
			driver.findElementByXPath("//android.widget.CheckBox[@text='Wi-Fi 에서만']").click();
		}
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_auto_play").click();
		
		Thread.sleep(3000);
		driver.findElementByXPath("//android.widget.CheckBox[@text='항상 재생']").click();
		
		Thread.sleep(3000);
		assertEquals("항상 재생", driver.findElementById("com.skt.skaf.A000Z00040:id/txt_auto_play").getText());
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_auto_play").click();
		
		Thread.sleep(3000);
		driver.findElementByXPath("//android.widget.CheckBox[@text='사용 안 함']").click();
		
		Thread.sleep(3000);
		assertEquals("사용 안 함", driver.findElementById("com.skt.skaf.A000Z00040:id/txt_auto_play").getText());
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_auto_play").click();
		
		Thread.sleep(3000);
		driver.findElementByXPath("//android.widget.CheckBox[@text='Wi-Fi 에서만']").click();
		
		Thread.sleep(3000);
		assertEquals("Wi-Fi 에서만", driver.findElementById("com.skt.skaf.A000Z00040:id/txt_auto_play").getText());
						
		result = "PASS";
	}
}