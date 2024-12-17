package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_MYP_00860 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-10
	 * @ ExpectedResult = 마이페이지 > 구매내역 > 기간 선택 > [기간 설정] 선택
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MYP_00860() throws Exception {
		TCID = "OSC700_04_MY_00860 [기간 설정] 선택";
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
		driver.findElementByXPath("//android.widget.CheckBox[@text='기간설정']").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/my_purchase_start_date").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/my_purchase_end_date").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/my_purchase_start_date").isDisplayed();
		assertEquals("조회", driver.findElementById("com.skt.skaf.A000Z00040:id/my_purchase_select_date_complete").getText());
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/my_purchase_select_date_complete").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/my_purchase_date").isDisplayed();
		assertEquals("기간선택", driver.findElementById("com.skt.skaf.A000Z00040:id/my_purchase_select_date").getText());
														
		result = "PASS";

	}
}