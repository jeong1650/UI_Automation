package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_MYP_05460 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-14
	 * @ ExpectedResult = 마이페이지 > 고객센터 > 이메일 문의 화면 정상 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MYP_05460() throws Exception {
		TCID = "OSC700_04_설정_05460 이메일 문의";
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
		driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_up_indicator").isDisplayed();
		assertEquals("이메일 문의", driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_title").getText());
		
		driver.findElementByXPath("//*[@text='작성일']").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/cs_write_date").isDisplayed();
		
		driver.findElementByXPath("//*[@text='모델명']").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/cs_phone_type").isDisplayed();
		
		assertEquals("휴대폰 번호", driver.findElementById("com.skt.skaf.A000Z00040:id/cs_phone_number_title").getText());
		driver.findElementById("com.skt.skaf.A000Z00040:id/cs_phone_number").isDisplayed();
		
		driver.findElementByXPath("//*[@text='이메일']").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/cs_email_content").isDisplayed();
		driver.findElementByXPath("//*[@text='답변은 메일로 발송됩니다. 이메일 정보를 확인해 주세요.']").isDisplayed();

		driver.findElementByXPath("//*[@text='문의 종류']").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_cs_type_question_dropdown").isDisplayed();
		assertEquals("선택", driver.findElementById("com.skt.skaf.A000Z00040:id/cs_type_question_dropdown").getText());
		
		driver.findElementByXPath("//*[@text='상세 항목']").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_cs_type_question_detail_dropdown").isDisplayed();
		assertEquals("선택", driver.findElementById("com.skt.skaf.A000Z00040:id/cs_type_question_detail_dropdown").getText());
		
		downscroll(By.xpath("//*[@text='제목']"));
		driver.findElementById("com.skt.skaf.A000Z00040:id/cs_etc_text").isDisplayed();
		assertEquals("서비스/콘텐츠 오류인 경우 서비스/콘텐츠 명,  발생시간,  "
				+ "오류발생채널을 알려주시면 더욱 신속한 처리가 가능합니다.", downscroll(By.id("com.skt.skaf.A000Z00040:id/cs_etc_text_desc")).getText());
		
		downscroll(By.xpath("//*[@text='상품명']"));
		driver.findElementById("com.skt.skaf.A000Z00040:id/cs_question_content_title").isDisplayed();
		
		downscroll(By.xpath("//*[@text='발생일자']"));
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_cs_question_date").isDisplayed();
		
		downscroll(By.xpath("//*[@text='발생시간']"));
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_cs_question_time").isDisplayed();
		
		downscroll(By.xpath("//*[@text='발생채널']"));
		assertEquals("예) 휴대기기, 웹 등", driver.findElementById("com.skt.skaf.A000Z00040:id/cs_question_channel").getText());
		
		downscroll(By.xpath("//*[@text='내용']"));
		driver.findElementById("com.skt.skaf.A000Z00040:id/cs_question_detail").isDisplayed();
		
		downscroll(By.xpath("//*[@text='사진첨부']"));
		driver.findElementById("com.skt.skaf.A000Z00040:id/cs_button_attach").isDisplayed();
		
		downscroll(By.id("com.skt.skaf.A000Z00040:id/checkbox"));
		driver.findElementByXPath("//*[@text='개인정보 수집에 동의합니다.']").isDisplayed();
		
		downscroll(By.xpath("//*[@text='수집 항목 : 아이디, 이메일, 휴대기기 정보"
				+ "(모델명, 원스토어 필수 프로그램 버전 및 OS, UUID, 번호, 번호가 없는 경우 MAC-Address, IMEI값, 루팅여부(Y/N)) "
				+ "회원의 문의/답변 내용에 포함된 개인정보 (서버/캐릭터명, 로그인 아이디와 같은 게임 내 정보 등)']"));
		downscroll(By.xpath("//*[@text='수집 목적 : 문의내역 확인과 답변 처리']"));
		downscroll(By.xpath("//*[@text='활용 기간 : 3년 보관 후 파기']"));
		downscroll(By.xpath("//*[@text='고객님은 동의를 거부하실 수 있으며, 동의 거부 시 이메일 문의를 이용할 수 없습니다.']"));
		
		assertEquals("취소", downscroll(By.id("com.skt.skaf.A000Z00040:id/cs_button_cancel")).getText());
		assertEquals("확인", driver.findElementById("com.skt.skaf.A000Z00040:id/cs_button_confirm").getText());
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/cs_button_cancel").click();
				
		Thread.sleep(3000);
		assertEquals("고객센터", driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_title").getText());
														
		result = "PASS";
	}
}