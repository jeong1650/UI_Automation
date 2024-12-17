package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_SRH_00570 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-16
	 * @ ExpectedResult = 메인 > 검색 > 21회 검색 진행 > 히스토리 검색어 최신순 최대 20개 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_SRH_00570() throws Exception {
		TCID = "OSC700_05_검색_00570 히스토리 검색어 영역 (검색을 21회 진행한 경우)";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();
				
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search").click();
		
		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext");
		
		try {
			driver.findElementById("com.skt.skaf.A000Z00040:id/search_history_all_delete").click();
		} catch (Exception e) {}
				
		for(int i = 1; i <= 21; i++) {
			Thread.sleep(3000);
			driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("test" + i);
			
			Thread.sleep(3000);
			driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();
		}
		
		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext");
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_delete_icon").click();
		
		for(int i = 21; i > 1; i--) {
			downscroll(By.xpath("//*[@text='test" + i + "']"));
		}
		assertTrue(driver.findElements(By.xpath("//*[@text='test1']")).size() == 0);
		
		downscroll(By.id("com.skt.skaf.A000Z00040:id/search_history_all_delete")).click();
		
		result = "PASS";
	}
}