package osc.v7000;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_SRH_01790 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-21
	 * @ ExpectedResult = 메인 > 검색 > 검색 결과 없을 시 연관 검색어 영역 정상 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_SRH_01790() throws Exception {
		TCID = "OSC700_05_검색_01790 연관 검색어 영역 확인 (검색 결과가 없는 경우)";
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
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("알약M");
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("난 너를 믿었던 만큼 내 친구도");
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();
		
		Thread.sleep(3000);
		downscroll(By.xpath("//*[@text='연관 검색어']"));	
		downscroll(By.id("com.skt.skaf.A000Z00040:id/rank_keyword_icon_r"));	
		downscroll(By.id("com.skt.skaf.A000Z00040:id/search_relation_keyword_text"));	
				
		result = "PASS";
	}
}