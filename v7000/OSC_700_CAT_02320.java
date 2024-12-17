package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_CAT_02320 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-08
	 * @ ExpectedResult = 쇼핑 상품 상세 > [문의하기] 선택 시 문의하기 작성 팝업 노출
	 * @ Editor = 
	 * @ EditDate = 2020-10-28
	 * @ 하단 플로팅 영역과 겹칠 시 동작 추가 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_CAT_02320() throws Exception {
		TCID = "OSC700_03_쇼핑_02320 [확인] 선택";
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
			driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_title").isDisplayed();			
		} catch(Exception e) {
			Thread.sleep(3000);
			upSwipe(0.50);
			
			Thread.sleep(3000);
			driver.findElementById("com.skt.skaf.A000Z00040:id/seller_info_contact_us_text_view").click();
		}
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_up_indicator").isDisplayed();
		assertEquals("문의하기", driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_title").getText());
		
		driver.findElementByXPath("//*[@text='판매자에게 직접 문의하실 수 있습니다. 답변을 받으실 이메일 정보를 입력하여 주세요.']").isDisplayed();
		
		driver.findElementByXPath("//*[@text='등록일']").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/shopping_inquiry_register_day").isDisplayed();
		
		driver.findElementByXPath("//*[@text='문의 종류']").isDisplayed();
		assertEquals("문의 종류 선택", driver.findElementById("com.skt.skaf.A000Z00040:id/shopping_inquiry_selector_question").getText());
				
		driver.findElementByXPath("//*[@text='이메일']").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/shopping_inquiry_email").isDisplayed();
		
		driver.findElementByXPath("//*[@text='제목']").isDisplayed();
		assertEquals("제목을 입력해 주세요.", driver.findElementById("com.skt.skaf.A000Z00040:id/shopping_inquiry_title").getText());
		
		driver.findElementByXPath("//*[@text='내용']").isDisplayed();
		assertEquals("문의 내용을 입력해 주세요.", driver.findElementById("com.skt.skaf.A000Z00040:id/shopping_inquiry_contents").getText());
		
		assertEquals("취소", driver.findElementById("com.skt.skaf.A000Z00040:id/shopping_inquiry_cancel_button").getText());
		assertEquals("확인", driver.findElementById("com.skt.skaf.A000Z00040:id/shopping_inquiry_confirm_button").getText());
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/shopping_inquiry_cancel_button").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElements(By.id("com.skt.skaf.A000Z00040:id/shopping_inquiry_cancel_button")).size() == 0);
		
		result = "PASS";

	}
}