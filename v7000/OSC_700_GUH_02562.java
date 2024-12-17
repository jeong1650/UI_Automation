package osc.v7000;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_GUH_02562 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-01
	 * @ ExpectedResult = 게임 추천 화면 > 운영자 추천 카드 > 상품 선택 > H/W back 선택 시 랜딩 리스트 화면 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_GUH_02562() throws Exception {
		TCID = "OSC700_01_Home_02562 H/W back 선택";
		result = "FAIL";
		size = driver.manage().window().getSize();

		popupCheck();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_game").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/btn_game").isSelected());
				
		downscroll(By.id("com.skt.skaf.A000Z00040:id/headerTextTitle")).click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_title").isDisplayed();
		
		String gameTitle = driver.findElementById("com.skt.skaf.A000Z00040:id/title").getText();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/title").click();
		
		Thread.sleep(3000);
		assertEquals(gameTitle, driver.findElementById("com.skt.skaf.A000Z00040:id/main_info_product_name_text_view").getText());
		
		driver.navigate().back();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_title").isDisplayed();
						
		result = "PASS";

	}
}