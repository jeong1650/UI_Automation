package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;

public class OSC_700_MYP_03110 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-11
	 * @ ExpectedResult = 마이페이지 > 다운로드 관리 > 설치 완료 상품 정상 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MYP_03110() throws Exception {
		TCID = "OSC700_04_MY_03110 리스트 영역 확인 (앱상품 다운로드 완료 / 설치완료 )";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();
				
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search_layout").click();
		
		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext");
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("서울주차정보");
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();
		
		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/search_result_item_app_title");
		
		Thread.sleep(3000);
		String title = driver.findElementById("com.skt.skaf.A000Z00040:id/main_info_product_name_text_view").getText();
		
		try {
			assertEquals("다운로드", driver.findElementById("com.skt.skaf.A000Z00040:id/text").getText());
			driver.findElementById("com.skt.skaf.A000Z00040:id/text").click();
			
			try {
				Click("com.skt.skaf.A000Z00040:id/btn2");
			} catch (Exception e) {}
		} catch (Exception e) {}
		
		for (int i = 0; i < 30; i++) {
			try {
				assertEquals("실행", driver.findElementById("com.skt.skaf.A000Z00040:id/text").getText());
				break;
			} catch (Exception e) {
				Thread.sleep(3000);
			}
		}
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_up_indicator").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_gnb_back").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my_layout").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/menu_download").click();
		
		Thread.sleep(3000);
		assertEquals(title, driver.findElementById("com.skt.skaf.A000Z00040:id/titleTextView").getText());
		assertEquals("실행", driver.findElementById("com.skt.skaf.A000Z00040:id/rightButton").getText());
																			
		result = "PASS";

	}
}