package osc.v7000;

import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_CAT_00430 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-03
	 * @ ExpectedResult = 게임 / 앱 상품 상세 > 등록된 캠페인 미존재시 혜택 영역 미노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_CAT_00430() throws Exception {
		TCID = "OSC700_03_APP_00430 혜택 영역 확인 (등록된 캠페인이 없는 경우)";
		result = "FAIL";
		size = driver.manage().window().getSize();

		popupCheck();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search_layout").click();
		
		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext");
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("아시아나항공");
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();
		
		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/search_result_item_app_title");
		
		Thread.sleep(3000);
		assertNotEquals("혜택 확인하세요", downscroll(By.id("com.skt.skaf.A000Z00040:id/text_title")).getText());
		
		result = "PASS";

	}
}