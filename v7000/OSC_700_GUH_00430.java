package osc.v7000;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_GUH_00430 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-08-31
	 * @ ExpectedResult = 게임 추천 화면 > 고객센터 선택 시 고객센터 화면 이동
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_GUH_00430() throws Exception {
		TCID = "OSC700_01_Home_00430 고객센터 선택";
		result = "FAIL";
		size = driver.manage().window().getSize();

		popupCheck();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_game").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/btn_game").isSelected());
		
		assertEquals("고객센터", downscroll(By.id("com.skt.skaf.A000Z00040:id/footer_cs")).getText());
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/footer_cs").click();
		
		Thread.sleep(3000);
		assertEquals("고객센터", driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_title").getText());
		
		result = "PASS";

	}
}