package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_MYP_01090 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-10
	 * @ ExpectedResult = 마이페이지 > 구매내역 > 쇼핑 카테고리 하위 탭 정상 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MYP_01090() throws Exception {
		TCID = "OSC700_04_MY_01090 하위 탭 확인";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();

		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my_layout").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my").isSelected());
		
		downscroll(By.id("com.skt.skaf.A000Z00040:id/menu_purchase_list")).click();
		
		Thread.sleep(3000);
		driver.findElementByXPath("//android.widget.CheckedTextView[@text='쇼핑']").click();
		
		Thread.sleep(3000);
		driver.findElementByXPath("//*[@text='배송상품']").click();
		driver.findElementByXPath("//*[@text='e쿠폰']").click();
		
		driver.findElementByXPath("//*[@text='구매']").click();
		driver.findElementByXPath("//*[@text='받은 선물']").click();
		driver.findElementByXPath("//*[@text='보낸 선물']").click();
														
		result = "PASS";

	}
}