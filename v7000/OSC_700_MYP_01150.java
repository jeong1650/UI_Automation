package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_MYP_01150 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-10
	 * @ ExpectedResult = 마이페이지 > 구매내역 > 무료 상품 영수증 팝업 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MYP_01150() throws Exception {
		TCID = "OSC700_04_MY_01150 [영수증] 선택 (무료 상품 구매)";
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
		driver.findElementById("com.skt.skaf.A000Z00040:id/receipt").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/date").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/product_title").isDisplayed();
		assertEquals("무료", driver.findElementById("com.skt.skaf.A000Z00040:id/product_value").getText());
		
		assertEquals("닫기", driver.findElementById("com.skt.skaf.A000Z00040:id/close").getText());
																
		result = "PASS";

	}
}