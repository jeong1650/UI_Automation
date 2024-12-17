package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_MYP_00950 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-10-19
	 * @ ExpectedResult = 마이페이지 > 구매내역 > 미설치 상품 다운로드 버튼 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MYP_00950() throws Exception {
		TCID = "OSC700_04_MY_00950 리스트 메타정보 확인 (게임/앱 상품인 경우, 다운로드 가능 상품인 경우(미설치))";
		result = "FAIL";
		size = driver.manage().window().getSize();

		popupCheck();

		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search_layout").click();

		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext");

		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("알약M");
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

		driver.navigate().back();

		driver.navigate().back();
		
		Runtime.getRuntime().exec("adb shell pm uninstall -k --user 0 com.webview.imom22");  
		
		setUp();
		
		popupCheck();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my").click();
		
		Thread.sleep(3000);
		downscroll(By.id("com.skt.skaf.A000Z00040:id/menu_purchase_list")).click();
		
		Thread.sleep(3000);
		driver.findElementByXPath("//*[@text='앱']").click(); 
		
		Thread.sleep(3000);
		assertEquals("다운로드", driver.findElementById("com.skt.skaf.A000Z00040:id/purchase_function_btn1").getText());
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/purchase_function_btn1").click();
		
		try {
			Thread.sleep(3000);
			Click("com.skt.skaf.A000Z00040:id/btn2");
		} catch(Exception e) {}		
		
		for(int i = 0; i < 30; i++) {
			try {
				driver.findElementById("com.skt.skaf.A000Z00040:id/purchase_function_btn1").isDisplayed();
				Thread.sleep(3000);
			} catch(Exception e) {
				break;
			}
		}		
		
		Runtime.getRuntime().exec("adb uninstall com.estsoft.alyac");  
		
		result = "PASS";
	}
}