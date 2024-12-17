package osc.v7000;

import org.junit.Test;

public class OSC_700_PAD_00940 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-10-14
	 * @ ExpectedResult = 쇼핑 배송 상품 배송지 입력 페이지 > 배송지 검색 결과 없을 시 안내문구 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_PAD_00940() throws Exception {
		TCID = "OSC700_06_쇼핑_00940 검색 결과 목록 영역 확인(검색 결과가 없는 경우)";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();
				
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search").click();

		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext");
		
		try {
			driver.findElementById("com.skt.skaf.A000Z00040:id/search_history_all_delete").click();
		} catch (Exception e) {}
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("고속 충전 USB C타입 PD 보조배터리 10000mAh A10D");
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/search_result_item_shop_title").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/shopping_option_purchase").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/shopping_option_purchase").click();
		
		Thread.sleep(3000);
		driver.findElementByXPath("//*[@text='우편번호 찾기']").click();
		
		Thread.sleep(3000);
		driver.findElementByXPath("//*[@resource-id='sch_zip']").sendKeys("케로로");
		
		Thread.sleep(3000);
		driver.findElementByXPath("//*[@resource-id='btn_search']").click();
		
		Thread.sleep(3000);
		driver.findElementByXPath("//*[contains(@text, '배송지 입력')]").isDisplayed();
		driver.findElementByXPath("//*[@text='주소명 검색방법']").isDisplayed();
		driver.findElementByXPath("//*[@text='동 + 건물명 입력: 예) ‘충무로1가(동명) 중앙우체국(건물명)’']").isDisplayed();
		driver.findElementByXPath("//*[@text='도로명+건물번호 입력: 예) ‘소공로(도로명) 70(건물번호)’']").isDisplayed();
		driver.findElementByXPath("//*[@text='건물명 입력: 예) ‘중앙우체국(건물명)']").isDisplayed();
		driver.findElementByXPath("//*[@text='우편번호']").isDisplayed();
		driver.findElementByXPath("//*[@text='주소']").isDisplayed();
		driver.findElementByXPath("//*[@text='검색 결과가 없습니다.']").isDisplayed();
		driver.findElementByXPath("//*[@text='뒤로']").isDisplayed();
		
		result = "PASS";
	}
}