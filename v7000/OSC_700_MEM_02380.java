package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_MEM_02380 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-10-16
	 * @ ExpectedResult = 본인 인증 미 존재 시 > 원페이 관리 > 본인 인증 화면 > Back Key 선택 시 팝업 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MEM_02380() throws Exception {
		TCID = "OSC700_07_회원_02380 Back key 선택(본인인증 존재하지 않는 경우)";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();

		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my_layout").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my").isSelected());
		
		downscroll(By.id("com.skt.skaf.A000Z00040:id/menu_manage_account")).click();
		
		Thread.sleep(3000);
		driver.findElementByXPath("//*[@text='ONE pay 관리']").click();
		
		Thread.sleep(3000);
		driver.navigate().back();
		
		Thread.sleep(3000);
		assertEquals("알림", driver.findElementById("com.skt.skaf.OA00018282:id/tv_dialog_title").getText());
		assertEquals("ONE pay 관리화면에서 나가시겠습니까?", driver.findElementById("com.skt.skaf.OA00018282:id/tv_dialog_msg").getText());
		assertEquals("아니오", driver.findElementById("com.skt.skaf.OA00018282:id/btn_negative").getText());
		assertEquals("예", driver.findElementById("com.skt.skaf.OA00018282:id/btn_Positive").getText());
		
		driver.findElementById("com.skt.skaf.OA00018282:id/btn_negative").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElements(By.id("com.skt.skaf.A000Z00040:id/tv_dialog_title")).size() == 0);

		try {
			driver.findElementByXPath("//*[contains(@text, '본인확인')]").isDisplayed();
		} catch(Exception e) {
			driver.findElementByXPath("//*[contains(@content-desc, '본인확인')]").isDisplayed();
		}	
		
		driver.navigate().back();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.OA00018282:id/btn_Positive").click();
				
		Thread.sleep(3000);
		assertTrue(driver.findElements(By.id("com.skt.skaf.A000Z00040:id/tv_dialog_title")).size() == 0);
		assertEquals("계정관리", driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_title").getText());
																				
		result = "PASS";

	}
}