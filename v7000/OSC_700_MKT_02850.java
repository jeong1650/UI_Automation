package osc.v7000;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_MKT_02850 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-10-16
	 * @ ExpectedResult = 사전예약 > 모든 게임 예약 OFF / 사전예약 시작 알림 ON
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MKT_02850() throws Exception {
		TCID = "OSC700_08_마케팅_02850 모든 게임 사전예약, 오픈 알림 신청 영역 (모든 게임 예약 OFF, 사전예약 시작 알림 ON인 경우)";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();
				
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_game").click();

		Thread.sleep(3000);
		driver.findElementByXPath("//android.widget.Button[@text='신규']").click();
		
		Thread.sleep(3000);
		downscroll(By.xpath("//*[@text='사전예약']")).click();
		
		Thread.sleep(2000);
		try {
			driver.findElementByXPath("//*[@resource-id='btnAllReserveCancel']").isDisplayed();
			
			Thread.sleep(2000);
			driver.findElementByXPath("//*[contains(@text, '모든 게임 예약하기')]").click();
			
			Thread.sleep(3000);
			driver.findElementByXPath("//*[@text='예약 취소']").click();
			
			Thread.sleep(3000);
			driver.findElementByXPath("//*[@text='확인']").click();
		} catch(Exception e) {}
		
		try {
			driver.findElementByXPath("//*[@resource-id='btnRegistAlarm']").isDisplayed();
			
			Thread.sleep(2000);
			driver.findElementByXPath("//*[contains(@text, '사전예약 알림 시작하기')]").click();
			
			Thread.sleep(3000);
			driver.findElementByXPath("//*[@text='동의하고 신청']").click();
			
			Thread.sleep(3000);
			driver.findElementByXPath("//*[@text='확인']").click();
		} catch(Exception e) {}
		
		Thread.sleep(2000);
		driver.findElementByXPath("//*[@text='예약']").isDisplayed();
		driver.findElementByXPath("//*[@text='모든 게임 예약']").isDisplayed();
		driver.findElementByXPath("//*[@text='혜택 보기']").isDisplayed();
		driver.findElementByXPath("//*[@resource-id='btnAllReserve']").isDisplayed();
		
		driver.findElementByXPath("//*[@text='알림']").isDisplayed();
		driver.findElementByXPath("//*[@text='사전예약 시작 알림']").isDisplayed();
		driver.findElementByXPath("//*[@resource-id='btnRegistAlarmCancel']").isDisplayed();
		
		result = "PASS";
	}
}