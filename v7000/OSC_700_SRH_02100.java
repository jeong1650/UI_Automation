package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_SRH_02100 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-22
	 * @ ExpectedResult = OS 6.0 미만 단말 또는 OS 6.0 이상 SDK 23 미만 검색 결과 > 다운로드 선택 시 앱 접근 권한 동의 팝업 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_SRH_02100() throws Exception {
		TCID = "OSC700_06_검색_02100 [다운로드] 선택(OS 6.0 미만 단말 또는 OS 6.0 이상 SDK 23 미만 인 경우)";
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
		driver.findElementByXPath("//*[@text='다운로드']").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/search_result_item_download_button").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/app_icon").isDisplayed();
		assertEquals("소년삼국지",	driver.findElementById("com.skt.skaf.A000Z00040:id/app_title").getText());
		assertEquals("앱 접근 권한 동의가 필요합니다.", driver.findElementById("com.skt.skaf.A000Z00040:id/app_desc").getText());
		driver.findElementById("com.skt.skaf.A000Z00040:id/permission_info_background").isDisplayed();
		assertEquals("동의하지 않음", driver.findElementById("com.skt.skaf.A000Z00040:id/btn1").getText());
		assertEquals("동의",	driver.findElementById("com.skt.skaf.A000Z00040:id/btn2").getText());
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn1").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElements(By.id("com.skt.skaf.A000Z00040:id/permission_info_background")).size() == 0);
		
		driver.findElementByXPath("//*[@text='다운로드']").isDisplayed();
														
		result = "PASS";
	}
}