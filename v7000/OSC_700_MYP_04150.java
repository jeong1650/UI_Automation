package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_MYP_04150 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-11
	 * @ ExpectedResult = 마이페이지 > 계정관리 화면 정상 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MYP_04150() throws Exception {
		TCID = "OSC700_04_설정_04150 계정관리";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();
				
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my_layout").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my").isSelected());
		
		downscroll(By.id("com.skt.skaf.A000Z00040:id/menu_manage_account")).click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_up_indicator").isDisplayed();
		assertEquals("계정관리", driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_title").getText());
		
		driver.findElementByXPath("//*[@text='결제']").isDisplayed();
		driver.findElementByXPath("//*[@text='ONE pay 관리']").isDisplayed();
		driver.findElementByXPath("//*[@text='OK캐쉬백 포인트']").isDisplayed();
		
		driver.findElementByXPath("//*[@text='내 계정']").isDisplayed();
		driver.findElementByXPath("//*[@text='이메일 주소 등록 및 변경']").isDisplayed();
		driver.findElementByXPath("//*[@text='성인 인증']").isDisplayed();
		assertEquals("인증", driver.findElementById("com.skt.skaf.A000Z00040:id/account_adult_agree").getText());
		try {
			driver.findElementByXPath("//*[@text='로그아웃']").isDisplayed();
		} catch(Exception e) {}		
		driver.findElementByXPath("//*[@text='이용 해지']").isDisplayed();
		
		result = "PASS";

	}
}