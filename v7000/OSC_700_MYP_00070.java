package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;

public class OSC_700_MYP_00070 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-10
	 * @ ExpectedResult = 메인 > 마이페이지  > [아이디 회원 전환] 선택 시 ID 선택 창 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MYP_00060() throws Exception {
		TCID = "OSC700_04_MY_00070 [아이디 회원 전횐] 선택(MDN 회원)";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();

		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my_layout").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my").isSelected());
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_image").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/appbar_noti_icon_actionlayout").isDisplayed();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/navi_user_id").isDisplayed();
		assertEquals("아이디 회원 전환", driver.findElementById("com.skt.skaf.A000Z00040:id/tv_account_chageover").getText());
				
		driver.findElementById("com.skt.skaf.A000Z00040:id/tv_account_chageover").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.OA00018282:id/tv_member_login_title").isDisplayed();
		
		driver.navigate().back();
		
		result = "PASS";

	}
}