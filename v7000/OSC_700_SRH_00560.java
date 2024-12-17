package osc.v7000;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_SRH_00560 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-16
	 * @ ExpectedResult = 메인 > 검색 > 히스토리 검색어 20개 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_SRH_00560() throws Exception {
		TCID = "OSC700_05_검색_00560 히스토리 검색어 영역 (검색을 20회 진행한 경우)";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();
				
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search").click();
		
		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext");
		
		try {
			driver.findElementById("com.skt.skaf.A000Z00040:id/search_history_all_delete").click();
		} catch (Exception e) {}
				
		for(int i = 1; i <= 20; i++) {
			Thread.sleep(3000);
			driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("test" + i);
			
			Thread.sleep(3000);
			driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();
		}
		
		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext");
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_delete_icon").click();
		
		for(int i = 20; i > 0; i--) {
			downscroll(By.xpath("//*[@text='test" + i + "']"));
		}
		
		downscroll(By.id("com.skt.skaf.A000Z00040:id/search_history_all_delete")).click();
		
		result = "PASS";
	}
}