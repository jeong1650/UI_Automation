package osc.v7000;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_SRH_01660 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-21
	 * @ ExpectedResult = 메인 > 검색 > 연관 카테고리 인기검색어 영역 정상 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_SRH_01660() throws Exception {
		TCID = "OSC700_05_검색_01660 연관 카테고리 인기검색어 영역 확인";
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
		downscroll(By.id("com.skt.skaf.A000Z00040:id/search_result_icon_card_kind"));
		downscroll(By.id("com.skt.skaf.A000Z00040:id/rank_keyword_num_r"));
		downscroll(By.id("com.skt.skaf.A000Z00040:id/rank_keyword_r"));
		downscroll(By.id("com.skt.skaf.A000Z00040:id/rank_keyword_icon_r"));
		downscroll(By.xpath("//*[@text='1']"));		
		downscroll(By.xpath("//*[@text='2']"));		
		downscroll(By.xpath("//*[@text='3']"));		
		downscroll(By.xpath("//*[@text='4']"));		
		downscroll(By.xpath("//*[@text='5']"));		
		
		result = "PASS";
	}
}