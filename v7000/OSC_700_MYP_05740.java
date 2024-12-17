package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_MYP_05740 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-15
	 * @ ExpectedResult = 마이페이지 > [공지사항] 선택 시 공지사항 리스트 노출
	 * @ Editor = 
	 * @ EditDate = 2020-10-15
	 * @ 타이틀 상이하게 인식되는 단말 대응
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MYP_05740() throws Exception {
		TCID = "OSC700_04_MY_05740 공지사항 선택";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();
				
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my_layout").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my").isSelected());
		
		downscroll(By.id("com.skt.skaf.A000Z00040:id/menu_notice")).click();
		
		Thread.sleep(3000);
		try {
			driver.findElementByXPath("//*[@text='이전페이지 공지사항']").isDisplayed();
		} catch (Exception e) {
			driver.findElementByXPath("//*[@text='공지사항']").isDisplayed();
		}		
		
		driver.findElementByXPath("//*[@text='검색']").isDisplayed();
														
		result = "PASS";
	}
}