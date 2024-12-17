package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_CAT_02510 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-08
	 * @ ExpectedResult = 구매옵션 2개 제공 쇼핑 상품 상세 > 하단 플로팅 영역 정상 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_CAT_02510() throws Exception {
		TCID = "OSC700_03_쇼핑_02510 구매 옵션 선택 (옵션 2를 선택 하지 않은 경우, 옵션을 선택하지 않으면 구매할 수 없는 경우)";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();

		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search_layout").click();

		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext");

		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("빨아쓰는 호텔토퍼");
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();

		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/search_result_item_shop_title").click();

		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/shopping_option_purchase").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/shopping_detail_option_item_name").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElements(By.id("com.skt.skaf.A000Z00040:id/shopping_option_count")).size() == 0);
		assertTrue(driver.findElements(By.id("com.skt.skaf.A000Z00040:id/shopping_option_price")).size() == 0);
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/shopping_detail_option_item_name").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/shopping_option_count").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/shopping_option_price").isDisplayed();
		
		result = "PASS";

	}
}