package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_MYP_00900 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-10
	 * @ ExpectedResult = 마이페이지 > 구매내역 > 상품 정보 정상 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MYP_00900() throws Exception {
		TCID = "OSC700_04_MY_00900 상품명 정보 확인 (단품(게임,앱) 상품의 경우)";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();

		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my_layout").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my").isSelected());
		
		downscroll(By.id("com.skt.skaf.A000Z00040:id/menu_purchase_list")).click();
		
		Thread.sleep(3000);
		driver.findElementByXPath("//android.widget.CheckedTextView[@text='게임']").click();
		
		Thread.sleep(3000);
		driver.findElementByXPath("//*[@text='상품']").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/purchase_thumbnail_image").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/purchase_item_title").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/date").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/price").isDisplayed();
		assertEquals("영수증", driver.findElementById("com.skt.skaf.A000Z00040:id/text_receipt").getText());
														
		result = "PASS";

	}
}