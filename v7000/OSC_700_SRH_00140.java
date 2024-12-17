package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;

public class OSC_700_SRH_00140 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-16
	 * @ ExpectedResult = 메인 > 검색 > 인기 검색어 영역 정상 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_SRH_00130() throws Exception {
		TCID = "OSC700_05_검색_00130 검색 창 영역 (검색어 없는 경우)";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();
				
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/search_main_rank_section").isDisplayed();
		assertEquals("오늘의 급상승검색어", driver.findElementById("com.skt.skaf.A000Z00040:id/title_search_rank_section").getText());
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/search_keyword_rank_list").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/rank_keyword_num_r").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/rank_keyword_icon_r").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/search_main_rank_section").isDisplayed();
		
		assertEquals("6~10위 보기", driver.findElementById("com.skt.skaf.A000Z00040:id/search_change_rank_range").getText());
						
		result = "PASS";
	}
}