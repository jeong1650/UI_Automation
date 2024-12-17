package osc.v7000;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_MKT_00480 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-10-15
	 * @ ExpectedResult = 혜택 수신 미 동의자  > 혜택 > [혜택 알림 받아 보기] 선택 > 동의 시 동의 처리 결과 팝업 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MKT_00480() throws Exception {
		TCID = "OSC700_08_마케팅_00480 혜택 수신 동의 팝업 내 [확인] 선택 (혜택 수신 미동의자인 경우)";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();

		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my_layout").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my").isSelected());
		
		downscroll(By.id("com.skt.skaf.A000Z00040:id/menu_setting")).click();
		
		if(downscroll(By.id("com.skt.skaf.A000Z00040:id/setting_privacy_push_agree_switch")).getAttribute("checked").equals("true")) {
			driver.findElementById("com.skt.skaf.A000Z00040:id/setting_privacy_push_agree_switch").click();
			
			Thread.sleep(3000);
			Click("com.skt.skaf.A000Z00040:id/btn2");
			
			Thread.sleep(3000);
			Click("com.skt.skaf.A000Z00040:id/btn2");
		}	
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_up_indicator").click();
				
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_benefit").click();
		
		try {
			Thread.sleep(3000);
			driver.findElementByXPath("//*[@text='혜택 알림 받아보기']").click();

			Thread.sleep(3000);
			driver.findElementByXPath("//*[@text='놓치지 말자! 혜택 알림']").isDisplayed();
			driver.findElementByXPath("//*[@text='원스토어가 드리는 캐쉬백, 특가 상품, 맞춤 쿠폰 등 혜택과 새소식을 알려드릴게요.']").isDisplayed();
			driver.findElementByXPath("//*[@text='동의안함']").isDisplayed();
			driver.findElementByXPath("//*[@text='동의']").isDisplayed();

			Thread.sleep(3000);
			driver.findElementByXPath("//*[@text='동의']").click();

			Thread.sleep(3000);
			driver.findElementByXPath("//*[@text='다음과 같이 알림 수신이 동의 처리되었습니다.\n" + 
					"전송자 : 원스토어\n" + 
					"동의일자 : " + Calendar.getInstance().get(Calendar.YEAR) + "년 "
					+ String.format("%d", Calendar.getInstance().get(Calendar.MONTH) + 1) + "월 "
					+ String.format("%d", Calendar.getInstance().get(Calendar.DAY_OF_MONTH)) + "일']").isDisplayed();
			driver.findElementByXPath("//*[@text='확인']").isDisplayed();

			driver.findElementByXPath("//*[@text='확인']").click();

			Thread.sleep(3000);
			assertTrue(driver.findElements(By.xpath("//*[@text='혜택 알림 받아보기']")).size() == 0);
		} catch (Exception e) {
			Thread.sleep(3000);
			driver.findElementByXPath("//*[@content-desc='혜택 알림 받아보기']").click();
			
			Thread.sleep(3000);
			driver.findElementByXPath("//*[@content-desc='놓치지 말자! 혜택 알림']").isDisplayed();
			driver.findElementByXPath("//*[@content-desc='원스토어가 드리는 캐쉬백, 특가 상품, 맞춤 쿠폰 등 혜택과 새소식을 알려드릴게요.']").isDisplayed();
			driver.findElementByXPath("//*[@content-desc='동의안함']").isDisplayed();
			driver.findElementByXPath("//*[@content-desc='동의']").isDisplayed();
			
			Thread.sleep(3000);
			driver.findElementByXPath("//*[@content-desc='동의']").click();
			
			Thread.sleep(3000);
			driver.findElementByXPath("//*[@content-desc='다음과 같이 알림 수신이 동의 처리되었습니다.']").isDisplayed();
			driver.findElementByXPath("//*[@content-desc='전송자 : 원스토어']").isDisplayed();
			driver.findElementByXPath("//*[@content-desc='다음과 같이 알림 수신이 동의 처리되었습니다.']").isDisplayed();
			driver.findElementByXPath("//*[@content-desc='"
					+ "동의일자 : " + Calendar.getInstance().get(Calendar.YEAR) + "년 "
					+ String.format("%d", Calendar.getInstance().get(Calendar.MONTH) + 1) + "월 "
					+ String.format("%d", Calendar.getInstance().get(Calendar.DAY_OF_MONTH)) + "일']").isDisplayed();
			driver.findElementByXPath("//*[@content-desc='확인']").click();	
							
			Thread.sleep(3000);		
			assertTrue(driver.findElements(By.xpath("//*[@content-desc='혜택 알림 받아보기']")).size() == 0);
		}
		result = "PASS";

	}
}