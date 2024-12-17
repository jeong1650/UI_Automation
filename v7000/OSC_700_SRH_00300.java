package osc.v7000;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_SRH_00300 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-16
	 * @ ExpectedResult = 메인 > 검색 > 쇼핑 카테고리 영역 정상 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_SRH_00300() throws Exception {
		TCID = "OSC700_05_검색_00300 쇼핑 카테고리 영역";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();
				
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search").click();
		
		Thread.sleep(3000);
		String categoryXPath3 = "//*[@resource-id='com.skt.skaf.A000Z00040:id/scroll_content_main']/android.widget.FrameLayout[@index='2']"; // 쇼핑
		
		downscroll(By.xpath(categoryXPath3 + "//*[@text='쇼핑 카테고리']"));
		downscroll(By.xpath(categoryXPath3 + "//*[@text='전체']"));
		downscroll(By.xpath(categoryXPath3 + "//*[@text='게이밍키보드']"));
		downscroll(By.xpath(categoryXPath3 + "//*[@text='게이밍마우스']"));
		downscroll(By.xpath(categoryXPath3 + "//*[@text='게이밍헤드셋']"));
		downscroll(By.xpath(categoryXPath3 + "//*[@text='게이밍PC']"));
		downscroll(By.xpath(categoryXPath3 + "//*[@text='게이밍주변기기']"));
		downscroll(By.xpath(categoryXPath3 + "//*[@text='PC 주변기기']"));
		downscroll(By.xpath(categoryXPath3 + "//*[@text='콘솔본체']"));
		downscroll(By.xpath(categoryXPath3 + "//*[@text='콘솔타이틀']"));
		downscroll(By.xpath(categoryXPath3 + "//*[@text='콘솔주변기기']"));
		downscroll(By.xpath(categoryXPath3 + "//*[@text='게임굿즈']"));
		downscroll(By.xpath(categoryXPath3 + "//*[@text='모바일/주변기기']"));
		downscroll(By.xpath(categoryXPath3 + "//*[@text='식품/건강']"));
		downscroll(By.xpath(categoryXPath3 + "//*[@text='디지털/가전']"));
		downscroll(By.xpath(categoryXPath3 + "//*[@text='상품권']"));
		downscroll(By.xpath(categoryXPath3 + "//*[@text='생활/소품/잡화']"));
		downscroll(By.xpath(categoryXPath3 + "//*[@text='화장품']"));
		downscroll(By.xpath(categoryXPath3 + "//*[@text='차량/레저']"));
		downscroll(By.xpath(categoryXPath3 + "//*[@text='쥬얼리/악세서리']"));
		downscroll(By.xpath(categoryXPath3 + "//*[@text='스포츠/의류/신발']"));
		downscroll(By.xpath(categoryXPath3 + "//*[@text='교환권']"));
		
		result = "PASS";
	}
}