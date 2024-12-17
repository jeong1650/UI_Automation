package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_MYP_05840 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-15
	 * @ ExpectedResult = 마이페이지 > 설정 페이지 정상 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MYP_05840() throws Exception {
		TCID = "OSC700_04_설정_05840 설정";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();
				
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my_layout").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my").isSelected());
		
		downscroll(By.id("com.skt.skaf.A000Z00040:id/menu_setting")).click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_up_indicator").isDisplayed();
		assertEquals("설정", driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_title").getText());
		
		driver.findElementByXPath("//*[@text='업데이트']").isDisplayed();
		driver.findElementByXPath("//*[@text='업데이트 알림']").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/setting_update_noti_switch").isDisplayed();
		driver.findElementByXPath("//*[@text='자동 업데이트']").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_auto_update").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_auto_update_app").isDisplayed();
		driver.findElementByXPath("//*[@text='다운로드']").isDisplayed();
		driver.findElementByXPath("//*[@text='Wi-Fi에서만 다운로드']").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/setting_wifi_only_download_switch").isDisplayed();
		
		downscroll(By.xpath("//*[@text='동영상']"));
		downscroll(By.xpath("//*[@text='자동 재생']"));
		downscroll(By.id("com.skt.skaf.A000Z00040:id/btn_auto_play"));
		
		downscroll(By.xpath("//*[@text='잠금 설정']"));
		downscroll(By.xpath("//*[@text='로그인 잠금']"));
		downscroll(By.id("com.skt.skaf.A000Z00040:id/setting_security_login_lock_switch"));
				
		downscroll(By.xpath("//*[@text='혜택 수신 설정']"));
		downscroll(By.xpath("//*[@text='혜택 알림 수신 동의']"));
		downscroll(By.xpath("//*[@text='쿠폰, 할인, 캐쉬백, 특가행사 등 원스토어에서 제공하는 혜택과 새소식 수신에 동의합니다.']"));
		downscroll(By.id("com.skt.skaf.A000Z00040:id/setting_privacy_push_agree_switch"));
		downscroll(By.xpath("//*[@text='맞춤형 혜택 수신 동의']"));
		downscroll(By.xpath("//*[@text='더 유용한 맞춤형 혜택을 위해 개인 정보의 수집 및 이용과 알림 수신에 동의합니다.']"));
		downscroll(By.xpath("//*[@text='전문보기']"));
		downscroll(By.id("com.skt.skaf.A000Z00040:id/setting_privacy_personalized_push_agree_switch"));
		downscroll(By.xpath("//*[@text='앱 사용정보 접근 동의']"));
		downscroll(By.xpath("//*[@text='맞춤형 서비스 제공을 위해 원스토어가 앱 사용정보를 활용하는 것에 동의합니다.']"));
		downscroll(By.id("com.skt.skaf.A000Z00040:id/setting_privacy_app_use_approach_agreee_switch"));
				
		result = "PASS";
	}
}