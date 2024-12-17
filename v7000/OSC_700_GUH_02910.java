package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_GUH_02910 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-01
	 * @ ExpectedResult = 메인 > [마이] 선택 > [구매 내역] 선택 > [편집] 선택 시 편집 기능 제공
	 * @ Editor = 
	 * @ EditDate = 2020-10-20
	 * @ 상품 다운로드 부분 수정
	 * -----------------------------------------------------------------------------
	 */ 

	@Test
	public void OSC_GUH_02910() throws Exception {
		TCID = "OSC700_01_Home_02910  [마이] 선택";
		result = "FAIL";
		size = driver.manage().window().getSize();

		popupCheck();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search_layout").click();

		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext");

		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("울릉 아이맘");
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();

		try {
			Thread.sleep(3000);
			driver.findElementByXPath("//*[@text='다운로드']").isDisplayed(); 
			
			Thread.sleep(3000);
			driver.findElementById("com.skt.skaf.A000Z00040:id/search_result_item_download_button").click();
			
			Thread.sleep(3000);
			Click("com.skt.skaf.A000Z00040:id/btn2");
		} catch(Exception e) {}
		
		for(int i = 0; i < 30; i++) {
			try {
				driver.findElementByXPath("//*[@text='실행']").isDisplayed(); 
				break;
			} catch(Exception e) {
				Thread.sleep(3000);
			}
		}	
		
		driver.navigate().back();

		driver.navigate().back();
				
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my").isSelected());
		
		downscroll(By.id("com.skt.skaf.A000Z00040:id/menu_purchase_list")).click();
		
		Thread.sleep(3000);
		driver.findElementByXPath("//*[@text='앱']").click(); 
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/appbar_edit_actionlayout").click();
		
		Thread.sleep(3000);		
		assertEquals("완료", driver.findElementById("com.skt.skaf.A000Z00040:id/appbar_complete_actionlayout").getText());
				
		Runtime.getRuntime().exec("adb shell pm uninstall -k --user 0 com.webview.imom22");  
		
		result = "PASS";

	}
}