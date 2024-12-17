package osc.v7000;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class OSC_700_GUH_00030 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-08-31
	 * @ ExpectedResult = 메인 > 검색 > 임의의 내용 검색 시 검색 결과 화면 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_GUH_00030() throws Exception {
		TCID = "OSC700_01_Home_00030 임의의 내용 검색";
		result = "FAIL";
		size = driver.manage().window().getSize();

		popupCheck();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search_layout").click();
		
		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext");
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("카카오톡");
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/search_result_category_list").isDisplayed();
		assertEquals("카카오톡 KakaoTalk", driver.findElementById("com.skt.skaf.A000Z00040:id/search_result_item_app_title").getText());
				
		result = "PASS";

	}
}