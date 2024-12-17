package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_CAT_00650 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-04
	 * @ ExpectedResult = 구매 후 평점 및 리뷰 등록 없는 게임 / 앱 상품 상세 > 평점 및 리뷰 영역 정상 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_CAT_00650() throws Exception {
		TCID = "OSC700_03_APP_00650 평점 및 리뷰 영역 확인 (구매 후 평점 및 리뷰 등록 없는 경우)";
		result = "FAIL";
		size = driver.manage().window().getSize();

		popupCheck();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search_layout").click();
		
		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext");
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("알약M");
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();
		
		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/search_result_item_app_title");
		
		Thread.sleep(3000);
		try {
			assertEquals("다운로드", driver.findElementById("com.skt.skaf.A000Z00040:id/text").getText());
			driver.findElementById("com.skt.skaf.A000Z00040:id/text").click();
			
			try {
				Click("com.skt.skaf.A000Z00040:id/btn2");
			} catch (Exception e) {}
		} catch (Exception e) {}
		
		Thread.sleep(3000);
		for(int i = 0; i < 30; i++) {
			try {
				driver.findElementByXPath("//*[@text='실행']").isDisplayed();
				break;
			} catch(Exception e) {
				Thread.sleep(2000);
			}
		}
		
		Thread.sleep(3000);
		downscroll(By.xpath("//android.widget.TextView[@text='평점 및 리뷰']"));
		downscroll(By.xpath("//android.widget.TextView[@text='평가 의견을 남겨 주세요']"));
		
		Runtime.getRuntime().exec("adb uninstall com.estsoft.alyac");  		
		
		result = "PASS";
	}
}