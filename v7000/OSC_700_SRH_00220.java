package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;

public class OSC_700_SRH_00220 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-16
	 * @ ExpectedResult = 메인 > 검색 > 인기 검색어 영역 > [6~10위 보기] 선택 시 정상 동작
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
		String rnkTitle = driver.findElementById("com.skt.skaf.A000Z00040:id/rank_keyword_r").getText();
		
		assertEquals("6~10위 보기", driver.findElementById("com.skt.skaf.A000Z00040:id/search_change_rank_range").getText());
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/search_change_rank_range").click();
		
		Thread.sleep(3000);
		assertEquals("1~5위 보기", driver.findElementById("com.skt.skaf.A000Z00040:id/search_change_rank_range").getText());		
		
		assertNotEquals(rnkTitle, driver.findElementById("com.skt.skaf.A000Z00040:id/rank_keyword_r").getText());
		
		result = "PASS";
	}
}