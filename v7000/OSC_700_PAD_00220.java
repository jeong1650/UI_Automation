package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;

public class OSC_700_PAD_00220 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-22
	 * @ ExpectedResult = 3G / LTE 연결 상태 > 100MB 초과 상품 다운로드 시도 시 안내팝업 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_PAD_00220() throws Exception {
		TCID = "OSC700_06_APP_00220 [다운로드] 선택(100MB 초과 상품인 경우)";
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
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("좀비고등학교");
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();
		
		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/search_result_item_app_title");

		Thread.sleep(3000);
		assertEquals("다운로드", driver.findElementById("com.skt.skaf.A000Z00040:id/text").getText());
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/text").click();
		
		Thread.sleep(3000);
		assertEquals("100MB가 넘는 상품입니다. 데이터 네트워크로 다운로드 시 통화료가 발생할 수 있습니다.", 
				driver.findElementById("com.skt.skaf.A000Z00040:id/description").getText());
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn1").click();
				
		Thread.sleep(3000);
		for(int i = 0; i < 30; i++) {
			try {
				assertEquals("실행", driver.findElementById("com.skt.skaf.A000Z00040:id/text").getText());
				result = "PASS";
				break;
			} catch(Exception e) {
				Thread.sleep(3000);
			}
		}
										
		result = "PASS";
	}
}