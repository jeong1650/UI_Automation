package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;

public class OSC_700_MYP_02200 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-11
	 * @ ExpectedResult = 마이페이지 > 업데이트 > 상품 메타정보 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MYP_02200() throws Exception {
		TCID = "OSC700_04_MY_02200 업데이트 (업데이트 항목이 있는 경우)";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();

		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my_layout").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my").isSelected());
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/menu_update").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/my_update_item_image").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/my_update_item_app_name").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/my_update_item_recent_update_date").isDisplayed();
		assertEquals("업데이트", driver.findElementById("com.skt.skaf.A000Z00040:id/my_update_item_recent_update_title").getText());
		driver.findElementById("com.skt.skaf.A000Z00040:id/my_update_item_more_info_button_image").isDisplayed();
		assertEquals("업데이트", driver.findElementById("com.skt.skaf.A000Z00040:id/my_update_item_button").getText());
																
		result = "PASS";

	}
}