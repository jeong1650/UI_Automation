package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;

public class OSC_700_SRH_00380 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-16
	 * @ ExpectedResult = 메인 > 검색 > 검색 입력 모드 > 검색어 입력시 입력 필드 정상 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_SRH_00380() throws Exception {
		TCID = "OSC700_05_검색_00380 검색어 입력";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();
				
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search").click();
		
		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext");
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("test");
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_gnb_back").isDisplayed();
		assertEquals("test", driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").getText());
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_delete_icon").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_delete_icon").isDisplayed();
		
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").getAttribute("enabled").equals("true"));
								
		result = "PASS";
	}
}