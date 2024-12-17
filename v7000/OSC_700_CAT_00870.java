package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_CAT_00870 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-04
	 * @ ExpectedResult = 게임 / 앱 상품 상세 > 전체 평점 영역 정상 노출
	 * @ Editor = 
	 * @ EditDate = 2020-10-23
	 * @ downscroll 로 탐색 하도록 수정
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_CAT_00870() throws Exception {
		TCID = "OSC700_03_APP_00870 전체 평점 영역 확인";
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
		assertEquals("평점 및 리뷰", downscroll(By.id("com.skt.skaf.A000Z00040:id/text_title")).getText());
		downscroll(By.id("com.skt.skaf.A000Z00040:id/text_rating")).isDisplayed();
		downscroll(By.id("com.skt.skaf.A000Z00040:id/text_person_count")).isDisplayed();
		
		downscroll(By.xpath("//*[@text='5']")).isDisplayed();
		downscroll(By.id("com.skt.skaf.A000Z00040:id/progress5")).isDisplayed();
		
		downscroll(By.xpath("//*[@text='4']")).isDisplayed();
		downscroll(By.id("com.skt.skaf.A000Z00040:id/progress4")).isDisplayed();
		
		downscroll(By.xpath("//*[@text='3']")).isDisplayed();
		downscroll(By.id("com.skt.skaf.A000Z00040:id/progress3")).isDisplayed();
		
		downscroll(By.xpath("//*[@text='2']")).isDisplayed();
		downscroll(By.id("com.skt.skaf.A000Z00040:id/progress2")).isDisplayed();
		
		downscroll(By.xpath("//*[@text='1']")).isDisplayed();
		downscroll(By.id("com.skt.skaf.A000Z00040:id/progress1")).isDisplayed();
				
		result = "PASS";

	}
}