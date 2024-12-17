package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_CAT_02230 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-08
	 * @ ExpectedResult = 쇼핑 배송상품 상세 > 리뷰 페이지 > 정렬 영역 정상 동작
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_CAT_02230() throws Exception {
		TCID = "OSC700_03_쇼핑_02230 [▼] 선택";
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
		downscroll(By.id("com.skt.skaf.A000Z00040:id/lay_more"));
		driver.findElementByXPath("//android.widget.TextView[@text='모든 리뷰 보기']").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/text_review_count").isDisplayed();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/lay_more").click();
		
		try {
			driver.findElementById("com.skt.skaf.A000Z00040:id/shopping_option_selected_item").isDisplayed();
			
			driver.navigate().back();
			
			Thread.sleep(3000);
			upSwipe(0.30);
			
			Thread.sleep(3000);
			driver.findElementById("com.skt.skaf.A000Z00040:id/lay_more").click();
		} catch(Exception e) {}
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_up_indicator").isDisplayed();
		assertEquals("리뷰", driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_title").getText().substring(0, 2));
		assertEquals("전체", driver.findElementById("com.skt.skaf.A000Z00040:id/radio_all").getText());
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/text_order").click();
		
		Thread.sleep(3000);
		if(driver.findElementByXPath("//android.widget.CheckBox[@text='신뢰도순']").getAttribute("checked").equals("true")) {
			Thread.sleep(3000);
			driver.navigate().back();
		} else {
			driver.findElementByXPath("//android.widget.CheckBox[@text='신뢰도순']").click();
		}
		
		Thread.sleep(3000);
		assertEquals("신뢰도순", driver.findElementById("com.skt.skaf.A000Z00040:id/text_order").getText());
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/text_order").click();
		
		driver.findElementByXPath("//android.widget.CheckBox[@text='최신순']").click();
		
		Thread.sleep(3000);
		assertEquals("최신순", driver.findElementById("com.skt.skaf.A000Z00040:id/text_order").getText());
		
		result = "PASS";

	}
}