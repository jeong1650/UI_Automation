package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_MYP_05700 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-14
	 * @ ExpectedResult = 마이페이지 > 고객센터 > 이메일 문의 > App/콘텐츠 선택 시 내용 영역 자동 입력
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MYP_05700() throws Exception {
		TCID = "OSC700_04_설정_05700 내용 영역 확인";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();
				
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my_layout").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my").isSelected());
		
		downscroll(By.id("com.skt.skaf.A000Z00040:id/menu_customer_center")).click();
		
		Thread.sleep(3000);
		downscroll(By.id("com.skt.skaf.A000Z00040:id/custom_email")).click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_cs_type_question_dropdown").click();
		
		Thread.sleep(3000);
		driver.findElementByXPath("//android.widget.CheckBox[@text='App/콘텐츠']").click();
		
		assertEquals(
				"1.상품명 :\n" + 
				"2.상품 회차 :\n" + 
				"3.오류 발생 경로: (경로 상세 기재)\n" + 
				"4.다운로드 시도 일시(날짜, 시간) :\n" + 
				"5.콘텐츠 오류 사항 : (발생 현상 및 팝업 문구 상세 기재)\n" + 
				"6.음원명/가수명/앨범명 : (Music 상품 문의 시 기재)\n" + 
				"7.외장메모리 사용여부 :\n" + 
				"8.콘텐츠 저장경로 : (환경설정 내 다운로드 설정에서 확인 가능)\n" + 
				"9.요청사항 :", 
				downscroll(By.id("com.skt.skaf.A000Z00040:id/cs_question_detail")).getText());
												
		result = "PASS";
	}
}