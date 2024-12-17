package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_MYP_05340 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-11
	 * @ ExpectedResult = 마이페이지 > 고객센터 > FAQ 전체보기 선택 시 페이지 이동
	 * @ Editor = 
	 * @ EditDate = 2020-10-15
	 * @ 타이틀 상이하게 인식되는 단말 대응
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MYP_05340() throws Exception {
		TCID = "OSC700_04_설정_05340 자주 찾는 FAQ [전체 보기] 선택";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();
				
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my_layout").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my").isSelected());
		
		downscroll(By.id("com.skt.skaf.A000Z00040:id/menu_customer_center")).click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/custom_faq_allView").click();
				
		Thread.sleep(3000);		
		try {
			driver.findElementByXPath("//*[@text='이전페이지 FAQ']").isDisplayed();
		} catch (Exception e) {
			driver.findElementByXPath("//*[@text='FAQ']").isDisplayed();
		}
						
		result = "PASS";
	}
}