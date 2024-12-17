package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_SRH_00250 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-16
	 * @ ExpectedResult = 메인 > 검색 > 카테고리 영역 정상 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_SRH_00250() throws Exception {
		TCID = "OSC700_05_검색_00250 카테고리 영역";
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
		
		assertEquals("원스토어 북스 바로가기", downscroll(By.id("com.skt.skaf.A000Z00040:id/search_move_books_title")).getText());
				
		result = "PASS";
	}
}