package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_MYP_00890 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-10
	 * @ ExpectedResult = 마이페이지 > 구매내역 > 게임 / 앱 선택시 구매내역 노출
	 * @ Editor = 
	 * @ EditDate = 2020-10-26
	 * @ 상품 다운로드 동작 추가
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MYP_00890() throws Exception {
		TCID = "OSC700_04_MY_00890 [게임] or [앱] 선택";
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

		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my_layout").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my").isSelected());
		
		downscroll(By.id("com.skt.skaf.A000Z00040:id/menu_purchase_list")).click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_up_indicator").isDisplayed();
		assertEquals("구매내역", driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_title").getText());
		assertEquals("편집", driver.findElementById("com.skt.skaf.A000Z00040:id/appbar_edit_actionlayout").getText());
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/my_purchase_date").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/my_purchase_select_date").isDisplayed();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/my_purchase_category").isDisplayed();
		driver.findElementByXPath("//android.widget.CheckedTextView[@text='게임']").isDisplayed();
		driver.findElementByXPath("//android.widget.CheckedTextView[@text='앱']").isDisplayed();
		driver.findElementByXPath("//android.widget.CheckedTextView[@text='쇼핑']").isDisplayed();
		driver.findElementByXPath("//android.widget.CheckedTextView[@text='북스 외']").isDisplayed();
		
		driver.findElementByXPath("//android.widget.CheckedTextView[@text='앱']").click();
		
		Thread.sleep(3000);
		driver.findElementByXPath("//*[@text='상품']").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/purchase_thumbnail_image").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/purchase_item_title").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/date").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/price").isDisplayed();
		assertEquals("영수증", driver.findElementById("com.skt.skaf.A000Z00040:id/text_receipt").getText());
		
		assertEquals("보낸선물 조회", downscroll(By.id("com.skt.skaf.A000Z00040:id/btn")).getText());
		
		Runtime.getRuntime().exec("adb shell pm uninstall -k --user 0 com.webview.imom22");    
														
		result = "PASS";

	}
}