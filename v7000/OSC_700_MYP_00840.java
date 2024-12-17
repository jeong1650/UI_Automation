package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_MYP_00840 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-10
	 * @ ExpectedResult = 마이페이지 > 구매내역 > 기간 선택 가능
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MYP_00840() throws Exception {
		TCID = "OSC700_04_MY_00840 기간선택";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();

		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my_layout").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my").isSelected());
		
		downscroll(By.id("com.skt.skaf.A000Z00040:id/menu_purchase_list")).click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/my_purchase_select_date").click();
		
		Thread.sleep(3000);
		driver.findElementByXPath("//android.widget.CheckBox[@text='최근1년']").isDisplayed();
		driver.findElementByXPath("//android.widget.CheckBox[@text='최근2년']").isDisplayed();
		driver.findElementByXPath("//android.widget.CheckBox[@text='최근3년']").isDisplayed();
		driver.findElementByXPath("//android.widget.CheckBox[@text='전체']").isDisplayed();
		driver.findElementByXPath("//android.widget.CheckBox[@text='기간설정']").isDisplayed();
												
		result = "PASS";

	}
}