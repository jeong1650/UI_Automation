package osc.v7000;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_GUH_02580 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-01
	 * @ ExpectedResult = 메인 > 임의 상품 상세 > [Quick 검색] 선택 > Back key 선택 시 상품 상세화면 이동
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_GUH_02580() throws Exception {
		TCID = "OSC700_01_Home_02580 임의의 상품상세화면 (검색 중 화면에서 단말 Back key 선택하는)";
		result = "FAIL";
		size = driver.manage().window().getSize();

		popupCheck();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_game").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/btn_game").isSelected());
		
		String prodTitle = downscroll(By.id("com.skt.skaf.A000Z00040:id/titleView")).getText();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/titleView").click();
		
		Thread.sleep(3000);
		assertEquals(prodTitle, driver.findElementById("com.skt.skaf.A000Z00040:id/main_info_product_name_text_view").getText());
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/action_detail_search").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").isDisplayed();
		
		driver.navigate().back();
		
		Thread.sleep(3000);
		assertEquals(prodTitle, driver.findElementById("com.skt.skaf.A000Z00040:id/main_info_product_name_text_view").getText());
					
		result = "PASS";

	}
}