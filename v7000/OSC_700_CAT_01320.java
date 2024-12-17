package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;

public class OSC_700_CAT_01320 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-08
	 * @ ExpectedResult = 게임 / 앱 상품 상세 > 설치 / 업데이트 완료 시 플로팅 영역에 실행 문구 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_CAT_01320() throws Exception {
		TCID = "OSC700_03_APP_01320 하단 플로팅 영역 확인 (설치 또는 업데이트 완료 된 경우)";
		result = "FAIL";
		size = driver.manage().window().getSize();

		popupCheck();

		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search_layout").click();

		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext");

		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("서울안전");
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();

		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/search_result_item_app_title");

		Thread.sleep(3000);
		assertEquals("다운로드", driver.findElementById("com.skt.skaf.A000Z00040:id/text").getText());
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/text").click();
		
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