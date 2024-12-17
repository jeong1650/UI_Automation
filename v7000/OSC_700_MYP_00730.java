package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;

public class OSC_700_MYP_00730 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-10
	 * @ ExpectedResult = 마이페이지 > 게임 캐쉬 > 적립 / 사용내역 없는 경우 정상 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MYP_00540() throws Exception {
		TCID = "OSC700_04_MY_00730 적립내역/사용내역 탭 (적립내역/사용내역이 없는 경우)";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();

		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my_layout").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my").isSelected());
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/menu_game_cash").click();
		
		Thread.sleep(3000);
		driver.findElementByXPath("//*[contains(@text, '게임 캐쉬')]").isDisplayed();
		
		driver.findElementByXPath("//*[@text='사용 가능 캐쉬']").isDisplayed();
		driver.findElementByXPath("//*[contains(@text, '1주일 내 소멸예정 캐쉬')]").isDisplayed();
		driver.findElementByXPath("//*[contains(@text, '충전 또는 혜택으로 지급된 캐쉬가 합산 표기됩니다.')]").isDisplayed();
		
		driver.findElementByXPath("//*[@text='캐쉬 변동 내역']").isDisplayed();

		driver.findElementByXPath("//*[@text='기간선택']").isDisplayed();
		
		driver.findElementByXPath("//*[@text='적립내역']").isDisplayed();
		driver.findElementByXPath("//*[@text='사용내역']").isDisplayed();
		
		driver.findElementByXPath("//*[@text='적립내역']").click();
		
		Thread.sleep(3000);		
		driver.findElementByXPath("//*[@text='일자']").isDisplayed();
		driver.findElementByXPath("//*[@text='유효기간']").isDisplayed();
		driver.findElementByXPath("//*[@text='변동내역']").isDisplayed();
		
		driver.findElementByXPath("//*[@text='기간 내 내역이 없습니다.']").isDisplayed();
		
		driver.findElementByXPath("//*[@text='사용내역']").click();
		
		Thread.sleep(3000);		
		driver.findElementByXPath("//*[@text='일자']").isDisplayed();
		driver.findElementByXPath("//*[@text='변동내역']").isDisplayed();
		
		driver.findElementByXPath("//*[@text='기간 내 내역이 없습니다.']").isDisplayed();
						
		result = "PASS";

	}
}