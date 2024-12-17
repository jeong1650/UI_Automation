package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_MKT_02750 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-28
	 * @ ExpectedResult = 오픈알림 취소 시도 시 팝업 노출
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MKT_02750() throws Exception {
		TCID = "OSC700_08_마케팅_02750 게임상품 [오픈 알림 취소] 선택 (알림 신청이 되어 있는 경우)";
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
		driver.findElementByXPath("//*[contains(@" + textType + ", '사전예약 알림 시작하기')]").click();
		
		try {
			Thread.sleep(3000);
			driver.findElementByXPath(makeXPath(textType, "동의하고 신청")).click();
			
			Thread.sleep(3000);
			driver.findElementByXPath(makeXPath(textType, "확인")).click();
			
			Thread.sleep(5000);
			driver.findElementByXPath("//*[contains(@" + textType + ", '사전예약 알림 시작하기')]").click();
		} catch(Exception e) {}

		Thread.sleep(3000);
		driver.findElementByXPath(makeXPath(textType, "새로 나온 사전예약 게임 알림을 취소합니다.")).isDisplayed();
		driver.findElementByXPath(makeXPath(textType, "닫기")).isDisplayed();
		driver.findElementByXPath(makeXPath(textType, "알림 취소")).isDisplayed();
		
		Thread.sleep(3000);
		driver.findElementByXPath(makeXPath(textType, "닫기")).click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElements(By.xpath(makeXPath(textType, "새로 나온 사전예약 게임 알림을 취소합니다."))).size() == 0);
						
		result = "PASS";
	}
}