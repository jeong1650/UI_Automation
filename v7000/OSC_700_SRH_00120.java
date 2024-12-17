package osc.v7000;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_SRH_00120 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-16
	 * @ ExpectedResult = 메인 > 검색 화면 정상 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_SRH_00120() throws Exception {
		TCID = "OSC700_05_검색_00120 하단 GNB 영역 검색 메뉴 tap";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();
				
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_image").isDisplayed();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").isDisplayed();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/search_main_rank_section").isDisplayed();
		assertEquals("오늘의 급상승검색어", driver.findElementById("com.skt.skaf.A000Z00040:id/title_search_rank_section").getText());
		driver.findElementById("com.skt.skaf.A000Z00040:id/search_keyword_rank_list").isDisplayed();
		assertEquals("6~10위 보기", driver.findElementById("com.skt.skaf.A000Z00040:id/search_change_rank_range").getText());
		
		downscroll(By.xpath("//*[@text='게임 카테고리']"));
		
		downscroll(By.xpath("//*[@text='앱 카테고리']"));
		
		downscroll(By.xpath("//*[@text='쇼핑 카테고리']"));
		
		assertEquals("원스토어 북스 바로가기", downscroll(By.id("com.skt.skaf.A000Z00040:id/search_move_books_title")).getText());
		
		result = "PASS";
	}
}