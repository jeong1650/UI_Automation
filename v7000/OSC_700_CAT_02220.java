package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_CAT_02220 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-10-19
	 * @ ExpectedResult = 쇼핑 배송상품 상세 > [모든 리뷰 보기] > 필터 영역 정상 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_CAT_02200() throws Exception {
		TCID = "OSC700_03_쇼핑_02200 [모든 리뷰 보기 xxx>] 선택";
		result = "FAIL";
		size = driver.manage().window().getSize();

		popupCheck();

		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search_layout").click();

		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext");

		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("SWITCH 링 피트 어드벤처*");
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();

		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/search_result_item_shop_title").click();

		Thread.sleep(3000);
		downscroll(By.xpath("//*[@text='모든 리뷰 보기']")).click();
		
		try { // 모든 리뷰 보기 버튼이 구매 버튼과 겹칠 시
			Thread.sleep(3000);
			driver.findElementById("com.skt.skaf.A000Z00040:id/shopping_option_count").isDisplayed();
			
			Thread.sleep(3000);
			upSwipe(0.50);
			
			Thread.sleep(3000);
			driver.findElementByXPath("//*[@text='모든 리뷰 보기']").click();
		} catch(Exception e) {}
				
		Thread.sleep(3000);
		assertEquals("전체", driver.findElementById("com.skt.skaf.A000Z00040:id/radio_all").getText());
		assertEquals("긍정적", driver.findElementById("com.skt.skaf.A000Z00040:id/radio_affirm").getText());
		assertEquals("부정적", driver.findElementById("com.skt.skaf.A000Z00040:id/radio_deny").getText());
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/radio_affirm").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/radio_affirm").getAttribute("checked").equals("true"));
		
		String review = driver.findElementById("com.skt.skaf.A000Z00040:id/text_desc").getText();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/radio_deny").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/radio_deny").getAttribute("checked").equals("true"));
		
		assertNotEquals(review, driver.findElementById("com.skt.skaf.A000Z00040:id/text_desc").getText());
								
		result = "PASS";

	}
}