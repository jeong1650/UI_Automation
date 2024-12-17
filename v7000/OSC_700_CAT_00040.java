package osc.v7000;

import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_CAT_00040 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-03
	 * @ ExpectedResult = 게임 / 앱 상품 상세 > 타이틀 영역 정상 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_CAT_00040() throws Exception {
		TCID = "OSC700_03_APP_00040 타이틀 영역 확인";
		result = "FAIL";
		size = driver.manage().window().getSize();

		popupCheck();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_game").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/btn_game").isSelected());
		
		downscroll(By.id("com.skt.skaf.A000Z00040:id/titleView")).click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_up_indicator").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/action_detail_search").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/action_detail_option").isDisplayed();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/action_detail_search").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_gnb_back").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_up_indicator").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/btn_game").isSelected());
		
		result = "PASS";

	}
}