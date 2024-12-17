package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;

public class OSC_700_MKT_00360 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-22
	 * @ ExpectedResult = 이벤트 스페셜 팝업 [닫기] 선택 시 메인화면 진입
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MKT_00360() throws Exception {
		TCID = "OSC700_01_Home_00360 [닫기] 또는 단말 [Back] 선택 (오늘 보지 않기 체크 해제)";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/event_popup_no_open_button").isDisplayed();
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/event_popup_no_open_button").getAttribute("checked").equals("false"));
		driver.findElementByXPath("//*[@text='오늘 보지 않기']").isDisplayed();
		assertEquals("닫기", driver.findElementById("com.skt.skaf.A000Z00040:id/event_popup_close").getText());
						
		driver.findElementById("com.skt.skaf.A000Z00040:id/event_popup_close").click();
		
		Thread.sleep(3000);
		try {
			driver.findElementById("com.skt.skaf.A000Z00040:id/buttonConfirm").click();
		} catch (Exception e) {}	
		
		Thread.sleep(3000);
		try {
			driver.findElementById("com.skt.skaf.A000Z00040:id/do_after_btn").click();
		} catch (Exception e) {}
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_game_layout").isDisplayed();
		result = "PASS";
	}
}