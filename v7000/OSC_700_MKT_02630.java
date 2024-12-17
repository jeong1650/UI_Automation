package osc.v7000;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_MKT_02630 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-22
	 * @ ExpectedResult = 사전예약 > [사전예약 신청] 선택 시 팝업 노출
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MKT_02630() throws Exception {
		TCID = "OSC700_08_마케팅_02630 [사전예약 신청] 선택";
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
		downscroll(By.xpath(makeXPath(textType, "사전예약"))).click();
		
		Thread.sleep(3000);
		try {
			driver.findElementByXPath(makeXPath(textType, "사전예약을 위해 개인 정보 수집 및 이용에 동의해 주세요.\n" +  
					"사전예약 혜택은 아이디 당 한 번만 받을 수 있습니다.")).isDisplayed();
		} catch(Exception e) {
			driver.findElementByXPath(makeXPath(textType, "사전예약을 위해 개인 정보 수집 및 이용에 동의해 주세요.")).isDisplayed();
			driver.findElementByXPath(makeXPath(textType, "사전예약 혜택은 아이디 당 한 번만 받을 수 있습니다.")).isDisplayed();
		}
		driver.findElementByXPath(makeXPath(textType, "전문보기")).isDisplayed();
		driver.findElementByXPath(makeXPath(textType, "취소")).isDisplayed();
		driver.findElementByXPath(makeXPath(textType, "동의하고 예약")).isDisplayed();

		result = "PASS";
	}
}