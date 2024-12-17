package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_SRH_00130 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-16
	 * @ ExpectedResult = 메인 > 검색 > 검색창 영역 정상 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_SRH_00130() throws Exception {
		TCID = "OSC700_05_검색_00130 검색 창 영역 (검색어 없는 경우)";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();
				
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search").click();
		
		Thread.sleep(3000);
		assertEquals("검색어를 입력해 주세요", driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").getText());
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").isDisplayed();
		assertTrue(driver.findElements(By.id("com.skt.skaf.A000Z00040:id/searchbar_gnb_back")).size() == 0);

		Click("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext");
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_gnb_back").isDisplayed();
				
		result = "PASS";
	}
}