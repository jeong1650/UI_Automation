package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_MKT_04760 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-29
	 * @ ExpectedResult = 혜택 > 쿠폰/캐쉬 등록 화면 > 올바르지 않는 쿠폰 번호 입력 시 팝업 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MKT_04760() throws Exception {
		TCID = "OSC700_04_마이페이지_04760 쿠폰 난수 번호 입력 후 [등록] 선택 (올바르지 않는 쿠폰 번호인 경우)";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();
				
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_benefit").click();

		Thread.sleep(3000);
		driver.findElementByXPath("//*[@text='쿠폰/캐쉬 등록']").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/et_cash_reg_number").sendKeys("TTTTTTEST");
		driver.findElementById("com.skt.skaf.A000Z00040:id/bt_reg_done").click();
				
		Thread.sleep(3000);
		assertEquals("올바르지 않은 쿠폰 번호입니다.\n" + 
				"(응답코드04901)", driver.findElementById("com.skt.skaf.A000Z00040:id/description").getText());
		assertEquals("확인", driver.findElementById("com.skt.skaf.A000Z00040:id/btn1").getText());
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn1").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElements(By.id("com.skt.skaf.A000Z00040:id/btn1")).size() == 0);
		assertEquals("TTTTTTEST", driver.findElementById("com.skt.skaf.A000Z00040:id/et_cash_reg_number").getText());
								
		result = "PASS";
	}
}