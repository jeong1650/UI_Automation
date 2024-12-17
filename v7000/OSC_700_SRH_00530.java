package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_SRH_00530 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-16
	 * @ ExpectedResult = 메인 > 검색 > 히스토리 검색어 미 존재 시 히스토리 검색어 영역 미 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_SRH_00530() throws Exception {
		TCID = "OSC700_05_검색_00530 히스토리 검색어 영역 (히스토리 검색어가 존재하지 않는 경우)";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();
				
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search").click();
		
		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext");
		
		for(int i = 0; i <= 20; i++) {
			try {
				driver.findElementById("com.skt.skaf.A000Z00040:id/search_history_item_delete").click();
			} catch(Exception e) {
				break;
			}
		}
		
		assertTrue(driver.findElements(By.id("com.skt.skaf.A000Z00040:id/search_history_item_keyword")).size() == 0);
			
		result = "PASS";
	}
}