package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_SRH_01900 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-22
	 * @ ExpectedResult = 메인 > 검색 메인 > 아래로 스크롤 시 타이틀 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_SRH_01900() throws Exception {
		TCID = "OSC700_00_인터_01900 아래로 스크롤";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();
				
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search").click();
		
		Thread.sleep(3000);	
		driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_image").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").isDisplayed();
		
		upSwipe(0.90);
		
		Thread.sleep(3000);	
		assertTrue(driver.findElements(By.id("com.skt.skaf.A000Z00040:id/ready_made_contents_type")).size() == 0);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").isDisplayed();
		
		downSwipe(0.30);
		
		Thread.sleep(3000);	
		downSwipe(0.30);
		
		Thread.sleep(3000);	
		driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_image").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").isDisplayed();
										
		result = "PASS";
	}
}