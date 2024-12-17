package osc.v7000;

import org.junit.Test;

public class OSC_700_SRH_00350 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-16
	 * @ ExpectedResult = 메인 > 검색 > 임의의 카테고리 선택 > 상단 back 버튼 선택 시 검색 메인 이동
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_SRH_00350() throws Exception {
		TCID = "OSC700_05_검색_00350 상단 Back 버튼 선택";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();
				
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/main_keyword").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/category_sub_sort_type_select_button").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/action_landing_search").isDisplayed();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_up_indicator").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/search_main_rank_section").isDisplayed();
						
		result = "PASS";
	}
}