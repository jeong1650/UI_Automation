package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_MYP_05790 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-15
	 * @ ExpectedResult = 마이페이지 > 이용안내 > 버전 정보 정상 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MYP_05790() throws Exception {
		TCID = "OSC700_04_설정_05790 버전 정보 선택";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();
				
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my_layout").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my").isSelected());
		
		downscroll(By.id("com.skt.skaf.A000Z00040:id/menu_use_guide")).click();
		
		Thread.sleep(3000);
		driver.findElementByXPath("//*[@text='버전 정보']").click();
		
		Thread.sleep(3000);
		driver.findElementByXPath("//*[@text='모델명']").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/model_name_textview").isDisplayed();
		
		driver.findElementByXPath("//*[@text='안드로이드 버전']").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/android_version_textview").isDisplayed();
		
		driver.findElementByXPath("//*[@text='원스토어 버전']").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/version_info_textview").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/build_date_textview").isDisplayed();		
		
		driver.findElementByXPath("//*[@text='원스토어 서비스 버전']").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/tstore_arm_version_textview").isDisplayed();
		
		result = "PASS";
	}
}