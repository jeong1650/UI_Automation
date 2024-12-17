package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_MYP_05380 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-14
	 * @ ExpectedResult = 마이페이지 > 고객센터 > [라이브 채팅] 선택 시 카카오톡 상담 화면 이동
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MYP_05380() throws Exception {
		TCID = "OSC700_04_설정_05380 [라이브 채팅] 선택";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();
				
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my_layout").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my").isSelected());
		
		downscroll(By.id("com.skt.skaf.A000Z00040:id/menu_customer_center")).click();
		
		Thread.sleep(3000);
		downscroll(By.id("com.skt.skaf.A000Z00040:id/custom_live_kakaotalk_chatting")).click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_up_indicator").isDisplayed();
		assertEquals("라이브 채팅", driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_title").getText());
		
		driver.findElementByXPath("//*[@text='상담일']").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/tv_consultant_date_for_kakaotalk_consultant").isDisplayed();
		
		driver.findElementByXPath("//*[@text='모델명']").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/tv_phone_model_name_for_kakaotalk_consultant").isDisplayed();
		
		assertEquals("휴대폰 번호", driver.findElementById("com.skt.skaf.A000Z00040:id/tv_field_mdn_or_id").getText());
		driver.findElementById("com.skt.skaf.A000Z00040:id/tv_phone_number_for_kakaotalk_consultant").isDisplayed();
		
		driver.findElementByXPath("//*[@text='문의 종류']").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_selector_question").isDisplayed();
		assertEquals("선택", driver.findElementById("com.skt.skaf.A000Z00040:id/selector_question").getText());
				
		driver.findElementByXPath("//*[@text='상세 항목']").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_selector_detail_item").isDisplayed();
		assertEquals("선택", driver.findElementById("com.skt.skaf.A000Z00040:id/selector_detail_item").getText());
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/checkbox").isDisplayed();
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/checkbox").getAttribute("checked").equals("false"));
		driver.findElementByXPath("//*[@text='개인정보 수집에 동의합니다.']").isDisplayed();
		
		driver.findElementByXPath("//*[@text='수집 항목 : 아이디, 휴대기기 정보(모델명, 번호, 번호가 없는 경우 MAC-Address, IMEI값, 루팅여부(Y/N)) "
				+ "회원의 문의/답변 내용에 포함된 개인정보 (서버/캐릭터명, 로그인 아이디와 같은 게임 내 정보 등)']").isDisplayed();
		driver.findElementByXPath("//*[@text='수집 목적 : 문의내역 확인과 답변 처리']").isDisplayed();
		driver.findElementByXPath("//*[@text='활용 기간 : 3년 보관 후 파기']").isDisplayed();
		driver.findElementByXPath("//*[@text='고객님은 동의를 거부하실 수 있으며, 동의 거부 시 라이브 채팅을 이용할 수 없습니다.']").isDisplayed();
		
		assertEquals("취소", driver.findElementById("com.skt.skaf.A000Z00040:id/btn_not_agree").getText());
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/ll_consult").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/kakaotalk_img").isDisplayed();
		assertEquals("상담하기", driver.findElementById("com.skt.skaf.A000Z00040:id/btn_consultation").getText());
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_up_indicator").click();
		
		Thread.sleep(3000);
		assertEquals("고객센터", driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_title").getText());
								
		result = "PASS";
	}
}