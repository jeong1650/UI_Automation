package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;

public class OSC_700_SRH_00490 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-16
	 * @ ExpectedResult = 메인 > 검색 > 검색창 선택 시 검석어 입력 모드 진입
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_SRH_00490() throws Exception {
		TCID = "OSC700_05_검색_00490 검색창 확인 (검색어 입력 전인 경우)";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();
				
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search").click();
		
		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext");
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_gnb_back").isDisplayed();
		assertEquals("검색어를 입력해 주세요", driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").getText());
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").isDisplayed();
			
		result = "PASS";
	}
}