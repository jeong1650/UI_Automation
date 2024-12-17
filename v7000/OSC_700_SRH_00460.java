package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_SRH_00460 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-16
	 * @ ExpectedResult = 메인 > 검색 > 검색 한번 진행 한 경우 검색어 영역 정상 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_SRH_00460() throws Exception {
		TCID = "OSC700_05_검색_00460 검색어 영역 확인 (검색을 1회 진행한 경우)";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();
				
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search").click();
		
		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext");
		
		for(int i = 0; i <= 20; i++) {
			try {
				driver.findElementById("com.skt.skaf.A000Z00040:id/search_history_item_delete").click();
			} catch(Exception e) {
				break;
			}
		}
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("test");
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_gnb_back").click();
		

		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext");		
		
		Thread.sleep(3000);
		assertEquals("test", driver.findElementById("com.skt.skaf.A000Z00040:id/search_history_item_keyword").getText());
		driver.findElementById("com.skt.skaf.A000Z00040:id/search_history_item_date").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/search_history_item_delete").isDisplayed();		
		
		assertTrue(driver.findElements(By.xpath("//*[@resource-id='com.skt.skaf.A000Z00040:id/search_history_recyclerview']/android.widget.LinearLayout[@index='1']"
				+ "//*[@resource-id='com.skt.skaf.A000Z00040:id/search_history_item_keyword']")).size() == 0);
	
		result = "PASS";
	}
}