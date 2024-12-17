package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_720_GUH_02700 extends OSC_Base_text {
	/* -----------------------------------------------------------------------------
	 * @ Writer = Jeong Inho
	 * @ Date = 2020-12-16
	 * @ ExpectedResult = 앱&라이프 > 쇼핑패널 > 임의의 쇼핑 카드 타이틀 선택 > [<] 선택 시 이전 화면 이동
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_GUH_02700() throws Exception{
		TCID = "OSC_720_GUH_02700 임의의 쇼핑카드 타이틀 선택";
		result = "FAIL";
		size = driver.manage().window().getSize();

		popupCheck();

		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_app_life").click();

		Thread.sleep(3000);
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/btn_app_life").isSelected());
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/shopping_tab_text").click();
		
		Thread.sleep(3000);
		downscroll(By.id("com.skt.skaf.A000Z00040:id/headerTextTitle")).click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_up_indicator").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_title").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/action_landing_search").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/shopping_more").isDisplayed();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_up_indicator").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/headerTextTitle").isDisplayed();
		
		result = "PASS";
		
	}

}