package osc.v7000;

import org.junit.Test;

public class OSC_700_SRH_02110 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-22
	 * @ ExpectedResult = OS 6.0 미만 단말 또는 OS 6.0 이상 SDK 23 미만 검색 결과 > 다운로드 선택 시 앱 접근 권한 동의 시 다운로드 진행
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_SRH_02110() throws Exception {
		TCID = "OSC700_06_검색_02110 앱 접근 권한 동의 팝업 [동의] 선택";
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
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("소년삼국지 게임펍");
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/search_result_item_download_button").click();
		
		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/btn2");
		
		Thread.sleep(5000);
		for(int i = 0; i < 30; i++) {
			try {
				driver.findElementByXPath("//*[@text='실행']").isDisplayed();
				break;
			} catch(Exception e) {
				Thread.sleep(5000);
			}
		}
		
		Runtime.getRuntime().exec("adb shell pm uninstall -k --user 0 com.gamepub.yt.t");
												
		result = "PASS";
	}
}