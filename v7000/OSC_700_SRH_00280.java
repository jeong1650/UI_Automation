package osc.v7000;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_SRH_00280 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-16
	 * @ ExpectedResult = 메인 > 검색 > 앱 카테고리 영역 정상 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_SRH_00280() throws Exception {
		TCID = "OSC700_05_검색_00280 앱 카테고리 영역";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();
				
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search").click();
		
		Thread.sleep(3000);
		String categoryXPath2 = "//*[@resource-id='com.skt.skaf.A000Z00040:id/scroll_content_main']/android.widget.FrameLayout[@index='1']"; // 앱
		
		downscroll(By.xpath(categoryXPath2 + "//*[@text='앱 카테고리']"));
		downscroll(By.xpath(categoryXPath2 + "//*[@text='전체']"));
		downscroll(By.xpath(categoryXPath2 + "//*[@text='FUN']"));
		downscroll(By.xpath(categoryXPath2 + "//*[@text='SNS']"));
		downscroll(By.xpath(categoryXPath2 + "//*[@text='운세/심리테스트']"));
		downscroll(By.xpath(categoryXPath2 + "//*[@text='폰꾸미기/런처']"));
		downscroll(By.xpath(categoryXPath2 + "//*[@text='방송/영화/화보']"));
		downscroll(By.xpath(categoryXPath2 + "//*[@text='만화']"));
		downscroll(By.xpath(categoryXPath2 + "//*[@text='사진/카메라']"));
		downscroll(By.xpath(categoryXPath2 + "//*[@text='음악/오디오']"));
		downscroll(By.xpath(categoryXPath2 + "//*[@text='정보/상식']"));
		downscroll(By.xpath(categoryXPath2 + "//*[@text='건강/생활안전']"));
		downscroll(By.xpath(categoryXPath2 + "//*[@text='라이프스타일']"));
		downscroll(By.xpath(categoryXPath2 + "//*[@text='생산성']"));
		downscroll(By.xpath(categoryXPath2 + "//*[@text='여행/지역/교통']"));
		downscroll(By.xpath(categoryXPath2 + "//*[@text='쇼핑']"));
		downscroll(By.xpath(categoryXPath2 + "//*[@text='비즈니스/금융']"));
		downscroll(By.xpath(categoryXPath2 + "//*[@text='영어']"));
		downscroll(By.xpath(categoryXPath2 + "//*[@text='중국어/일본어']"));
		downscroll(By.xpath(categoryXPath2 + "//*[@text='키즈']"));
		downscroll(By.xpath(categoryXPath2 + "//*[@text='교육']"));
		downscroll(By.xpath(categoryXPath2 + "//*[@text='앱북/오디오북']"));
						
		result = "PASS";
	}
}