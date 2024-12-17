package osc.v7000;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_MKT_02590 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-10-15
	 * @ ExpectedResult = 사전예약 > 14세 이상 / 성인 미인증 > [동의하고 예약 신청] > [자동설치] > [성인인증하러 가기] 선택 시 성인인증 화면 노출
	 * @ Editor = 
	 * @ EditDate = 2020-10-20
	 * @ 문구 수정
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MKT_02590() throws Exception {
		TCID = "OSC700_08_마케팅_02590 [성인인증하러 가기] 선택 (14세 이상 회원인 경우, 성인 미인증 상태)";
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
		} catch (Exception e) {
		}
		
		Thread.sleep(3000);
		driver.findElementByXPath(makeXPath(textType, "동의하고 예약")).click();
		
		Thread.sleep(2000);
		driver.findElementByXPath(makeXPath(textType, "자동설치")).click();

		Thread.sleep(2000);
		driver.findElementByXPath(makeXPath(textType, "성인인증하러 가기")).click();
		
		Thread.sleep(3000);
		driver.findElementByXPath(makeXPath(textType, "본인확인")).isDisplayed();
		driver.findElementByXPath(makeXPath(textType, "서비스 이용을 위해\n" + "본인확인이 필요합니다.")).isDisplayed();
		driver.findElementByXPath(makeXPath(textType, "본 정보는 청소년유해매체물로서 정보통신망 이용 촉진 및 정보 보호 등에 관한 법률 및 청소년 보호법의 규정에 의하여 만 18세 미만의 청소년이 이용할 수 없습니다.")).isDisplayed();
		driver.findElementByXPath(makeXPath(textType, "성인인증정보는 1년간 유효합니다.")).isDisplayed();
		
		try {
			driver.findElementByXPath(makeXPath(textType, "개인정보 수집 및 이용에 동의합니다. 전문보기")).isDisplayed();
		} catch (Exception e) {
			driver.findElementByXPath(makeXPath(textType, "개인정보 수집 및 이용에 동의합니다.")).isDisplayed();
			driver.findElementByXPath(makeXPath(textType, "전문보기")).isDisplayed();
		}
		
		driver.findElementByXPath(makeXPath(textType, "휴대폰 본인확인")).isDisplayed();
		driver.findElementByXPath(makeXPath(textType, "본인명의의 휴대폰을 이용한 인증입니다.")).isDisplayed();
		downscroll(By.xpath(makeXPath(textType, "아이핀 본인확인")));
		downscroll(By.xpath(makeXPath(textType, "아이핀 계정을 통한 인증입니다.")));
		downscroll(By.xpath(makeXPath(textType, "카드 본인확인")));
		downscroll(By.xpath(makeXPath(textType, "본인명의의 신용카드나 체크카드를 이용한 인증입니다.")));
						
		result = "PASS";
	}
}