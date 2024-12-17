package osc.v7000;

import org.junit.Test;

public class OSC_700_SRH_00040 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-15
	 * @ ExpectedResult = 메인 > 검색 > 검색창 tap > 검색어 입력중 상태에서 back 버튼 선택 시 검색 메인화면 이동
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_SRH_00040() throws Exception {
		TCID = "OSC700_05_검색_00040 상단 Back 버튼 선택 (검색어 입력중인 상태)";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();
				
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search").click();
		
		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext");
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("test");
				
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_gnb_back").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/search_main_rank_section").isDisplayed();
		
		result = "PASS";
	}
}