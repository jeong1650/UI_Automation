package osc.v7000;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_MKT_02860 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-10-16
	 * @ ExpectedResult = 사전예약 > 모든 게임 예약 / 성인 미인증 상태 시 성인인증 안내영역 노출
	 * @ Editor =
	 * @ EditDate =
	 * @
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MKT_02860() throws Exception {
		TCID = "OSC700_08_마케팅_02860 성인인증 안내 영역 (모든 게임 예약을 완료하였으나 성인 미인증 상태인 경우)";
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
		} catch (Exception e) {
		}
		
		Thread.sleep(3000);
		driver.findElementByXPath("//*[@resource-id='btnAllReserve']").isDisplayed();

		Thread.sleep(2000);
		driver.findElementByXPath("//*[contains(@text, '모든 게임 예약하기')]").click();

		Thread.sleep(3000);
		driver.findElementByXPath("//*[@text='동의하고 예약']").click();

		Thread.sleep(3000);
		driver.findElementByXPath("//*[@text='취소']").click();

		Thread.sleep(3000);
		driver.findElementByXPath("//*[@text='닫기']").click();

		Thread.sleep(2000);
		driver.findElementByXPath("//*[@text='성인인증이 되어있지 않아요']").isDisplayed();
		driver.findElementByXPath("//*[@text='청소년 이용불가 게임은 성인인증이 되어 있는 경우에만 사전예약됩니다.']").isDisplayed();
		driver.findElementByXPath("//*[@text='인증하기']").isDisplayed();
		
		result = "PASS";
	}
}