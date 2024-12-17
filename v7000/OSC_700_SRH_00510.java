package osc.v7000;

import org.junit.Test;

public class OSC_700_SRH_00510 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-16
	 * @ ExpectedResult = 메인 > 검색 > 검색어 입력모드 > 검색어 미입력 > 검색 버튼 선택 시 미동작
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_SRH_00510() throws Exception {
		TCID = "OSC700_05_검색_00510 검색 버튼 선택 (검색어 입력 전인 경우, 검색어 없는 경우)";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();
				
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search").click();
		
		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext");
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();
				
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/search_view_container").isDisplayed();
		
		result = "PASS";
	}
}