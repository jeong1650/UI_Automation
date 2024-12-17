package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_CAT_01950 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-08
	 * @ ExpectedResult = 쇼핑 배송상품 상세 > 유의사항 및 이용안내 팝업 정상 노출
	 * @ Editor = 
	 * @ EditDate = 2020-10-20
	 * @ 상품 변경
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_CAT_01950() throws Exception {
		TCID = "OSC700_03_쇼핑_01950 유의사항 및 이용안내 영역 선택 (배송상품)";
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
		assertEquals("유의사항 및 이용안내", downscroll(By.id("com.skt.skaf.A000Z00040:id/notice_usage_guide_single_title")).getText());
		driver.findElementById("com.skt.skaf.A000Z00040:id/notice_usage_guide_single_title").click();
		
		Thread.sleep(3000);
		try {
			driver.findElementById("com.skt.skaf.A000Z00040:id/notice_title").isDisplayed();
		} catch(Exception e) {
			Thread.sleep(3000);
			upSwipe(0.50);
			
			Thread.sleep(3000);
			driver.findElementById("com.skt.skaf.A000Z00040:id/notice_usage_guide_single_title").click();
		}
		
		Thread.sleep(3000);
		assertEquals("유의사항", driver.findElementById("com.skt.skaf.A000Z00040:id/notice_title").getText());
		driver.findElementById("com.skt.skaf.A000Z00040:id/notice_contents").isDisplayed();
		assertEquals("이용안내", downscroll(By.id("com.skt.skaf.A000Z00040:id/info_title")).getText());
		assertEquals("배송상품입니다. 상품 구매 후 마이 내 구매내역에서 구매하신 상품의 배송 정보를 확인할 수 있습니다.", 
				downscroll(By.id("com.skt.skaf.A000Z00040:id/info_contents")).getText());
		assertEquals("닫기", driver.findElementById("com.skt.skaf.A000Z00040:id/btn2").getText());
		
		Click("com.skt.skaf.A000Z00040:id/btn2");
		
		Thread.sleep(3000);
		assertTrue(driver.findElements(By.id("com.skt.skaf.A000Z00040:id/btn2")).size() == 0);
		
		result = "PASS";

	}
}