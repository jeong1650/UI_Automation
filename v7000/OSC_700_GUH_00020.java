package osc.v7000;

import org.junit.Test;

public class OSC_700_GUH_00020 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-08-31
	 * @ ExpectedResult = 메인 > 마이페이지 버튼 정상 노출 > 선택 시 마이페이지 화면 이동
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_GUH_00020() throws Exception {
		TCID = "OSC700_01_Home_00020 마이페이지 버튼 확인";
		result = "FAIL";
		size = driver.manage().window().getSize();

		popupCheck();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_game_layout").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_app_life_layout").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_benefit_layout").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search_layout").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my_layout").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/navi_user_id").isDisplayed();
		
		result = "PASS";

	}
}