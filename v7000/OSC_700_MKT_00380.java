package osc.v7000;

import org.junit.Test;

public class OSC_700_MKT_00380 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-22
	 * @ ExpectedResult = 메인 > 혜택 패널 정상 이동
	 * @ Editor = 
	 * @ EditDate = 2020-10-20
	 * @ 인식 불가로  카드 확인 부분 삭제
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MKT_00380() throws Exception {
		TCID = "OSC700_08_마케팅_00380 혜택 패널 선택";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();
				
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_benefit").click();

		Thread.sleep(3000);
		try {
			driver.findElementByXPath("//*[@text='날마다 혜택체크']").isDisplayed();
			driver.findElementByXPath("//*[@text='쿠폰/캐쉬 등록']").isDisplayed();
			driver.findElementByXPath("//*[contains(@text, '원스토어 혜택 활용 꿀팁')]").isDisplayed();
		} catch (Exception e) {
			driver.findElementByXPath("//*[@content-desc='날마다 혜택체크']").isDisplayed();
			driver.findElementByXPath("//*[@content-desc='쿠폰/캐쉬 등록']").isDisplayed();
			driver.findElementByXPath("//*[contains(@content-desc, '원스토어 혜택 활용 꿀팁')]").isDisplayed();
		}
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_game").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_app_life").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/lottie_benefit2").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my").isDisplayed();
		
		result = "PASS";
	}
}