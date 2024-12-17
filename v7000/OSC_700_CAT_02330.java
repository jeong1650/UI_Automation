package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_CAT_02330 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-08
	 * @ ExpectedResult = 쇼핑 상품 상세 > 문의하기 작성 팝업 > 문의 종류 선택 시 문의 종류 풀다운 메뉴 노출
	 * @ Editor = 
	 * @ EditDate = 2020-10-26
	 * @ 하단 플로팅 영역과 겹칠 시 동작 추가
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_CAT_02330() throws Exception {
		TCID = "OSC700_03_쇼핑_02330 문의종류 선택";
		result = "FAIL";
		size = driver.manage().window().getSize();

		popupCheck();

		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search_layout").click();

		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext");

		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("CU 1만원권");
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();

		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/search_result_item_shop_title").click();

		Thread.sleep(3000);
		downscroll(By.id("com.skt.skaf.A000Z00040:id/seller_info_contact_us_text_view")).click();
		
		Thread.sleep(3000);
		try {
			driver.findElementById("com.skt.skaf.A000Z00040:id/seller_info_contact_us_text_view").isDisplayed();		
			
			upSwipe(0.30);
			
			Thread.sleep(3000);
			driver.findElementById("com.skt.skaf.A000Z00040:id/seller_info_contact_us_text_view").click();
		
		} catch(Exception e) {}
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_up_indicator").isDisplayed();
		assertEquals("문의하기", driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_title").getText());
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/shopping_inquiry_selector_question").click();
		
		Thread.sleep(3000);
		driver.findElementByXPath("//android.widget.CheckBox[@text='구매내역문의']").isDisplayed();
		driver.findElementByXPath("//android.widget.CheckBox[@text='결제/취소방법']").isDisplayed();
		driver.findElementByXPath("//android.widget.CheckBox[@text='배송/교환/반품문의']").isDisplayed();
		driver.findElementByXPath("//android.widget.CheckBox[@text='구매오류']").isDisplayed();
		driver.findElementByXPath("//android.widget.CheckBox[@text='이용방법문의']").isDisplayed();
		driver.findElementByXPath("//android.widget.CheckBox[@text='판매사문의']").isDisplayed();
		driver.findElementByXPath("//android.widget.CheckBox[@text='기타']").isDisplayed();
		
		driver.findElementByXPath("//android.widget.CheckBox[@text='기타']").click();
		
		Thread.sleep(3000);
		assertEquals("기타", driver.findElementById("com.skt.skaf.A000Z00040:id/shopping_inquiry_selector_question").getText());
						
		result = "PASS";

	}
}