package osc.v7000;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class OSC_700_CAT_00270 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-03
	 * @ ExpectedResult = 엡 / 게임 내용 상세 정보 없는 15세 이용가 게임 상품 상세 > 이용등급 [ⓘ] 선택 시 안내 팝업 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_CAT_00270() throws Exception {
		TCID = "OSC700_03_APP_00270 이용등급 [ⓘ] 선택 (앱 또는 게임내용 상세정보 없는 경우, 15세이용가 상품)";
		result = "FAIL";
		size = driver.manage().window().getSize();

		popupCheck();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search_layout").click();
		
		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext");
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("라스트 쉘터");
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();
		
		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/search_result_item_app_title");
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/add_info_item_more_info_image_view").click();
		
		Thread.sleep(3000);
		assertEquals("15세 이용가", driver.findElementById("com.skt.skaf.A000Z00040:id/title").getText());
		assertEquals("경미한 선정/폭력 및 사행성 표현, 직접적인 범죄묘사가 포함될 수 있습니다.", driver.findElementById("com.skt.skaf.A000Z00040:id/contents").getText());
		assertEquals("닫기", driver.findElementById("com.skt.skaf.A000Z00040:id/btn2").getText());
				
		result = "PASS";

	}
}