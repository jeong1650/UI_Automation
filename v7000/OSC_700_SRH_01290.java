package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;

public class OSC_700_SRH_01290 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-18
	 * @ ExpectedResult = 메인 > 검색 > 부가정보 스크린샷 선택 시 정상 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_SRH_01290() throws Exception {
		TCID = "OSC700_05_검색_01290 스크린샷 선택";
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
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("웨이브");

		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();
		
		Thread.sleep(3000);
		String tagXPath_screenshot = "//*[@resource-id='com.skt.skaf.A000Z00040:id/search_result_tag_list_view']//*[@text='스크린샷']";
		
		if(driver.findElementByXPath(tagXPath_screenshot).isSelected()) {}
		else {
			driver.findElementByXPath(tagXPath_screenshot).click();
		}
		Thread.sleep(3000);
		assertTrue(driver.findElementByXPath(tagXPath_screenshot).isSelected());
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/youtube_play_image_view").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/search_screenshot_image").isDisplayed();
				
		result = "PASS";
	}
}