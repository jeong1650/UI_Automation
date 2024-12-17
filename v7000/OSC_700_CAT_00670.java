package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_CAT_00670 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-04
	 * @ ExpectedResult = 구매 후 평점 및 리뷰 등록 없는 게임 / 앱 상품 상세 > [평가 의견을 남겨 주세요] 선택 시 리뷰 등록 페이지 이동
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_CAT_00670() throws Exception {
		TCID = "OSC700_03_APP_00670 [평가 의견을 남겨 주세요] 선택 (구매 후 평점 및 리뷰 등록 없는 경우)";
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
		
		driver.findElementByXPath("//android.widget.TextView[@text='나의 점수는?']").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/lottie_rating").isDisplayed();
		assertEquals("1", driver.findElementById("com.skt.skaf.A000Z00040:id/radio_one").getText());
		assertEquals("2", driver.findElementById("com.skt.skaf.A000Z00040:id/radio_two").getText());
		assertEquals("3", driver.findElementById("com.skt.skaf.A000Z00040:id/radio_three").getText());
		assertEquals("4", driver.findElementById("com.skt.skaf.A000Z00040:id/radio_four").getText());
		assertEquals("5", driver.findElementById("com.skt.skaf.A000Z00040:id/radio_five").getText());
		
		assertEquals("이용에 불편함이 있으신가요?", driver.findElementById("com.skt.skaf.A000Z00040:id/text_customer").getText());
		assertEquals("고객센터 바로 가기", driver.findElementById("com.skt.skaf.A000Z00040:id/text_inquiry").getText());
		driver.findElementById("com.skt.skaf.A000Z00040:id/img_next").isDisplayed();
		
		assertEquals("리뷰를 입력해 주세요. (선택)\n" + 
				"리뷰 입력 시 개인정보가 포함되지 않도록 주의해 주세요.\n" + 
				"원스토어 이용 불편 및 문의사항은 고객센터를 이용해 주세요.", 
				driver.findElementById("com.skt.skaf.A000Z00040:id/edit_content").getText());
				
		assertEquals("취소", downscroll(By.id("com.skt.skaf.A000Z00040:id/text_cancel")).getText());
		assertEquals("확인", downscroll(By.id("com.skt.skaf.A000Z00040:id/text_confirm")).getText());
		
		assertFalse(driver.findElementById("com.skt.skaf.A000Z00040:id/text_confirm").isEnabled());
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/text_cancel").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElements(By.id("com.skt.skaf.A000Z00040:id/text_cancel")).size() == 0);
		
		Runtime.getRuntime().exec("adb uninstall com.estsoft.alyac");  
		
		result = "PASS";

	}
}