package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_GUH_00040 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-08-31
	 * @ ExpectedResult = 게임 > 임의 상품 상세 > 상단 영역 정상 노출
	 * @ Editor = 
	 * @ EditDate = 2020-10-13
	 * @ 상단 영역 인식 수정
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_GUH_00040() throws Exception {
		TCID = "OSC700_01_Home_00040 상단 영역 확인";
		result = "FAIL";
		size = driver.manage().window().getSize();

		popupCheck();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_game_layout").click();
		
		String title = downscroll(By.id("com.skt.skaf.A000Z00040:id/titleView")).getText();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/titleView").click();
		
		Thread.sleep(3000);	
		assertEquals(title, driver.findElementById("com.skt.skaf.A000Z00040:id/main_info_product_name_text_view").getText());
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_up_indicator").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/action_detail_search").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/action_detail_option").isDisplayed();
				
		result = "PASS";

	}
}