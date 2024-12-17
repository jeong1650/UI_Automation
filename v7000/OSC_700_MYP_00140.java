package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_MYP_00140 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-10-14
	 * @ ExpectedResult = 마이페이지 > 게임 상품 사용 시 [평가 의견 남기기] 선택 > 의견 남기기 화면 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MYP_00140() throws Exception {
		TCID = "OSC700_04_MY_00140 [평가 의견 남기기] 선택";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search").click();

		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext");
				
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("바운딩 바이러스");
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();
		
		try {
			Thread.sleep(3000);
			driver.findElementByXPath("//*[@text='다운로드']").isDisplayed(); 
			
			Thread.sleep(3000);
			driver.findElementById("com.skt.skaf.A000Z00040:id/search_result_item_download_button").click();
			
			Thread.sleep(3000);
			Click("com.skt.skaf.A000Z00040:id/btn2");
		} catch(Exception e) {}
		
		Thread.sleep(5000);
		for(int i = 0; i < 30; i++) {
			try {
				driver.findElementByXPath("//*[@text='실행']").isDisplayed();
				break;
			} catch(Exception e) {
				Thread.sleep(5000);
			}
		}
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_gnb_back").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my_layout").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my").isSelected());
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_review_send").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_up_indicator").isDisplayed();
		assertEquals("내 평가 의견", driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_title").getText());
		driver.findElementById("com.skt.skaf.A000Z00040:id/appbar_icon_actionlayout").isDisplayed();
		assertEquals("나의 점수는?", driver.findElementById("com.skt.skaf.A000Z00040:id/text_rating").getText());
		driver.findElementById("com.skt.skaf.A000Z00040:id/lottie_rating").isDisplayed();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/radio_one").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/radio_two").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/radio_three").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/radio_four").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/radio_five").isDisplayed();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/img_customer").isDisplayed();
		assertEquals("이용에 불편함이 있으신가요?", driver.findElementById("com.skt.skaf.A000Z00040:id/text_customer").getText());
		assertEquals("고객센터 바로 가기", driver.findElementById("com.skt.skaf.A000Z00040:id/text_inquiry").getText());
		driver.findElementById("com.skt.skaf.A000Z00040:id/img_next").isDisplayed();
		
		assertEquals("리뷰를 입력해 주세요. (선택)\n" + 
				"리뷰 입력 시 개인정보가 포함되지 않도록 주의해 주세요.\n" + 
				"원스토어 이용 불편 및 문의사항은 고객센터를 이용해 주세요.", 
				driver.findElementById("com.skt.skaf.A000Z00040:id/edit_content").getText());
		
		assertEquals("취소", downscroll(By.id("com.skt.skaf.A000Z00040:id/text_cancel")).getText());
		assertEquals("확인", downscroll(By.id("com.skt.skaf.A000Z00040:id/text_confirm")).getText());
		
		Thread.sleep(3000);
		Runtime.getRuntime().exec("adb shell pm uninstall -k --user 0 com.BlueStarWorks.Bounce_Ball");
				
		result = "PASS";

	}
}