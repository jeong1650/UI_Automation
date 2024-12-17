package osc.v7000;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_MKT_03010 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-10-16
	 * @ ExpectedResult = 사전예약 > 사전예약 신청 전 [사전예약] 버튼 노출
	 * @ Editor =
	 * @ EditDate =
	 * @
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MKT_03010() throws Exception {
		TCID = "OSC700_08_마케팅_03010 사전예약 버튼 영역 (사전예약 신청 전인 경우)";
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
		downscroll(By.xpath("//*[@text='사전예약']"));
				
		result = "PASS";
	}
}