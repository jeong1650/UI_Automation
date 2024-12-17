package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_MYP_05861 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-15
	 * @ ExpectedResult = 마이페이지 > 설정 > wifi에서만 다운로드 설정 > LTE 상태로 다운로드 시 설정 변경
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MYP_05861() throws Exception {
		TCID = "OSC700_04_설정_05861 WiFi가 아닌 상태로 상품 다운로드 실행";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();
				
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my_layout").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my").isSelected());
		
		downscroll(By.id("com.skt.skaf.A000Z00040:id/menu_setting")).click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/setting_wifi_only_download_switch").isDisplayed();
		if(driver.findElementById("com.skt.skaf.A000Z00040:id/setting_wifi_only_download_switch").getAttribute("checked").equals("true")) {
		}
		else {
			driver.findElementById("com.skt.skaf.A000Z00040:id/setting_wifi_only_download_switch").click();
			assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/setting_wifi_only_download_switch").getAttribute("checked").equals("true"));
		}
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_up_indicator").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search").click();
		
		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext");
		
		try {
			driver.findElementById("com.skt.skaf.A000Z00040:id/search_history_all_delete").click();
		} catch (Exception e) {}
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("웨이브");

		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();
		
		Thread.sleep(2000);
		Click("com.skt.skaf.A000Z00040:id/search_result_item_app_title");
		
		Thread.sleep(2000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/text").click();
		
		Thread.sleep(3000);
		assertEquals("Wi-Fi에서만 다운로드하도록 설정되어 있습니다. 모바일 네트워크에서도 다운로드하도록 설정을 변경할까요?", 
				driver.findElementById("com.skt.skaf.A000Z00040:id/description").getText());
		assertEquals("아니요", driver.findElementById("com.skt.skaf.A000Z00040:id/btn1").getText());
		assertEquals("예", driver.findElementById("com.skt.skaf.A000Z00040:id/btn2").getText());
		
		Click("com.skt.skaf.A000Z00040:id/btn2");
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_up_indicator").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_gnb_back").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my_layout").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my").isSelected());
		
		downscroll(By.id("com.skt.skaf.A000Z00040:id/menu_setting")).click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/setting_wifi_only_download_switch").getAttribute("checked").equals("false"));
		
		result = "PASS";
	}
}