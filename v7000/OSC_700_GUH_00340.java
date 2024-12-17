package osc.v7000;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_GUH_00340 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-08-31
	 * @ ExpectedResult = 게임 메인 화면 정상 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_GUH_00340() throws Exception {
		TCID = "OSC700_01_Home_00340 게임 메인 화면";
		result = "FAIL";
		size = driver.manage().window().getSize();

		popupCheck();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_game").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/btn_game").isSelected());
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_image").isDisplayed();
		driver.findElementByXPath("//android.widget.Button[@text='추천']").isDisplayed();
		driver.findElementByXPath("//android.widget.Button[@text='랭킹']").isDisplayed();
		driver.findElementByXPath("//android.widget.Button[@text='신규']").isDisplayed();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/backgroundImageView").isDisplayed();
		
		downscroll(By.id("com.skt.skaf.A000Z00040:id/headerTextTitle"));
		
		downscroll(By.xpath("//android.widget.TextView[@text='ⓒ One store Co., Ltd.']"));
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_game_layout").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_app_life_layout").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_benefit_layout").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search_layout").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my_layout").isDisplayed();
				
		result = "PASS";

	}
}