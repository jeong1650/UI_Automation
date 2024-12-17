package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_CAT_01940 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-08
	 * @ ExpectedResult = 쇼핑 배송상품 상세 > 유의사항 및 이용안내 영역 정상 노출
	 * @ Editor = 
	 * @ EditDate = 2020-10-26
	 * @ 하단 플로팅 영역과 버튼 겹칠시 동작 추가
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_CAT_01940() throws Exception {
		TCID = "OSC700_03_쇼핑_01940 유의사항 및 이용안내 영역 확인";
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
			upSwipe(0.30);
			
			Thread.sleep(3000);
			driver.findElementById("com.skt.skaf.A000Z00040:id/notice_usage_guide_single_title").click();
		}
		
		Thread.sleep(3000);
		assertEquals("유의사항", driver.findElementById("com.skt.skaf.A000Z00040:id/notice_title").getText());
							
		result = "PASS";

	}
}