package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;

public class OSC_700_SRH_01830 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-21
	 * @ ExpectedResult = 메인 > 검색 > 오타 검색어 입력시 올바른 검색어로 자동 변환하여 검색
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_SRH_01830() throws Exception {
		TCID = "OSC700_05_검색_01830 [검색] 선택";
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
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("spdlqj");
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/search_result_category_list").isDisplayed();
		assertEquals("'네이버'", driver.findElementById("com.skt.skaf.A000Z00040:id/search_correction_after_keyword").getText());
		driver.findElementByXPath("//*[@text='검색결과입니다.']").isDisplayed();
		assertEquals("'spdlqj'", driver.findElementById("com.skt.skaf.A000Z00040:id/search_correction_prev_keyword").getText());
		assertEquals("검색하기", driver.findElementById("com.skt.skaf.A000Z00040:id/search_correction_prev_search").getText());
				
		result = "PASS";
	}
}