package osc.v7000;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_SRH_00260 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-16
	 * @ ExpectedResult = 메인 > 검색 > 게임 카테고리 영역 정상 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_SRH_00260() throws Exception {
		TCID = "OSC700_05_검색_00260 게임 카테고리 영역";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();
				
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search").click();
		
		Thread.sleep(3000);
		String categoryXPath1 = "//*[@resource-id='com.skt.skaf.A000Z00040:id/scroll_content_main']/android.widget.FrameLayout[@index='0']"; // 게임
		
		downscroll(By.xpath(categoryXPath1 + "//*[@text='게임 카테고리']"));
		downscroll(By.xpath(categoryXPath1 + "//*[@text='전체']"));
		downscroll(By.xpath(categoryXPath1 + "//*[@text='롤플레잉']"));
		downscroll(By.xpath(categoryXPath1 + "//*[@text='액션']"));
		downscroll(By.xpath(categoryXPath1 + "//*[@text='전략']"));
		downscroll(By.xpath(categoryXPath1 + "//*[@text='시뮬레이션']"));
		downscroll(By.xpath(categoryXPath1 + "//*[@text='캐주얼']"));
		downscroll(By.xpath(categoryXPath1 + "//*[@text='스포츠']"));
		downscroll(By.xpath(categoryXPath1 + "//*[@text='보드']"));
		downscroll(By.xpath(categoryXPath1 + "//*[@text='스토리게임']"));
						
		result = "PASS";
	}
}