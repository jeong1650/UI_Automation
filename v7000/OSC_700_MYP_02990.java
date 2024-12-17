package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;

public class OSC_700_MYP_02990 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-11
	 * @ ExpectedResult = 마이페이지 > 다운로드 관리 > [편집] 선택 시 편집 모드 진입
	 * @ Editor = 
	 * @ EditDate = 2020-10-13
	 * @ 상품 다운로드 후 TC 진행하도록 수정
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MYP_02990() throws Exception {
		TCID = "OSC700_04_MY_02990 [편집] 선택";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search").click();

		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext");
				
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("서울교통포털");
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();
		
		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/search_result_item_app_title");
		
		Thread.sleep(3000);
		if(driver.findElementById("com.skt.skaf.A000Z00040:id/text").getText().equals("다운로드")) {
			driver.findElementById("com.skt.skaf.A000Z00040:id/text").click();
			
			for(int i = 0; i < 30; i++) {
				try {
					driver.findElementByXPath("//*[@text='실행']").isDisplayed();
					break;
				} catch(Exception e) {
					Thread.sleep(5000);
				}
			}
		}
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_up_indicator").click();	
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_gnb_back").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my_layout").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my").isSelected());
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/menu_download").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/appbar_edit_actionlayout").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/action_mode_close_button").isDisplayed();
		assertEquals("모두삭제", driver.findElementById("com.skt.skaf.A000Z00040:id/appbar_delete_all_actionlayout").getText());
		assertEquals("완료", driver.findElementById("com.skt.skaf.A000Z00040:id/appbar_complete_actionlayout").getText());
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/titleTextView").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/deleteButton").isDisplayed();
		
		Thread.sleep(3000);
		Runtime.getRuntime().exec("adb shell pm uninstall -k --user 0 com.seoul.topis");
																									
		result = "PASS";

	}
}