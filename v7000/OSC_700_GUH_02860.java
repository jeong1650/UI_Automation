package osc.v7000;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_GUH_02860 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-01
	 * @ ExpectedResult = 앱&라이프 메인 > 임의의 쇼핑상품 선택 > [검색] 선택 시 검색 화면 이동
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */ 

	@Test
	public void OSC_GUH_02860() throws Exception {
		TCID = "OSC700_01_Home_02860  임의의 쇼핑상품선택";
		result = "FAIL";
		size = driver.manage().window().getSize();

		popupCheck();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_app_life").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/btn_app_life").isSelected());
		
		downscroll(By.id("com.skt.skaf.A000Z00040:id/priceView")).click();
				
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_up_indicator").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/action_detail_search").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/action_detail_option").isDisplayed();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/action_detail_search").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").isDisplayed();
		
		result = "PASS";

	}
}