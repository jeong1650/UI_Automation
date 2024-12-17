package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;

public class OSC_700_MYP_02320 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-11
	 * @ ExpectedResult = 마이페이지 > 업데이트 > [알림 끄기] 선택 시 해당 상품 삭제
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MYP_02320() throws Exception {
		TCID = "OSC700_04_MY_02320 [알림 끄기] 버튼 선택";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();

		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my_layout").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my").isSelected());
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/menu_update").click();
		
		Thread.sleep(3000);
		String dltTitle = driver.findElementById("com.skt.skaf.A000Z00040:id/my_update_item_app_name").getText();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/my_update_item_recent_update_view").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/my_update_item_noti_off_button").click();
		
		Thread.sleep(3000);
		assertNotEquals(dltTitle, driver.findElementById("com.skt.skaf.A000Z00040:id/my_update_item_app_name").getText());
																	
		result = "PASS";

	}
}