package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_SRH_01270 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-18
	 * @ ExpectedResult = 메인 > 검색 > 부가정보 on / off 가능
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_SRH_01270() throws Exception {
		TCID = "OSC700_05_검색_01270 부가 정보 버튼 영역 확인";
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
		String tagXPath1 = "//*[@resource-id='com.skt.skaf.A000Z00040:id/search_result_tag_list_view']/*/*[@index='0']/*[@resource-id='com.skt.skaf.A000Z00040:id/search_tag_keyword']";
		if(driver.findElementByXPath(tagXPath1).isSelected()) {
		}
		else {
			driver.findElementByXPath(tagXPath1).click();
			
			Thread.sleep(3000);
			assertTrue(driver.findElementByXPath(tagXPath1).isSelected());
		}
		driver.findElementByXPath(tagXPath1).click();
		
		Thread.sleep(3000);
		assertFalse(driver.findElementByXPath(tagXPath1).isSelected());
		assertTrue(driver.findElements(By.id("com.skt.skaf.A000Z00040:id/search_result_detail_container")).size() == 0);

		result = "PASS";
	}
}