package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;

public class OSC_700_SRH_00600 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-17
	 * @ ExpectedResult = 메인 > 검색 > 검색어 입력 시 검색창에 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_SRH_00600() throws Exception {
		TCID = "OSC700_05_검색_00600 검색어 입력";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();
				
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search").click();
		
		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext");
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("test");
		
		Thread.sleep(3000);
		assertEquals("test", driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").getText());			
				
		result = "PASS";
	}
}