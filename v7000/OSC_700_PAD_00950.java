package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_PAD_00950 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-10-14
	 * @ ExpectedResult = 쇼핑 배송 상품 배송지 입력 페이지 > 배송지 검색 결과 존재시 
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_PAD_00950() throws Exception {
		TCID = "OSC700_06_쇼핑_00950 검색 결과 목록 영역 확인(검색 결과가 있는 경우)";
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
		driver.findElementByXPath("//*[@resource-id='sch_zip']").sendKeys("분당내곡로 117");
		
		Thread.sleep(3000);
		driver.findElementByXPath("//*[@resource-id='btn_search']").click();
		
		Thread.sleep(3000);
		driver.findElementByXPath("//*[contains(@text, '배송지 입력')]").isDisplayed();
		driver.findElementByXPath("//*[@text='우편번호']").isDisplayed();
		driver.findElementByXPath("//*[@text='주소']").isDisplayed();
		driver.findElementByXPath("//*[@text='13529']").isDisplayed();
		driver.findElementByXPath("//*[@text='경기도 성남시 분당구 분당내곡로 117 (백현동, 크래프톤타워)']").isDisplayed();
		driver.findElementByXPath("//*[@text='경기도 성남시 분당구 백현동 535 (크래프톤타워)']").isDisplayed();
		
		assertTrue(driver.findElements(By.xpath("//*[@text='더보기']")).size() == 0);
		
		driver.findElementByXPath("//*[@text='뒤로']").isDisplayed();
				
		result = "PASS";
	}
}