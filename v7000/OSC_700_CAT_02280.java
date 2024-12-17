package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_CAT_02280 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-08
	 * @ ExpectedResult = 쇼핑 상품 상세 > 연관상품 타이틀 선택 시 연관상품 리스트 화면 이동
	 * @ Editor = 
	 * @ EditDate = 2020-10-13
	 * @ 상품 변경
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_CAT_02280() throws Exception {
		TCID = "OSC700_03_쇼핑_02280 연관상품 타이틀 선택";
		result = "FAIL";
		size = driver.manage().window().getSize();

		popupCheck();

		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search_layout").click();

		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext");

		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("아이스 카페아메리카노 Tall");
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();

		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/search_result_item_shop_title").click();

		Thread.sleep(3000);
		upSwipe(0.80);
		upSwipe(0.80);
		upSwipe(0.80);
		upSwipe(0.80);
		
		Thread.sleep(3000);
		upscroll(By.xpath("//*[@text='교환권  인기 상품']")).click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_up_indicator").isDisplayed();
		assertEquals("교환권  인기 상품", driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_title").getText());
		driver.findElementById("com.skt.skaf.A000Z00040:id/action_landing_search").isDisplayed();
		assertEquals("쇼핑 상품 더보기", driver.findElementById("com.skt.skaf.A000Z00040:id/shopping_more").getText());
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/item_touch").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/thumbnail").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/seller").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/title").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/price").isDisplayed();
		
		String prodName = driver.findElementById("com.skt.skaf.A000Z00040:id/title").getText();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/title").click();
		
		Thread.sleep(3000);
		assertEquals(prodName, driver.findElementById("com.skt.skaf.A000Z00040:id/main_info_title").getText());
		driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_up_indicator").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/shopping_more").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_up_indicator").click();
				
		Thread.sleep(3000);
		assertTrue(driver.findElements(By.id("com.skt.skaf.A000Z00040:id/shopping_more")).size() == 0);
						
		result = "PASS";

	}
}