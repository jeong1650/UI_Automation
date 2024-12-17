package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_CAT_02750 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-09
	 * @ ExpectedResult = 쇼핑 상품권 / 교환권 상품 상세 > 유의사항 및 이용안내 영역 정상 노출
	 * @ Editor = 
	 * @ EditDate = 2020-10-28
	 * @ 하단 플로팅 영역과 겹칠시 동작 추가
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_CAT_02750() throws Exception {
		TCID = "OSC700_03_쇼핑_02750 유의사항 및 이용안내 영역 확인 (단수 판매처)";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();

		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search_layout").click();

		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext");

		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("아이스 카페 아메리카노 Tall");
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();

		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/search_result_item_shop_title").click();

		Thread.sleep(3000);
		assertEquals("유의사항 및 이용안내", downscroll(By.id("com.skt.skaf.A000Z00040:id/notice_usage_guide_single_title")).getText());
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/notice_usage_guide_single_title").click();
		
		Thread.sleep(3000);
		try {
			driver.findElementById("com.skt.skaf.A000Z00040:id/notice_title").isDisplayed();
		} catch(Exception e) {
			upSwipe(0.30);
			
			Thread.sleep(3000);
			driver.findElementById("com.skt.skaf.A000Z00040:id/notice_usage_guide_single_title").click();
		}
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/notice_title").isDisplayed();
		
		result = "PASS";

	}
}