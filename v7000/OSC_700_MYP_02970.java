package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_MYP_02970 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-11
	 * @ ExpectedResult = 마이페이지 > 다운로드 관리 > 다운로드 내역 없음
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MYP_02970() throws Exception {
		TCID = "OSC700_04_MY_02970 다운로드 관리 (다운로드 내역이 없는 경우)";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my_layout").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my").isSelected());
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/menu_download").click();
		
		Thread.sleep(3000);
		try {
			driver.findElementById("com.skt.skaf.A000Z00040:id/appbar_edit_actionlayout").click();
			driver.findElementById("com.skt.skaf.A000Z00040:id/appbar_delete_all_actionlayout").click();
			driver.findElementById("com.skt.skaf.A000Z00040:id/appbar_complete_actionlayout").click();
			
			Thread.sleep(3000);
		} catch(Exception e) {
			
		}
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/empty_image").isDisplayed();		
		assertEquals("다운로드 중인 상품이 없습니다.", driver.findElementById("com.skt.skaf.A000Z00040:id/empty_text").getText());
				
		assertTrue(driver.findElements(By.id("com.skt.skaf.A000Z00040:id/appbar_edit_actionlayout")).size() == 0);
																							
		result = "PASS";

	}
}