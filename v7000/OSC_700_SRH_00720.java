package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_SRH_00720 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-17
	 * @ ExpectedResult = 메인 > 검색 > 자동완성 검색어 존재 > 히스토리 검색어가 최대 2개 최신순 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_SRH_00720() throws Exception {
		TCID = "OSC700_05_검색_00720 히스토리 자동완성 영역 (히스토리 자동완성 검색어가 존재하는 경우)";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();
				
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search").click();
		
		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext");
		
		try {
			driver.findElementById("com.skt.skaf.A000Z00040:id/search_history_all_delete").click();
		} catch (Exception e) {}
		
		for(int i = 1; i <= 3; i++) {
			Thread.sleep(3000);
			driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("겨울" + i);
			
			Thread.sleep(3000);
			driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();
		}
		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext");
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").clear();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("겨울");
		
		for(int i = 3; i > 1; i--) {
			driver.findElementByXPath("//*[@text='겨울" + i + "']").isDisplayed();
		}
		assertTrue(driver.findElements(By.xpath("//*[@text='겨울1']")).size() == 0);
		
		assertEquals("겨울3", driver.findElementById("com.skt.skaf.A000Z00040:id/search_autocomplete_item_title").getText());
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/search_autocomplete_item_title").click();
		
		Thread.sleep(3000);
		assertEquals("겨울3", driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").getText());
		
		result = "PASS";
	}
}