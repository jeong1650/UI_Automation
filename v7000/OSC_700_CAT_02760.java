package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_CAT_02760 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-09
	 * @ ExpectedResult = 쇼핑 상품권 / 교환권 상품 상세 > 유의사항 및 이용안내 영역 정상 노출
	 * @ Editor = 
	 * @ EditDate = 2020-10-13
	 * @ 상품 변경
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_CAT_02760() throws Exception {
		TCID = "OSC700_03_쇼핑_02760 유의사항 및 이용안내 영역 확인 (복수 판매처)";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();

		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search_layout").click();

		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext");

		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("슈퍼슈프림(씬)L+ 콜라 1.25L ");
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();

		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/search_result_item_shop_title").click();

		Thread.sleep(3000);
		assertEquals("유의사항 및 이용안내", downscroll(By.id("com.skt.skaf.A000Z00040:id/notice_usage_guide_multi_title")).getText());
		downscroll(By.id("com.skt.skaf.A000Z00040:id/notice_usage_guide_multi_layout"));
		driver.findElementByXPath("//*[@text='기프팅']").isDisplayed();
		driver.findElementByXPath("//*[@text='㈜쿠프마케팅']").isDisplayed();
		
		result = "PASS";

	}
}