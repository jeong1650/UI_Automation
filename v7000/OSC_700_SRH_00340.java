package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;

public class OSC_700_SRH_00340 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-16
	 * @ ExpectedResult = 메인 > 검색 > 인기 검색어 영역 > 임의의 검색어 선택 > 상단 back 버튼 선택 시 검색 메인 이동
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_SRH_00340() throws Exception {
		TCID = "OSC700_05_검색_00340 상단 Back 버튼 선택";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();
				
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search").click();
		
		Thread.sleep(3000);
		String rnkTitle = driver.findElementById("com.skt.skaf.A000Z00040:id/rank_keyword_r").getText();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/rank_keyword_r").click();
		
		Thread.sleep(3000);
		assertEquals(rnkTitle, driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").getText());
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_gnb_back").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/search_main_rank_section").isDisplayed();
						
		result = "PASS";
	}
}