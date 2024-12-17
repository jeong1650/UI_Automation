package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_CAT_02770 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-09
	 * @ ExpectedResult = 쇼핑 상품권 / 교환권 상품 상세 > 유의사항 및 이용안내 영역 선택 시 이용안내 팝업 노출
	 * @ Editor = 
	 * @ EditDate = 2020-10-13
	 * @ 상품 변경
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_CAT_02770() throws Exception {
		TCID = "OSC700_03_쇼핑_02770 유의사항 및 이용안내 영역 선택";
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
		assertEquals("유의사항", downscroll(By.id("com.skt.skaf.A000Z00040:id/notice_title")).getText());
		driver.findElementById("com.skt.skaf.A000Z00040:id/notice_contents").isDisplayed();
		
		assertEquals("이용안내", downscroll(By.id("com.skt.skaf.A000Z00040:id/info_title")).getText());
		assertEquals("상품 구매 후 마이 내 구매내역에서 e쿠폰을 확인할 수 있습니다. 매장 또는 사이트 방문시 제시하시면 구매하신 상품으로 교환하실 수 있습니다.", 
				downscroll(By.id("com.skt.skaf.A000Z00040:id/info_contents")).getText());
		
		assertEquals("닫기", downscroll(By.id("com.skt.skaf.A000Z00040:id/btn2")).getText());
		
		Click("com.skt.skaf.A000Z00040:id/btn2");
		
		Thread.sleep(3000);
		assertTrue(driver.findElements(By.id("com.skt.skaf.A000Z00040:id/btn2")).size() == 0);
				
		result = "PASS";

	}
}