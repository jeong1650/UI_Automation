package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_SRH_01780 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-21
	 * @ ExpectedResult = 메인 > 검색 > 검색 결과 없을 시 안내메세지 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_SRH_01780() throws Exception {
		TCID = "OSC700_05_검색_01780 검색 결과 화면 (검색 결과가 없는 경우)";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();
				
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search").click();
		
		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext");
		
		try {
			driver.findElementById("com.skt.skaf.A000Z00040:id/search_history_all_delete").click();
		} catch (Exception e) {}
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("알약M");
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("난 너를 믿었던 만큼 내 친구도");
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();
		
		Thread.sleep(3000);
		assertEquals("‘난 너를 믿었던 만큼 내 친구도’", driver.findElementById("com.skt.skaf.A000Z00040:id/search_result_nothing_text").getText());
		driver.findElementByXPath("//*[@text='검색 결과가 없습니다.']").isDisplayed();
		driver.findElementByXPath("//*[@text='검색어가 바르게 입력되었는지 확인해보세요.']").isDisplayed();
		driver.findElementByXPath("//*[@text='비슷한 단어로 다시 검색해 보세요.']").isDisplayed();
		
		downscroll(By.xpath("//*[@text='연관 검색어']"));		
		downscroll(By.xpath("//*[@text='함께 검색한 상품']"));	
		downscroll(By.xpath("//*[@text='생산성 TOP 20']"));	
		downscroll(By.xpath("//*[@text='요즘 뜨는 앱 검색어']"));	
		
		result = "PASS";
	}
}