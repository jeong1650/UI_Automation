package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;

public class OSC_700_MYP_02890 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-11
	 * @ ExpectedResult = 마이페이지 > 다운로드 관리 > 상품 선택 시 상품 상세 이동
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MYP_02890() throws Exception {
		TCID = "OSC700_04_MY_02890 목록 선택 (다운로드 요청)";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my_layout").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my").isSelected());
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/menu_download").click();
		
		Thread.sleep(3000);
		String dlTitle = driver.findElementById("com.skt.skaf.A000Z00040:id/titleTextView").getText();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/titleTextView").click();
		
		Thread.sleep(3000);
		assertEquals(dlTitle, driver.findElementById("com.skt.skaf.A000Z00040:id/main_info_product_name_text_view").getText());
																					
		result = "PASS";

	}
}