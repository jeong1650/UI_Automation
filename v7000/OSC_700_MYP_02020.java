package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_MYP_02020 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-10
	 * @ ExpectedResult = 마이페이지 > 구매내역 > [편집] 선택 > [종료] 선택 시 변경 미반영
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MYP_02020() throws Exception {
		TCID = "OSC700_04_MY_02020 [종료] 선택";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();

		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search_layout").click();

		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext");

		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("알약M");
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();

		try {
			Thread.sleep(3000);
			driver.findElementByXPath("//*[@text='다운로드']").isDisplayed(); 
			
			Thread.sleep(3000);
			driver.findElementById("com.skt.skaf.A000Z00040:id/search_result_item_download_button").click();
			
			Thread.sleep(3000);
			Click("com.skt.skaf.A000Z00040:id/btn2");
		} catch(Exception e) {}
		
		for(int i = 0; i < 30; i++) {
			try {
				driver.findElementByXPath("//*[@text='실행']").isDisplayed(); 
				break;
			} catch(Exception e) {
				Thread.sleep(3000);
			}
		}		
		
		driver.navigate().back();

		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my_layout").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my").isSelected());
		
		downscroll(By.id("com.skt.skaf.A000Z00040:id/menu_purchase_list")).click();
		
		Thread.sleep(3000);
		driver.findElementByXPath("//android.widget.CheckedTextView[@text='앱']").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/appbar_edit_actionlayout").click();
		
		Thread.sleep(3000);
		String dltTitle = driver.findElementById("com.skt.skaf.A000Z00040:id/purchase_item_title").getText();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/purchase_delete_btn").click();
		
		Thread.sleep(3000);
		try {
			driver.findElementById("com.skt.skaf.A000Z00040:id/purchase_item_title").isDisplayed();			
			assertNotEquals(dltTitle, driver.findElementById("com.skt.skaf.A000Z00040:id/purchase_item_title").getText());
		} catch(Exception e) {
			assertTrue(driver.findElements(By.id("com.skt.skaf.A000Z00040:id/purchase_item_title")).size() == 0);
		}
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/action_mode_close_button").click();
		
		Thread.sleep(3000);
		assertEquals(dltTitle, driver.findElementById("com.skt.skaf.A000Z00040:id/purchase_item_title").getText());
				
		Thread.sleep(3000);
		Runtime.getRuntime().exec("adb uninstall com.estsoft.alyac");    
																						
		result = "PASS";

	}
}