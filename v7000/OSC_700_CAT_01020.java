package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_CAT_01020 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-07
	 * @ ExpectedResult = 게임 / 앱 상품 상세 > 연관 상품 타이틀 선택 시 연관상품 리스트 화면 이동
	 * @ Editor = 
	 * @ EditDate = 2020-10-20
	 * @ upscroll로 탐색 하도록 수정
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_CAT_01020() throws Exception {
		TCID = "OSC700_03_APP_01020 연관상품 타이틀 선택";
		result = "FAIL";
		size = driver.manage().window().getSize();

		popupCheck();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search_layout").click();
		
		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext");
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("T map");
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();
		
		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/search_result_item_app_title");
		
		Thread.sleep(3000);
		upSwipe(0.80);
		upSwipe(0.80);
		upSwipe(0.80);
		upSwipe(0.80);
		
		Thread.sleep(3000);
		upscroll(By.xpath("//*[@text='에스케이텔레콤(주)의 다른 상품']")).click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_up_indicator").isDisplayed();
		assertEquals("에스케이텔레콤(주)의 다른 상품", driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_title").getText());
		driver.findElementById("com.skt.skaf.A000Z00040:id/action_landing_search").isDisplayed();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/thumbnail").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/title").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/seller").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/price").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/v_face").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/score").isDisplayed();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_up_indicator").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElements(By.id("com.skt.skaf.A000Z00040:id/action_landing_search")).size() == 0);
		
		downscroll(By.xpath("//*[@text='에스케이텔레콤(주)의 다른 상품']")).click();
		
		Thread.sleep(3000);
		String prodName = driver.findElementById("com.skt.skaf.A000Z00040:id/title").getText();
		driver.findElementById("com.skt.skaf.A000Z00040:id/title").click();
		
		Thread.sleep(3000);
		assertEquals(prodName, driver.findElementById("com.skt.skaf.A000Z00040:id/main_info_product_name_text_view").getText());
				
		result = "PASS";

	}
}