package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;

public class OSC_700_SRH_01280 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-18
	 * @ ExpectedResult = 메인 > 검색 > 부가정보 A 선택 후 B 선택 시 B 정보 노출 / 복수 선택 X
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_SRH_01280() throws Exception {
		TCID = "OSC700_05_검색_01280 부가 정보 B tap";
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
		String tagXPath_1 = "//*[@resource-id='com.skt.skaf.A000Z00040:id/search_result_tag_list_view']/*/*[@index='0']/*[@resource-id='com.skt.skaf.A000Z00040:id/search_tag_keyword']";
		String tagXPath_2 = "//*[@resource-id='com.skt.skaf.A000Z00040:id/search_result_tag_list_view']/*/*[@index='1']/*[@resource-id='com.skt.skaf.A000Z00040:id/search_tag_keyword']";
		
		if(driver.findElementByXPath(tagXPath_1).isSelected()) {}
		else {
			driver.findElementByXPath(tagXPath_1).click();
		}
		Thread.sleep(3000);
		assertTrue(driver.findElementByXPath(tagXPath_1).isSelected());
		
		driver.findElementByXPath(tagXPath_2).click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElementByXPath(tagXPath_2).isSelected());
		
		result = "PASS";
	}
}