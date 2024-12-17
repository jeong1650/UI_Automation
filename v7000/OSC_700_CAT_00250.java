package osc.v7000;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class OSC_700_CAT_00250 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-03
	 * @ ExpectedResult = 게임내용 상세 정보 있는 15세 이용가 게임 상품 상세 > 이용등급 [ⓘ] 선택 시 안내 팝업 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_CAT_00250() throws Exception {
		TCID = "OSC700_03_APP_00250 이용등급 [ⓘ] 선택 (게임내용 상세정보 있는 경우, 15세 이용가 )";
		result = "FAIL";
		size = driver.manage().window().getSize();

		popupCheck();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search_layout").click();
		
		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext");
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("카오스모바일");
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();
		
		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/search_result_item_app_title");
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/add_info_item_more_info_image_view").click();
		
		Thread.sleep(3000);
		assertEquals("15세 이용가", driver.findElementById("com.skt.skaf.A000Z00040:id/title").getText());
		assertEquals("폭력성,선정성,사행성,공포,범죄 (으)로 인해 해당 등급으로 분류되었습니다.", driver.findElementById("com.skt.skaf.A000Z00040:id/contents").getText());
		assertEquals("닫기", driver.findElementById("com.skt.skaf.A000Z00040:id/btn2").getText());
				
		result = "PASS";

	}
}