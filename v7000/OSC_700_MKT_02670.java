package osc.v7000;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_MKT_02670 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-22
	 * @ ExpectedResult = 모든게임 예약시 팝업 노출
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MKT_02670() throws Exception {
		TCID = "OSC700_08_마케팅_02670 [모든 게임 예약] 선택";
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
		
		try {
			driver.findElementByXPath("//*[@resource-id='btnAllReserveCancel']").isDisplayed();

			Thread.sleep(3000);
			driver.findElementByXPath("//*[contains(@" + textType + ", '모든 게임 예약하기')]").click();

			Thread.sleep(3000);
			driver.findElementByXPath(makeXPath(textType, "예약 취소")).click();

			Thread.sleep(3000);
			driver.findElementByXPath(makeXPath(textType, "확인")).click();
		} catch (Exception e) {}
		
		Thread.sleep(3000);
		driver.findElementByXPath("//*[contains(@" + textType + ", '모든 게임 예약하기')]").click();

		Thread.sleep(3000);
		try {
			driver.findElementByXPath(makeXPath(textType, "모든 게임 예약을 위해\n" + "개인정보 수집 및 이용에 동의해 주세요.")).isDisplayed();
		} catch(Exception e) {
			driver.findElementByXPath(makeXPath(textType, "모든 게임 예약을 위해")).isDisplayed();
			driver.findElementByXPath(makeXPath(textType, "개인정보 수집 및 이용에 동의해 주세요.")).isDisplayed();
		}
		driver.findElementByXPath(makeXPath(textType, "전문보기")).isDisplayed();
		
		try {
			driver.findElementByXPath(makeXPath(textType, "사전예약 혜택은 아이디 당 한번만 지급됩니다.\n" + 
					"게임에 따라 혜택 지급과 함께 자동설치 될 수 있습니다.\n" +
					"청소년 이용불가 게임은 성인인증을 한 회원만 예약됩니다.")).isDisplayed();
		} catch(Exception e) {
			driver.findElementByXPath(makeXPath(textType, "사전예약 혜택은 아이디 당 한번만 지급됩니다.")).isDisplayed();
			driver.findElementByXPath(makeXPath(textType, "게임에 따라 혜택 지급과 함께 자동설치 될 수 있습니다.")).isDisplayed();
			driver.findElementByXPath(makeXPath(textType, "청소년 이용불가 게임은 성인인증을 한 회원만 예약됩니다.")).isDisplayed();
		}
		
		driver.findElementByXPath(makeXPath(textType, "취소")).isDisplayed();
		driver.findElementByXPath(makeXPath(textType, "동의하고 예약")).isDisplayed();
		
		driver.findElementByXPath(makeXPath(textType, "취소")).click();
				
		result = "PASS";
	}
}