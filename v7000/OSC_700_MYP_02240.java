package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;

public class OSC_700_MYP_02240 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-11
	 * @ ExpectedResult = 마이페이지 > 업데이트 > 섬네일 선택 시 상품 상세 이동
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MYP_02240() throws Exception {
		TCID = "OSC700_04_MY_02240 임의의 항목 섬네일 선택";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();

		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my_layout").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my").isSelected());
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/menu_update").click();
		
		Thread.sleep(3000);
		String udtTitle = driver.findElementById("com.skt.skaf.A000Z00040:id/my_update_item_app_name").getText();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/my_update_item_image").click();
		
		Thread.sleep(3000);
		assertEquals(udtTitle, driver.findElementById("com.skt.skaf.A000Z00040:id/main_info_product_name_text_view").getText());
																		
		result = "PASS";

	}
}