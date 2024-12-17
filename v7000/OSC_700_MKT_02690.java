package osc.v7000;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_MKT_02690 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-22
	 * @ ExpectedResult = 모든게임 예약 완료 시 팝업 노출
	 * @ Editor = 
	 * @ EditDate = 2020-10-28 
	 * @ 불필요 코드 삭제
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MKT_02690() throws Exception {
		TCID = "OSC700_08_마케팅_02690 [동의하고 예약 신청] 선택";
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
		
		Thread.sleep(3000);
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
		
		Thread.sleep(5000);
		try {
			driver.findElementByXPath(makeXPath(textType, "모든 게임 사전예약이 신청되었습니다.\n" + 
					"자동설치가 지원되는 게임이 출시되면 자동설치할까요?")).isDisplayed();
		} catch(Exception e) {
			driver.findElementByXPath(makeXPath(textType, "모든 게임 사전예약이 신청되었습니다.")).isDisplayed();
			driver.findElementByXPath(makeXPath(textType, "자동설치가 지원되는 게임이 출시되면 자동설치할까요?")).isDisplayed();
		}
		
		driver.findElementByXPath(makeXPath(textType, "취소")).isDisplayed();
		driver.findElementByXPath(makeXPath(textType, "자동설치")).isDisplayed();
		
		driver.findElementByXPath(makeXPath(textType, "취소")).click();
		
		Thread.sleep(3000);
		driver.findElementByXPath(makeXPath(textType, "닫기")).click();
		
		
		result = "PASS";
	}
}