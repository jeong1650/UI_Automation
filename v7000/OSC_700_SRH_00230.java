package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;

import io.appium.java_client.SwipeElementDirection;

public class OSC_700_SRH_00230 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-16
	 * @ ExpectedResult = 메인 > 검색 > 인기 검색어 영역 > 좌우 플리킹 시 타종의 인기 검색어 조회
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_SRH_00230() throws Exception {
		TCID = "OSC700_05_검색_00230 검색어 좌우로 flicking";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();
				
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search").click();
		
		Thread.sleep(3000);
		String rnkListTitle = driver.findElementById("com.skt.skaf.A000Z00040:id/title_search_rank_section").getText();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/search_keyword_rank_list").swipe(SwipeElementDirection.LEFT, 2000);
		
		Thread.sleep(3000);
		assertNotEquals(rnkListTitle, driver.findElementById("com.skt.skaf.A000Z00040:id/title_search_rank_section").getText());
			
		driver.findElementById("com.skt.skaf.A000Z00040:id/search_keyword_rank_list").swipe(SwipeElementDirection.RIGHT, 2000);
		
		Thread.sleep(3000);
		assertEquals(rnkListTitle, driver.findElementById("com.skt.skaf.A000Z00040:id/title_search_rank_section").getText());
		
		result = "PASS";
	}
}