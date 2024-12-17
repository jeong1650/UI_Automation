package osc.v7000;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_MKT_02840 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-10-16
	 * @ ExpectedResult = 사전예약 > 모든 게임 예약 ON / 사전예약 시작 알림 ON
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MKT_02840() throws Exception {
		TCID = "OSC700_08_마케팅_02840 모든 게임 사전예약, 오픈 알림 신청 영역 (모든 게임 예약 ON, 사전예약 시작 알림 ON인 경우)";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		String textType = "text";
		
		popupCheck();
				
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_game").click();

		Thread.sleep(3000);
		driver.findElementByXPath("//android.widget.Button[@text='신규']").click();
		
		Thread.sleep(3000);
		downscroll(By.xpath("//*[@text='사전예약']")).click();
		
		Thread.sleep(3000);
		try {
			driver.findElementByXPath("//*[@text='모든 게임 예약']").isDisplayed();
			textType = "text";
		} catch (Exception e) {
			driver.findElementByXPath("//*[@content-desc='모든 게임 예약']").isDisplayed();
			textType = "content-desc";
		}		
		
		Thread.sleep(2000);
		try {
			driver.findElementByXPath("//*[@resource-id='btnAllReserve']").isDisplayed();
			
			Thread.sleep(2000);
			driver.findElementByXPath("//*[contains(@" + textType + ", '모든 게임 예약하기')]").click();
			
			Thread.sleep(3000);
			driver.findElementByXPath(makeXPath(textType, "동의하고 예약")).click();
			
			Thread.sleep(3000);
			driver.findElementByXPath(makeXPath(textType, "취소")).click();
			
			Thread.sleep(3000);
			driver.findElementByXPath(makeXPath(textType, "닫기")).click();
		} catch(Exception e) {}
		
		try {
			driver.findElementByXPath("//*[@resource-id='btnRegistAlarm']").isDisplayed();
			
			Thread.sleep(2000);
			driver.findElementByXPath("//*[contains(@" + textType + ", '사전예약 알림 시작하기')]").click();
			
			Thread.sleep(3000);
			driver.findElementByXPath(makeXPath(textType, "알림 취소")).click();
			
			Thread.sleep(3000);
			driver.findElementByXPath(makeXPath(textType, "확인")).click();
		} catch(Exception e) {}
		
		Thread.sleep(2000);
		driver.findElementByXPath(makeXPath(textType, "예약")).isDisplayed();
		driver.findElementByXPath(makeXPath(textType, "모든 게임 예약")).isDisplayed();
		driver.findElementByXPath(makeXPath(textType, "혜택 보기")).isDisplayed();
		driver.findElementByXPath("//*[@resource-id='btnAllReserveCancel']").isDisplayed();
		
		driver.findElementByXPath(makeXPath(textType, "알림")).isDisplayed();
		driver.findElementByXPath(makeXPath(textType, "사전예약 시작 알림")).isDisplayed();
		driver.findElementByXPath("//*[@resource-id='btnRegistAlarmCancel']").isDisplayed();
		
		result = "PASS";
	}
}