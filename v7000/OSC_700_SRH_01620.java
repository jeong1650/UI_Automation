package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_SRH_01620 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-21
	 * @ ExpectedResult = 메인 > 검색 > 게임 / 앱 상품 연관 카테고리 인기상품 영역 > 상품 선택 시 상품 상세 페이지 이동
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_SRH_01620() throws Exception {
		TCID = "OSC700_05_검색_01620 상품영역 tap 게임/앱 연관 카테고리 인기상품 영역 확인";
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
		downscroll(By.xpath("//*[@text='롤플레잉 TOP 20']"));	
		
		String similarTitle = downscroll(By.id("com.skt.skaf.A000Z00040:id/search_result_detail_similar_text")).getText();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/search_result_detail_similar_text").click();
		
		Thread.sleep(3000);
		assertEquals(similarTitle, driver.findElementById("com.skt.skaf.A000Z00040:id/main_info_product_name_text_view").getText());
				
		result = "PASS";
	}
}