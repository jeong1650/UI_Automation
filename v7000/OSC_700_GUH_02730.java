package osc.v7000;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_GUH_02730 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-01
	 * @ ExpectedResult = 게임 메인 > 임의의 게임 카드 타이틀 선택 > [<] 선택 시 이전 화면 이동
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */ 

	@Test
	public void OSC_GUH_02730() throws Exception {
		TCID = "OSC700_01_Home_02730  임의의 게임카드 타이틀 선택";
		result = "FAIL";
		size = driver.manage().window().getSize();

		popupCheck();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_game").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/btn_game").isSelected());
		
		downscroll(By.id("com.skt.skaf.A000Z00040:id/headerTextTitle")).click();
				
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_up_indicator").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_title").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/action_landing_search").isDisplayed();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_up_indicator").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/headerTextTitle").isDisplayed();
		
		result = "PASS";

	}
}