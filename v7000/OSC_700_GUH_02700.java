package osc.v7000;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class OSC_700_GUH_02700 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-01
	 * @ ExpectedResult = 메인 > [검색] 선택 시 검색 화면 이동
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */ 

	@Test
	public void OSC_GUH_02700() throws Exception {
		TCID = "OSC700_01_Home_02700  [검색] 선택";
		result = "FAIL";
		size = driver.manage().window().getSize();

		popupCheck();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search").isSelected());
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").isDisplayed();
					
		result = "PASS";

	}
}