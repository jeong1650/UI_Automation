package osc.v7000;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_MKT_02580 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-22
	 * @ ExpectedResult = 사전예약 > 14세 이상 / 성인 미인증 > 모든게임 예약 시 성인인증 안내 팝업 노출
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MKT_02580() throws Exception {
		TCID = "OSC700_08_마케팅_02580 신청 완료 팝업 내 [확인] 선택 (14세 이상 회원인 경우, 성인 미인증 상태)";
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
		
		Thread.sleep(5000);
		driver.findElementByXPath("//*[contains(@" + textType + ", '모든 게임 예약하기')]").click();
		
		try {
			Thread.sleep(3000);
			driver.findElementByXPath(makeXPath(textType, "예약 취소")).click();

			Thread.sleep(3000);
			driver.findElementByXPath(makeXPath(textType, "확인")).click();
			
			Thread.sleep(3000);
			driver.findElementByXPath("//*[contains(@" + textType + ", '모든 게임 예약하기')]").click();
		} catch (Exception e) {}

		Thread.sleep(3000);
		driver.findElementByXPath(makeXPath(textType, "동의하고 예약")).click();

		Thread.sleep(3000);
		driver.findElementByXPath(makeXPath(textType, "자동설치")).click();

		Thread.sleep(3000);
		driver.findElementByXPath(makeXPath(textType, "청소년 이용불가 게임은 성인인증을 하셔야 사전예약 하실 수 있습니다.")).isDisplayed();
		driver.findElementByXPath(makeXPath(textType, "성인인증을 하지 않으시면 청소년 이용불가 게임의 혜택이 지급되지 않습니다.")).isDisplayed();

		driver.findElementByXPath(makeXPath(textType, "닫기")).isDisplayed();
		driver.findElementByXPath(makeXPath(textType, "성인인증하러 가기")).isDisplayed();

		driver.findElementByXPath(makeXPath(textType, "닫기")).click();

		Thread.sleep(3000);
		driver.findElementByXPath(makeXPath(textType, "모든 게임 예약하기")).click();

		Thread.sleep(3000);
		driver.findElementByXPath(makeXPath(textType, "예약 취소")).click();

		Thread.sleep(3000);
		driver.findElementByXPath(makeXPath(textType, "확인")).click();

		result = "PASS";
	}
}