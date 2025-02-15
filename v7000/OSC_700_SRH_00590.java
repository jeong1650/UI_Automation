package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_SRH_00590 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-17
	 * @ ExpectedResult = 메인 > 검색 > 히스토리 검색어 [전체삭제] 선택 시 영역 제거되어 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_SRH_00590() throws Exception {
		TCID = "OSC700_05_검색_00590 [전체삭제] 선택";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();
				
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search").click();
		
		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext");
		
		try {
			driver.findElementById("com.skt.skaf.A000Z00040:id/search_history_all_delete").isDisplayed();
		} catch (Exception e) {
			Thread.sleep(3000);
			driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("test");
			
			Thread.sleep(3000);
			driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();
			
			Thread.sleep(3000);
			Click("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext");
		}
		
		downscroll(By.id("com.skt.skaf.A000Z00040:id/search_history_all_delete")).click();
		
		assertTrue(driver.findElements(By.id("com.skt.skaf.A000Z00040:id/search_history_recyclerview")).size() == 0);
		
		result = "PASS";
	}
}