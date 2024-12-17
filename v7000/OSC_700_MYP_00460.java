package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;

public class OSC_700_MYP_00460 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-10-14
	 * @ ExpectedResult = 마이페이지 > 내 쿠폰 > 보유중인 쿠폰 없을 시 화면 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MYP_00460() throws Exception {
		TCID = "OSC700_04_MY_00460 내 쿠폰 선택 (보유중인 쿠폰이 없는 경우)";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();

		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my_layout").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my").isSelected());
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/menu_my_coupon").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/appbar_edit_actionlayout").click();
		
		for(int i = 0; i <= 30; i++) {
			try {
				Thread.sleep(3000);
				driver.findElementById("com.skt.skaf.A000Z00040:id/my_coupon_item_delete_button").click();
			} catch(Exception e) {
				Thread.sleep(3000);
				try {
					driver.findElementById("com.skt.skaf.A000Z00040:id/appbar_complete_actionlayout").click();
				} catch(Exception ee) {}
				break;
			}
		}
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/empty_image").isDisplayed();
		assertEquals("보유하신 쿠폰이 없습니다.", driver.findElementById("com.skt.skaf.A000Z00040:id/empty_text").getText());
		assertEquals("혜택 보러가기", driver.findElementById("com.skt.skaf.A000Z00040:id/empty_button").getText());
				
		result = "PASS";

	}
}