package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_CAT_00780 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-04
	 * @ ExpectedResult = 게임 / 앱 상품 상세 > 리뷰 등록 페이지 > 리뷰에 금칙어 포함 시 팝업 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_CAT_00780() throws Exception {
		TCID = "OSC700_03_APP_00780 [확인] 선택 (평정 및 리뷰 입력 되어 있는 경우, 2, 리뷰에 금칙어가 포함된 경우)";
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
		if(driver.findElementById("com.skt.skaf.A000Z00040:id/text").getText().equals("다운로드")) {
			driver.findElementById("com.skt.skaf.A000Z00040:id/text").click();
			
			Thread.sleep(3000);
			try {
				Click("com.skt.skaf.A000Z00040:id/btn2");
			} catch (Exception e) {}
		}
				
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
		downscroll(By.xpath("//android.widget.TextView[@text='평가 의견을 남겨 주세요']")).click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_up_indicator").isDisplayed();
		assertEquals("내 평가 의견", driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_title").getText());
		driver.findElementById("com.skt.skaf.A000Z00040:id/appbar_icon_actionlayout").isDisplayed();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/radio_three").click();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/edit_content").sendKeys("씨발");
		
		downscroll(By.id("com.skt.skaf.A000Z00040:id/text_confirm")).click();
		
		Thread.sleep(3000);
		assertEquals("작성하신 내용 중 타인에게 악영향을 줄 수 있는 문구가 포함되어 있어 등록할 수 없습니다.", driver.findElementById("com.skt.skaf.A000Z00040:id/contents").getText());
		assertEquals("확인", driver.findElementById("com.skt.skaf.A000Z00040:id/btn2").getText());
		
		Click("com.skt.skaf.A000Z00040:id/btn2");
		
		assertTrue(driver.findElements(By.id("com.skt.skaf.A000Z00040:id/btn2")).size() == 0);
		
		Runtime.getRuntime().exec("adb uninstall com.estsoft.alyac");  
		
		result = "PASS";

	}
}