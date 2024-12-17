package osc.v7000;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_SRH_01540 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-21
	 * @ ExpectedResult = 메인 > 검색 > 연관 검색어 선택 시 해당 키워드 검색 화면 이동
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_SRH_01540() throws Exception {
		TCID = "OSC700_05_검색_01540 연관 검색어 tap";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();
				
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search").click();
		
		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext");
		
		try {
			driver.findElementById("com.skt.skaf.A000Z00040:id/search_history_all_delete").click();
		} catch (Exception e) {}
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("카카오톡");
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();
		
		Thread.sleep(3000);
		String relationKeyword = downscroll(By.id("com.skt.skaf.A000Z00040:id/search_relation_keyword_text")).getText();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/search_relation_keyword_text").click();
		
		Thread.sleep(3000);
		assertEquals(relationKeyword, driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").getText());
								
		result = "PASS";
	}
}