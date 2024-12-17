package osc.v7000;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_CAT_00630 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-04
	 * @ ExpectedResult = 구매 후 리뷰 남기기 전 게임 / 앱 상품 상세 > 평점 및 리뷰 영역 정상 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_CAT_00640() throws Exception {
		TCID = "OSC700_03_APP_00630 평점 및 리뷰 영역 확인 (구매 후 리뷰 남기기 전 )";
		result = "FAIL";
		size = driver.manage().window().getSize();

		popupCheck();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search_layout").click();
		
		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext");
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("디노 붐 - 무료 경기 3 퍼즐 게임");
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();
		
		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/search_result_item_app_title");
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/text").click();
		
		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/btn2");
		
		Thread.sleep(3000);
		downscroll(By.xpath("//android.widget.TextView[@text='평점 및 리뷰']"));
		assertEquals("첫 평가 의견을 남겨 주세요", downscroll(By.id("com.skt.skaf.A000Z00040:id/text_empty_write")).getText());
		
		result = "PASS";

	}
}