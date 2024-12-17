package osc.v7000;

import org.junit.Test;

public class OSC_700_SRH_00930 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-17
	 * @ ExpectedResult = 메인 > 검색 > 검색 결과 화면 > 상품권 충전소 배너 이동
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_SRH_00930() throws Exception {
		TCID = "OSC700_05_검색_00930 3, 배너 선택 (특정 검색어에 배너가 설정 되어 있는 경우, 상품권 충전소 설정된 경우)";
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
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("상품권 충전소");

		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/search_result_banner").isDisplayed();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/search_result_banner").click();
		
		Thread.sleep(3000);
		driver.findElementByXPath("//*[@text='개인정보 제3자 제공동의 (원스토어(주)→상품권 판매사)']").isDisplayed();
				
		driver.findElementByXPath("//*[@text='취소']").click();
		
		result = "PASS";
	}
}