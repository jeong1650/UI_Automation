package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;

public class OSC_700_SRH_00770 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-17
	 * @ ExpectedResult = 메인 > 검색 > 자동완성 검색어 100byte 까지 저장
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_SRH_00770() throws Exception {
		TCID = "OSC700_05_검색_00770 100Byte 이상 입력한 이전 검색어 확인 (100Byte 이상의 검색어를 입력하여 검색을 진행한 경우)";
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
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys(
				"1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123");

		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_gnb_back").click();
		
		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext");
			
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys(
				"1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890");
		
		assertEquals("1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890", 
				driver.findElementById("com.skt.skaf.A000Z00040:id/search_autocomplete_item_title").getText());
		
		result = "PASS";
	}
}