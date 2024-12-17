package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_MYP_05850 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-15
	 * @ ExpectedResult = 마이페이지 > 설정 > 자동 업데이트 설정 영역 정상 동작
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MYP_05850() throws Exception {
		TCID = "OSC700_04_설정_05850 설정";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();
				
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my_layout").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my").isSelected());
		
		downscroll(By.id("com.skt.skaf.A000Z00040:id/menu_setting")).click();
		
		Thread.sleep(3000);
		if(driver.findElementById("com.skt.skaf.A000Z00040:id/txt_auto_update").getText().equals("Wi-Fi 에서만")) {
		}
		else {
			Thread.sleep(3000);
			driver.findElementById("com.skt.skaf.A000Z00040:id/txt_auto_update").click();
			driver.findElementByXPath("//*[@text='Wi-Fi 에서만']").click();
		}
		Thread.sleep(3000);
		if(driver.findElementById("com.skt.skaf.A000Z00040:id/txt_auto_update_app").getText().equals("모든 앱")) {
		}
		else {
			Thread.sleep(3000);
			driver.findElementById("com.skt.skaf.A000Z00040:id/txt_auto_update_app").click();
			driver.findElementByXPath("//*[@text='모든 앱']").click();
		}
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/txt_auto_update_app").click();
		
		Thread.sleep(3000);
		driver.findElementByXPath("//android.widget.CheckBox[@text='지정한 앱']").click();
		
		Thread.sleep(3000);
		assertEquals("지정한 앱", driver.findElementById("com.skt.skaf.A000Z00040:id/txt_auto_update_app").getText());	
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/txt_auto_update_app").click();
		
		Thread.sleep(3000);
		driver.findElementByXPath("//android.widget.CheckBox[@text='모든 앱']").click();
		
		Thread.sleep(3000);
		assertEquals("모든 앱", driver.findElementById("com.skt.skaf.A000Z00040:id/txt_auto_update_app").getText());	
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/txt_auto_update").click();
		
		Thread.sleep(3000);
		driver.findElementByXPath("//android.widget.CheckBox[@text='항상 자동 업데이트']").click();
		
		assertEquals("항상 자동 업데이트", driver.findElementById("com.skt.skaf.A000Z00040:id/txt_auto_update").getText());	
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/txt_auto_update").click();
		
		Thread.sleep(3000);
		driver.findElementByXPath("//android.widget.CheckBox[@text='자동 업데이트 안 함']").click();
		
		Thread.sleep(3000);
		assertEquals("자동 업데이트 안 함", driver.findElementById("com.skt.skaf.A000Z00040:id/txt_auto_update").getText());	
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/btn_auto_update_app").getAttribute("enabled").equals("false"));
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/txt_auto_update").click();
		
		Thread.sleep(3000);
		driver.findElementByXPath("//*[@text='Wi-Fi 에서만']").click();
		
		Thread.sleep(3000);
		assertEquals("Wi-Fi 에서만", driver.findElementById("com.skt.skaf.A000Z00040:id/txt_auto_update").getText());	
			
				
		result = "PASS";
	}
}