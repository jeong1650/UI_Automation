package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_MYP_05010 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-11
	 * @ ExpectedResult = 마이페이지 > 계정관리 > 이용해지 > 남은 캐쉬 / 쿠폰 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MYP_05010() throws Exception {
		TCID = "OSC700_04_설정_05010 현재 고객의 남은 캐쉬 및 쿠폰 노출 영역 확인";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();
				
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my_layout").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my").isSelected());
		
		downscroll(By.id("com.skt.skaf.A000Z00040:id/menu_manage_account")).click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/account_withdrawal").click();
		
		Thread.sleep(3000);
		driver.findElementByXPath("//*[@text='보유 쿠폰']").isDisplayed();
		driver.findElementByXPath("//*[@text='보유 원스토어 캐쉬']").isDisplayed();
		driver.findElementByXPath("//*[@text='보유 게임 캐쉬']").isDisplayed();
		driver.findElementByXPath("//*[@text='보유 북스 캐쉬']").isDisplayed();
		driver.findElementByXPath("//*[@text='보유 북스 포인트']").isDisplayed();
				
		result = "PASS";

	}
}