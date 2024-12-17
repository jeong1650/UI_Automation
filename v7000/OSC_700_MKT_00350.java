package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;

public class OSC_700_MKT_00350 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-22
	 * @ ExpectedResult = 이벤트 스페셜 팝업 노출 확인
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MKT_00350() throws Exception {
		TCID = "OSC700_01_Home_00350 이벤트 스페셜 팝업 확인 (이벤트 스페셜 팝업이 있는 경우)";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/event_popup_no_open_button").isDisplayed();
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/event_popup_no_open_button").getAttribute("checked").equals("false"));
		driver.findElementByXPath("//*[@text='오늘 보지 않기']").isDisplayed();
		assertEquals("닫기", driver.findElementById("com.skt.skaf.A000Z00040:id/event_popup_close").getText());
								
		result = "PASS";
	}
}