package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;

public class OSC_700_SRH_02090 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-22
	 * @ ExpectedResult = 검색 결과 > 100MB 초과 상품 다운로드 시도 시 안내 팝업 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_SRH_02090() throws Exception {
		TCID = "OSC700_06_검색_02090 APP(게임/앱) [다운로드] 선택(100MB 초과 상품인 경우)";
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
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("레알팜");
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/search_result_item_download_button").click();
		
		Thread.sleep(3000);
		assertEquals("100MB가 넘는 상품입니다. 데이터 네트워크로 다운로드 시 통화료가 발생할 수 있습니다.", 
				driver.findElementById("com.skt.skaf.A000Z00040:id/description").getText());
		assertEquals("확인",	driver.findElementById("com.skt.skaf.A000Z00040:id/btn1").getText());
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn1").click();
		
		Thread.sleep(5000);
		for(int i = 0; i < 30; i++) {
			try {
				driver.findElementByXPath("//*[@text='실행']").isDisplayed();
				break;
			} catch(Exception e) {
				Thread.sleep(5000);
			}
		}
		
		Runtime.getRuntime().exec("adb shell pm uninstall -k --user 0 kr.neogames.realfarm");
												
		result = "PASS";
	}
}