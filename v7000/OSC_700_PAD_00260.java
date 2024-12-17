package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_PAD_00260 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-22
	 * @ ExpectedResult = 다운로드 시도시 앱 접근 권한 동의 팝업 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_PAD_00260() throws Exception {
		TCID = "OSC700_06_APP_00260 [다운로드] 선택(OS 6.0 미만 단말 또는 OS 6.0 이상 상품 타겟 SDK 23 미만 인 경우, , ex: 소년삼국지)";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();
				
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search").click();

		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext");
		
		try {
			driver.findElementById("com.skt.skaf.A000Z00040:id/search_history_all_delete").click();
		} catch (Exception e) {}
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("소년삼국지 게임펍");
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();
		
		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/search_result_item_app_title");

		Thread.sleep(3000);
		assertEquals("다운로드", driver.findElementById("com.skt.skaf.A000Z00040:id/text").getText());
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/text").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/app_icon").isDisplayed();
		assertEquals("소년삼국지", driver.findElementById("com.skt.skaf.A000Z00040:id/app_title").getText());
		assertEquals("앱 접근 권한 동의가 필요합니다.", driver.findElementById("com.skt.skaf.A000Z00040:id/app_desc").getText());
		driver.findElementById("com.skt.skaf.A000Z00040:id/permission_layout").isDisplayed();
		
		assertEquals("동의하지 않음", driver.findElementById("com.skt.skaf.A000Z00040:id/btn1").getText());
		assertEquals("동의", driver.findElementById("com.skt.skaf.A000Z00040:id/btn2").getText());
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn1").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElements(By.id("com.skt.skaf.A000Z00040:id/btn1")).size() == 0);
		assertEquals("다운로드", driver.findElementById("com.skt.skaf.A000Z00040:id/text").getText());
												
		result = "PASS";
	}
}