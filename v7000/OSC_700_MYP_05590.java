package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_MYP_05590 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-14
	 * @ ExpectedResult = 마이페이지 > 고객센터 > 이메일 문의 > 개인정보 수집 여부 체크 가능
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MYP_05590() throws Exception {
		TCID = "OSC700_04_설정_05590 개인정보 수집 체크 박스 체크";
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
		downscroll(By.id("com.skt.skaf.A000Z00040:id/checkbox"));
		driver.findElementByXPath("//*[@text='개인정보 수집에 동의합니다.']").isDisplayed();
		
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/checkbox").getAttribute("checked").equals("false"));
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/checkbox").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/checkbox").getAttribute("checked").equals("true"));
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/checkbox").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/checkbox").getAttribute("checked").equals("false"));													
		
		result = "PASS";
	}
}