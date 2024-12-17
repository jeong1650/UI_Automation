package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_CAT_00590 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-04
	 * @ ExpectedResult = 게임 / 앱 상품 상세 > 공식 커뮤니티 영역 정상 노출
	 * @ Editor = 
	 * @ EditDate = 2020-10-23
	 * @ 기본앱 설정 되어 있을 때도 확인 가능 하도록 수정
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_CAT_00590() throws Exception {
		TCID = "OSC700_03_APP_00590 공식 커뮤니티 영역 확인";
		result = "FAIL";
		size = driver.manage().window().getSize();

		popupCheck();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search_layout").click();
		
		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext");
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("대항해대전 : 오션 앤 엠파이어");
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();
		
		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/search_result_item_app_title");
		
		Thread.sleep(3000);
		assertEquals("공식 커뮤니티", downscroll(By.id("com.skt.skaf.A000Z00040:id/community_title")).getText());
		downscroll(By.id("com.skt.skaf.A000Z00040:id/community_item_image_view")).click();
		
		Thread.sleep(3000);
		try {
			driver.findElementById("com.skt.skaf.A000Z00040:id/community_item_image_view").isDisplayed();
			
			upSwipe(0.50);
			driver.findElementById("com.skt.skaf.A000Z00040:id/community_item_image_view").click();
		} catch(Exception e) {}
		
		Thread.sleep(3000);
		try {
			driver.findElementById("android:id/icon").isDisplayed();
		} catch(Exception e) {
			try {
				driver.findElementById("com.lge:id/icon_lg").isDisplayed();
			} catch(Exception ee) {
				try {
					driver.findElementByXPath("//*[@package='com.sec.android.app.sbrowser']").isDisplayed();
				} catch(Exception eee) {
					driver.findElementByXPath("//*[@package='com.android.chrome']").isDisplayed();
				}
			}
		}
		
		Thread.sleep(3000);
		driver.navigate().back();
		
		result = "PASS";

	}
}