package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_MYP_00820 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-10
	 * @ ExpectedResult = 마이페이지 > 구매내역 > 진입 시 마지막으로 조회한 카테고리 노출 
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MYP_00820() throws Exception {
		TCID = "OSC700_04_MY_00820 구매내역 진입";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();

		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my_layout").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my").isSelected());
		
		downscroll(By.id("com.skt.skaf.A000Z00040:id/menu_purchase_list")).click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_up_indicator").isDisplayed();
		assertEquals("구매내역", driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_title").getText());
		assertEquals("편집", driver.findElementById("com.skt.skaf.A000Z00040:id/appbar_edit_actionlayout").getText());
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/my_purchase_date").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/my_purchase_select_date").isDisplayed();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/my_purchase_category").isDisplayed();
		driver.findElementByXPath("//android.widget.CheckedTextView[@text='게임']").isDisplayed();
		driver.findElementByXPath("//android.widget.CheckedTextView[@text='앱']").isDisplayed();
		driver.findElementByXPath("//android.widget.CheckedTextView[@text='쇼핑']").isDisplayed();
		driver.findElementByXPath("//android.widget.CheckedTextView[@text='북스 외']").isDisplayed();
		
		driver.findElementByXPath("//android.widget.CheckedTextView[@text='앱']").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElementByXPath("//android.widget.CheckedTextView[@text='앱']").getAttribute("checked").equals("true"));
		assertFalse(driver.findElementByXPath("//android.widget.CheckedTextView[@text='게임']").getAttribute("checked").equals("true"));
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_up_indicator").click();
		
		Thread.sleep(3000);
		downscroll(By.id("com.skt.skaf.A000Z00040:id/menu_purchase_list")).click();
		assertTrue(driver.findElementByXPath("//android.widget.CheckedTextView[@text='앱']").getAttribute("checked").equals("true"));
		assertFalse(driver.findElementByXPath("//android.widget.CheckedTextView[@text='게임']").getAttribute("checked").equals("true"));
										
		result = "PASS";

	}
}