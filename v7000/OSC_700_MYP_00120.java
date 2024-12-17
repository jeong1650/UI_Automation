package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;

public class OSC_700_MYP_00120 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-10-14
	 * @ ExpectedResult = 마이페이지 > 게임 상품 사용 시 평가 의견 남기기 항목 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MYP_00120() throws Exception {
		TCID = "OSC700_04_MY_00120 마이페이지 선택 (게임 상품 사용)";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search").click();

		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext");
				
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("바운딩 바이러스");
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();
		
		String title = driver.findElementById("com.skt.skaf.A000Z00040:id/search_result_item_app_title").getText();
		
		try {
			Thread.sleep(3000);
			driver.findElementByXPath("//*[@text='다운로드']").isDisplayed(); 
			
			Thread.sleep(3000);
			driver.findElementById("com.skt.skaf.A000Z00040:id/search_result_item_download_button").click();
			
			Thread.sleep(3000);
			Click("com.skt.skaf.A000Z00040:id/btn2");
		} catch(Exception e) {}
		
		Thread.sleep(5000);
		for(int i = 0; i < 30; i++) {
			try {
				driver.findElementByXPath("//*[@text='실행']").isDisplayed();
				break;
			} catch(Exception e) {
				Thread.sleep(5000);
			}
		}
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_gnb_back").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my_layout").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my").isSelected());
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/thumbnail").isDisplayed();
		
		for(int i = 0; i < 10; i++) {
			if(driver.findElementById("com.skt.skaf.A000Z00040:id/review_desc").getText().equals(title)) {
				break;
			} else {
				driver.findElementById("com.skt.skaf.A000Z00040:id/btn_review_close").click();
				
				Thread.sleep(3000);
				driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search").click();
				
				Thread.sleep(3000);
				driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my").click();
			}
		}	
		
		Thread.sleep(3000);
		assertEquals("이 게임은 어떠셨나요?", driver.findElementById("com.skt.skaf.A000Z00040:id/review_title").getText());
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_review_close").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/review_desc").isDisplayed();
		assertEquals("평가 의견 남기기", driver.findElementById("com.skt.skaf.A000Z00040:id/btn_review_send").getText());
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_review_send").click();
		
		Thread.sleep(3000);
		assertEquals("내 평가 의견", driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_title").getText());
		
		Thread.sleep(3000);
		Runtime.getRuntime().exec("adb shell pm uninstall -k --user 0 com.BlueStarWorks.Bounce_Ball");
				
		result = "PASS";

	}
}