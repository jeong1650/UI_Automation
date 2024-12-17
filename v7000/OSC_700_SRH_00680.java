package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;

public class OSC_700_SRH_00680 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-17
	 * @ ExpectedResult = 메인 > 검색 > 자동완성 상품 타이틀 선택 시 상품 상세 페이지 이동
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_SRH_00680() throws Exception {
		TCID = "OSC700_05_검색_00680 바로가기 자동완성 상품 타이틀 tap (상품 바로 가기 항목이 있는 경우)";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();
				
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search").click();
		
		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext");
		
		try {
			driver.findElementById("com.skt.skaf.A000Z00040:id/search_history_all_delete").click();
		} catch (Exception e) {}
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("겨울");
		
		Thread.sleep(3000);
		String srhAutoTitle = driver.findElementById("com.skt.skaf.A000Z00040:id/search_autocomplete_item_title").getText();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/search_autocomplete_item_title").click();
		
		Thread.sleep(3000);
		assertEquals(srhAutoTitle, driver.findElementById("com.skt.skaf.A000Z00040:id/main_info_product_name_text_view").getText());
		
		result = "PASS";
	}
}