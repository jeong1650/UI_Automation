package osc.v7000;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_CAT_00150 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-03
	 * @ ExpectedResult = 단품 무료 상품이며, 외부결제를 지원하는 게임 / 앱 상품 상세 > 외부결제 더 보기 선택 시 팝업 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_CAT_00150() throws Exception {
		TCID = "OSC700_03_APP_00150 외부결제 더보기(>) 선택 (단품 무료 상품이며, 외부결제를 지원)";
		result = "FAIL";
		size = driver.manage().window().getSize();

		popupCheck();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search_layout").click();
		
		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext");
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("토닥토닥(영유아 스마트폰 관리앱)");
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();
		
		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/search_result_item_app_title");
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/main_info_image_view").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/main_info_product_name_text_view").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/main_info_seller_name_text_view").isDisplayed();
		assertEquals("무료", driver.findElementById("com.skt.skaf.A000Z00040:id/main_info_price_text_view").getText());
		assertEquals("인앱구매", driver.findElementById("com.skt.skaf.A000Z00040:id/main_info_iab_text_view").getText());
		driver.findElementById("com.skt.skaf.A000Z00040:id/main_info_external_payment_layout").isDisplayed();
		driver.findElementByXPath("//android.widget.TextView[@text='외부결제']").isDisplayed();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/main_info_external_payment_layout").click();
		
		Thread.sleep(3000);
		assertEquals("외부결제 안내", driver.findElementById("com.skt.skaf.A000Z00040:id/title").getText());
		assertEquals("외부결제란 원스토어 인앱결제 대신 판매자가 제공하는 결제수단을 이용하여 구매하는 방식이며, 쿠폰이나 이벤트 등 원스토어 혜택 대상이 아닙니다.\n" + 
				"\n" + 
				"외부결제 상품의 구매 및 결제에 대해 궁금하신 점은 판매자에게 직접 문의해 주세요.", driver.findElementById("com.skt.skaf.A000Z00040:id/contents").getText());
		assertEquals("닫기", driver.findElementById("com.skt.skaf.A000Z00040:id/btn2").getText());
		
		Click("com.skt.skaf.A000Z00040:id/btn2");
		
		Thread.sleep(3000);
		assertTrue(driver.findElements(By.id("com.skt.skaf.A000Z00040:id/title")).size() == 0);
		
		result = "PASS";

	}
}