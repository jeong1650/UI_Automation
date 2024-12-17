package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_SRH_01670 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-21
	 * @ ExpectedResult = 메인 > 검색 > 연관 카테고리 인기검색어 영역 > 키워드 선택 시 해당 키워드 검색결과 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_SRH_01670() throws Exception {
		TCID = "OSC700_05_검색_01670 검색어 tap";
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
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("바람의나라");
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();
		
		Thread.sleep(3000);
		downscroll(By.xpath("//*[@text='게이머들의 인기 검색어']"));		
		
		String rankKeywordTitle = downscroll(By.id("com.skt.skaf.A000Z00040:id/rank_keyword_r")).getText();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/rank_keyword_r").click();
		
		Thread.sleep(3000);
		assertEquals(rankKeywordTitle, driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").getText());
				
		result = "PASS";
	}
}