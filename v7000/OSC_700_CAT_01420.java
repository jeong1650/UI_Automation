package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;

public class OSC_700_CAT_01420 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-08
	 * @ ExpectedResult = 카카오톡 상품 상세 > 설치 / 업데이트 완료 시 플로팅 영역에 실행 문구 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_CAT_01420() throws Exception {
		TCID = "OSC700_03_APP_01420 하단 플로팅 영역 확인 (원스토어 카카오톡 설치된 경우, 2, 설치 버전이 최신 버전)";
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
		Click("com.skt.skaf.A000Z00040:id/search_result_item_app_title");

		Thread.sleep(3000);
		assertEquals("다운로드", driver.findElementById("com.skt.skaf.A000Z00040:id/text").getText());
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/text").click();
		
		try {
			assertEquals("100MB가 넘는 상품입니다. 데이터 네트워크로 다운로드 시 통화료가 발생할 수 있습니다.", 
					driver.findElementById("com.skt.skaf.A000Z00040:id/description").getText());
			driver.findElementById("com.skt.skaf.A000Z00040:id/btn1").click();
		} catch(Exception e) {}
		
		for(int i = 0; i < 30; i++) {
			try {
				assertEquals("실행", driver.findElementById("com.skt.skaf.A000Z00040:id/text").getText());
				result = "PASS";
				break;
			} catch(Exception e) {
				Thread.sleep(3000);
			}
		}
	}
}