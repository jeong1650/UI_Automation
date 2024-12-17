package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_PAD_01040 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-22
	 * @ ExpectedResult = 쇼핑 배송 상품 배송지 입력 페이지 > 최근 배송지 > 없을 시 화면 정상 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_PAD_01040() throws Exception {
		TCID = "OSC700_06_쇼핑_01040 [○ 최근 배송지] 선택(최근 배송지가 없는 경우)";
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
		driver.findElementByXPath("//*[@text='최근 배송지']").click();
		
		Thread.sleep(5000);
		driver.findElementByXPath("//*[contains(@text, '최근 배송지')]").isDisplayed();
		driver.findElementByXPath("//*[@text='최근 배송지가 없습니다.']").isDisplayed();
		driver.findElementByXPath("//*[@text='뒤로']").isDisplayed();
		
		driver.findElementByXPath("//*[@text='뒤로']").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElements(By.xpath("//*[@text='최근 배송지가 없습니다.']")).size() == 0);
								
		result = "PASS";
	}
}