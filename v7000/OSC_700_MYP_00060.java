package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;

public class OSC_700_MYP_00060 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-10
	 * @ ExpectedResult = 메인 > 마이페이지  > MDN 회원 마이페이지 화면 정상 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MYP_00060() throws Exception {
		TCID = "OSC700_04_MY_00060 마이페이지 선택 (MDN 계정인 경우)";
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
				
		result = "PASS";

	}
}