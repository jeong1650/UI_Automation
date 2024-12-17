package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_CAT_00820 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-04
	 * @ ExpectedResult = 구매 후 평점 및 리뷰 등록 된 게임 / 앱 상품 상세 > 리뷰 [삭제] 선택 시 삭제 팝업 노출
	 * @ Editor = 
	 * @ EditDate = 2020-10-13
	 * @ 상품 다운로드 부분 수정
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_CAT_00820() throws Exception {
		TCID = "OSC700_03_APP_00820 [삭제] 선택 (구매 후 평점 및 리뷰 등록된 경우)";
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
		downscroll(By.xpath("//*[@text='평점 및 리뷰']"));
		downscroll(By.xpath("//*[@text='평가 의견을 남겨 주세요']")).click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_up_indicator").isDisplayed();
		assertEquals("내 평가 의견", driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_title").getText());
		driver.findElementById("com.skt.skaf.A000Z00040:id/appbar_icon_actionlayout").isDisplayed();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/radio_three").click();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/edit_content").sendKeys("괜찮네요");
		
		downscroll(By.id("com.skt.skaf.A000Z00040:id/text_confirm")).click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElements(By.id("com.skt.skaf.A000Z00040:id/btn2")).size() == 0);
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/lay_my").isDisplayed();
		driver.findElementByXPath("//*[@text='내 평가 의견']").isDisplayed();
		assertEquals("수정", driver.findElementById("com.skt.skaf.A000Z00040:id/text_modify").getText());
		assertEquals("삭제", driver.findElementById("com.skt.skaf.A000Z00040:id/text_remove").getText());
		assertEquals("3", driver.findElementById("com.skt.skaf.A000Z00040:id/text_my_rating").getText());
		assertEquals("보통이에요", driver.findElementById("com.skt.skaf.A000Z00040:id/text_my_rating_desc").getText());
		assertEquals("괜찮네요", driver.findElementById("com.skt.skaf.A000Z00040:id/text_my_content").getText());
		driver.findElementById("com.skt.skaf.A000Z00040:id/text_my_date").isDisplayed();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/text_remove").click(); 
		
		assertEquals("입력한 평가 의견을 삭제하시겠습니까?", driver.findElementById("com.skt.skaf.A000Z00040:id/description").getText());
		assertEquals("취소", driver.findElementById("com.skt.skaf.A000Z00040:id/btn1").getText());
		assertEquals("확인", driver.findElementById("com.skt.skaf.A000Z00040:id/btn2").getText());
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn1").click(); // 취소 선택
		
		Thread.sleep(3000);
		assertTrue(driver.findElements(By.id("com.skt.skaf.A000Z00040:id/btn1")).size() == 0);
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/text_remove").click(); // 삭제 처리
		
		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/btn2");
		
		Thread.sleep(3000);
		assertTrue(driver.findElements(By.id("com.skt.skaf.A000Z00040:id/text_my_content")).size() == 0);
		
		Thread.sleep(3000);
		Runtime.getRuntime().exec("adb uninstall com.estsoft.alyac");  
		
		result = "PASS";

	}
}