package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_SRH_01020 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-17
	 * @ ExpectedResult = 메인 > 검색 > 검색 결과 화면 > 최 하단 북스 배너 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_SRH_01020() throws Exception {
		TCID = "OSC700_05_검색_01020 북스 배너 위치 확인 (타 카테고리 검색결과 25개 미만인 경우)";
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
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("바람의나라: 연");

		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();
		
		Thread.sleep(3000);
		assertEquals("원스토어 북스 검색결과 보기", downscroll(By.id("com.skt.skaf.A000Z00040:id/search_move_books_title")).getText());
		
		Thread.sleep(3000);
		upSwipe(0.90);
		
		Thread.sleep(3000);
		upSwipe(0.90);
		
		Thread.sleep(3000);
		assertEquals("원스토어 북스 검색결과 보기", downscroll(By.id("com.skt.skaf.A000Z00040:id/search_move_books_title")).getText());
				
		result = "PASS";
	}
}