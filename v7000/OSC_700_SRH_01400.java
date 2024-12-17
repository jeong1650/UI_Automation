package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;

public class OSC_700_SRH_01400 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-18
	 * @ ExpectedResult = 메인 > 검색 > 쇼핑상품 기본정보 선택 시 상세 페이지 이동
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_SRH_01400() throws Exception {
		TCID = "OSC700_05_검색_01400 기본정보 영역 tap";
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
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("핫후라이드+치즈볼+콜라1.25L");

		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();
		
		Thread.sleep(3000);
		String title = driver.findElementById("com.skt.skaf.A000Z00040:id/search_result_item_shop_title").getText();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/search_result_item_shop_title").click();
		
		Thread.sleep(3000);
		assertEquals(title, driver.findElementById("com.skt.skaf.A000Z00040:id/main_info_title").getText());
		
		result = "PASS";
	}
}