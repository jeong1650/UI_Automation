package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_CAT_00440 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-03
	 * @ ExpectedResult = 게임 / 앱 상품 상세 > 혜택 영역 정상 노출
	 * @ Editor = 
	 * @ EditDate = 2020-10-15
	 * @ 웹 페이지 인식 수정
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_CAT_00440() throws Exception {
		TCID = "OSC700_03_APP_00440 혜택 영역 확인 (캠페인이 한개 등록 되어 있는 경우)";
		result = "FAIL";
		size = driver.manage().window().getSize();

		popupCheck();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search_layout").click();
		
		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext");
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("마이로니");
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();
		
		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/search_result_item_app_title");
		
		Thread.sleep(3000);
		assertEquals("혜택 확인하세요", downscroll(By.id("com.skt.skaf.A000Z00040:id/text_title")).getText());
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/lay_root").click();
		
		Thread.sleep(5000);
		driver.findElementByClassName("android.webkit.WebView").isDisplayed();
				
		result = "PASS";

	}
}