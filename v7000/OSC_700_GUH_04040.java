package osc.v7000;

import org.junit.Test;

public class OSC_700_GUH_04040 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-03
	 * @ ExpectedResult = 검색 > 무료 상품 검색 > 설치 완료 된 경우 [실행] 기능 버튼 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */ 

	@Test
	public void OSC_GUH_04040() throws Exception {
		TCID = "OSC700_01_검색_04040  무료 상품검색 (설치가완료 )";
		result = "FAIL";
		size = driver.manage().window().getSize();

		popupCheck();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search_layout").click();
		
		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext");
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("코백 플러스-마스크5부제,코로나100m근접알림,확진자 방문지,코로나19");
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();
		
		Thread.sleep(3000);
		driver.findElementByXPath("//android.widget.TextView[@text='다운로드']").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/search_result_item_download_button").click();
		
		
		for(int i = 0; i < 30; i++) {
			try {
				driver.findElementById("com.skt.skaf.A000Z00040:id/search_result_item_download_button").isDisplayed();
				driver.findElementByXPath("//android.widget.TextView[@text='실행']").isDisplayed();
				result = "PASS";
				break;
			} catch(Exception e) {
				Thread.sleep(3000);
			}
			
		}
	}
}