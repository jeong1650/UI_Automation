package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_CAT_00880 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-04
	 * @ ExpectedResult = 등록 된 긍정/부정 리뷰 존재하는 게임 / 앱 상품 상세 > 긍정 / 부정 리뷰 영역 정상 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_CAT_00880() throws Exception {
		TCID = "OSC700_03_APP_00880 긍정적/부정적 리뷰 영역 확인 (등록 된 긍정/부정 리뷰가 있는 경우)";
		result = "FAIL";
		size = driver.manage().window().getSize();

		popupCheck();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search_layout").click();
		
		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext");
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("캐시워크");
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();
		
		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/search_result_item_app_title");
		
		Thread.sleep(3000);
		assertEquals("긍정적인 리뷰", downscroll(By.id("com.skt.skaf.A000Z00040:id/text_affirm_title")).getText());
		downscroll(By.id("com.skt.skaf.A000Z00040:id/text_affirm_content"));
		downscroll(By.id("com.skt.skaf.A000Z00040:id/text_affirm_date"));
		driver.findElementById("com.skt.skaf.A000Z00040:id/text_affirm_id").isDisplayed();
		
		assertEquals("부정적인 리뷰", downscroll(By.id("com.skt.skaf.A000Z00040:id/text_deny_title")).getText());
		downscroll(By.id("com.skt.skaf.A000Z00040:id/text_deny_content"));
		downscroll(By.id("com.skt.skaf.A000Z00040:id/text_deny_date"));
		driver.findElementById("com.skt.skaf.A000Z00040:id/text_deny_id").isDisplayed();
				
		result = "PASS";

	}
}