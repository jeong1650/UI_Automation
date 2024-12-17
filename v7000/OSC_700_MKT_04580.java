package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;

public class OSC_700_MKT_04580 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-29
	 * @ ExpectedResult = 혜택 > 쿠폰/캐쉬 등록 화면 타이틀 영역 정상 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MKT_04580() throws Exception {
		TCID = "OSC700_08_마케팅_04580 타이틀 영역";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();
				
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_benefit").click();

		Thread.sleep(3000);
		driver.findElementByXPath("//*[@text='쿠폰/캐쉬 등록']").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_up_indicator").isDisplayed();
		assertEquals("쿠폰/캐쉬 등록", driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_title").getText());
						
		result = "PASS";
	}
}