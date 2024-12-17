package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;

public class OSC_700_MYP_00340 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-10
	 * @ ExpectedResult = 마이페이지 > 내 쿠폰 > 정렬 옵션 설정 가능
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MYP_00340() throws Exception {
		TCID = "OSC700_04_MY_00340 [발급순 ] 선택 (보유중인 쿠폰이 여러개 있는경우)";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();

		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my_layout").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my").isSelected());
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/menu_my_coupon").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_up_indicator").isDisplayed();
		assertEquals("내 쿠폰", driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_title").getText());
		assertEquals("편집", driver.findElementById("com.skt.skaf.A000Z00040:id/appbar_edit_actionlayout").getText());
		driver.findElementByXPath("//*[@text='보유 쿠폰']").isDisplayed();
		driver.findElementByXPath("//*[@text='지난 쿠폰']").isDisplayed();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/text").click();
		
		Thread.sleep(3000);
		driver.findElementByXPath("//android.widget.CheckBox[@text='유효기간 순']").click();
		
		Thread.sleep(3000);
		assertEquals("유효기간 순", driver.findElementById("com.skt.skaf.A000Z00040:id/text").getText());
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/text").click();
		
		Thread.sleep(3000);
		driver.findElementByXPath("//android.widget.CheckBox[@text='발급 순']").click();
		
		Thread.sleep(3000);
		assertEquals("발급 순", driver.findElementById("com.skt.skaf.A000Z00040:id/text").getText());
				
		result = "PASS";

	}
}