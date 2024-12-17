package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_CAT_02200 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-10-19
	 * @ ExpectedResult = 쇼핑 배송상품 상세 > [모든 리뷰 보기] 선택 시 모든 리뷰 화면 노출
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
		String cntRev = downscroll(By.id("com.skt.skaf.A000Z00040:id/text_review_count")).getText();
		downscroll(By.xpath("//*[@text='모든 리뷰 보기']")).click();
		
		try {
			Thread.sleep(3000);
			driver.findElementById("com.skt.skaf.A000Z00040:id/shopping_option_count").isDisplayed();
			
			Thread.sleep(3000);
			upSwipe(0.50);
			
			Thread.sleep(3000);
			driver.findElementByXPath("//*[@text='모든 리뷰 보기']").click();
		} catch(Exception e) {}
				
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_up_indicator").isDisplayed();
		assertEquals("리뷰 " + cntRev, driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_title").getText());
		
		assertEquals("전체", driver.findElementById("com.skt.skaf.A000Z00040:id/radio_all").getText());
		assertEquals("긍정적", driver.findElementById("com.skt.skaf.A000Z00040:id/radio_affirm").getText());
		assertEquals("부정적", driver.findElementById("com.skt.skaf.A000Z00040:id/radio_deny").getText());
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/lay_sort").isDisplayed();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/text_userid").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/text_desc").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/text_date").isDisplayed();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_up_indicator").click();
		
		Thread.sleep(3000);
		driver.findElementByXPath("//*[@text='모든 리뷰 보기']").isDisplayed();
						
		result = "PASS";

	}
}