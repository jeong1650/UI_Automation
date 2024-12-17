package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_MEM_01950 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-10-16
	 * @ ExpectedResult = 마이페이지 > 설정 > 잠금 비밀번호 설정 > 최초 설정 시 본인인증 화면 노출
	 * @ Editor = 
	 * @ EditDate = 2020-10-20
	 * @ 문구 수정
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MEM_01950() throws Exception {
		TCID = "OSC700_07_회원_01950 잠금 비밀번호 초기화(PIN 5회 실패하지 않은 경우,PIN 설정되지 않은 경우)";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();

		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my_layout").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my").isSelected());
		
		downscroll(By.id("com.skt.skaf.A000Z00040:id/menu_setting")).click();
		
		Thread.sleep(3000);
		downscroll(By.xpath("//*[@text='잠금 비밀번호 등록']")).click();
		
		Thread.sleep(5000);
		try {
			try {
				driver.findElementByXPath("//*[@text='본인확인']").isDisplayed();
			} catch (Exception e) {
				driver.findElementByXPath("//*[@text='본인확인 ']").isDisplayed();
			}

			driver.findElementByXPath("//*[@text='서비스 이용을 위해 본인확인이 필요합니다.\n" + "아래 인증 수단 중 한가지 방법으로 본인인증을 진행해주세요.']").isDisplayed();

			driver.findElementByXPath("//*[contains(@text, '개인정보 수집 및 이용에 동의합니다.')]").isDisplayed();
			driver.findElementByXPath("//*[contains(@text, '전문보기')]").isDisplayed();

			driver.findElementByXPath("//*[@text='휴대폰 본인확인']").isDisplayed();
			driver.findElementByXPath("//*[@text='본인명의의 휴대폰을 이용한 인증입니다.']").isDisplayed();

			driver.findElementByXPath("//*[@text='아이핀 본인확인']").isDisplayed();
			driver.findElementByXPath("//*[@text='아이핀 계정을 통한 인증입니다.']").isDisplayed();

			driver.findElementByXPath("//*[@text='카드 본인확인']").isDisplayed();
			driver.findElementByXPath("//*[@text='본인명의의 신용카드나 체크카드를 이용한 인증입니다.']").isDisplayed();
		} catch (Exception te) {
			try {
				driver.findElementByXPath("//*[@content-desc='본인확인']").isDisplayed();
			} catch (Exception e) {
				driver.findElementByXPath("//*[@content-desc='본인확인 ']").isDisplayed();
			}
			driver.findElementByXPath("//*[@content-desc='서비스 이용을 위해 본인확인이 필요합니다.']").isDisplayed();
			driver.findElementByXPath("//*[@content-desc='아래 인증 수단 중 한가지 방법으로 본인인증을 진행해주세요.']").isDisplayed();

			driver.findElementByXPath("//*[contains(@content-desc, '개인정보 수집 및 이용에 동의합니다.')]").isDisplayed();
			driver.findElementByXPath("//*[contains(@content-desc, '전문보기')]").isDisplayed();

			driver.findElementByXPath("//*[@content-desc='휴대폰 본인확인']").isDisplayed();
			driver.findElementByXPath("//*[@content-desc='본인명의의 휴대폰을 이용한 인증입니다.']").isDisplayed();

			driver.findElementByXPath("//*[@content-desc='아이핀 본인확인']").isDisplayed();
			driver.findElementByXPath("//*[@content-desc='아이핀 계정을 통한 인증입니다.']").isDisplayed();

			driver.findElementByXPath("//*[@content-desc='카드 본인확인']").isDisplayed();
			driver.findElementByXPath("//*[@content-desc='본인명의의 신용카드나 체크카드를 이용한 인증입니다.']").isDisplayed();
		}
																						
		result = "PASS";

	}
}