package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_MYP_04780 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-10-14
	 * @ ExpectedResult = 마이페이지 > 계정관리 > OK캐쉬백 포인트 > [전문보기] 선택 > 전문 보기 웹뷰 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MYP_04780() throws Exception {
		TCID = "OSC700_04_설정_04780 OK캐쉬백 카드번호 저장 동의 전문보기 선택 (OK캐쉬백 카드 등록 되어있지 않은 경우)";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();
				
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my_layout").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my").isSelected());
		
		downscroll(By.id("com.skt.skaf.A000Z00040:id/menu_manage_account")).click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/account_okcash_point").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.OA00018282:id/showFullDocs").click();
		
		Thread.sleep(3000);
		try {
			driver.findElementByXPath("//*[@text='이전페이지 OK캐쉬백 카드번호 저장 동의']").isDisplayed();
		} catch(Exception e) {
			driver.findElementByXPath("//*[@text='이전페이지']").isDisplayed();
			driver.findElementByXPath("//*[@text='OK캐쉬백 카드번호 저장 동의']").isDisplayed();
		}
		driver.findElementByXPath("//*[@text='수집하는 개인정보 항목']").isDisplayed();
		driver.findElementByXPath("//*[@text='OK캐쉬백 카드번호']").isDisplayed();
		
		driver.findElementByXPath("//*[@text='수집/ 이용목적']").isDisplayed();
		driver.findElementByXPath("//*[@text='OK캐쉬백 포인트 조회, 사용, 적립']").isDisplayed();
		
		driver.findElementByXPath("//*[@text='보유/ 이용기간']").isDisplayed();
		driver.findElementByXPath("//*[@text='고객탈퇴 또는 OK캐쉬백 카드번호를 삭제할 때까지']").isDisplayed();
		
		driver.findElementByXPath("//*[@text='고객님께서는 동의를 거부하실 권리가 있으며, 동의 거부 시에는 원스토어에서 OK캐쉬백 서비스를 정상적으로 이용하실 수 없습니다.']").isDisplayed();
						
		result = "PASS";

	}
}