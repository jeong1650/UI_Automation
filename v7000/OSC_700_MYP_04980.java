package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_MYP_04980 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-11
	 * @ ExpectedResult = 마이페이지 > 계정관리 > 이용해지
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MYP_04980() throws Exception {
		TCID = "OSC700_04_설정_04980 이용해지";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();
				
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my_layout").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my").isSelected());
		
		downscroll(By.id("com.skt.skaf.A000Z00040:id/menu_manage_account")).click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/account_withdrawal").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_up_indicator").isDisplayed();
		assertEquals("이용해지", driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_title").getText());
		
		assertEquals("해지하시면 모든 정보와 구매내역이\n" + 
				"삭제되고 복구되지 않습니다.\n" + 
				"신중하게 결정해 주세요.", driver.findElementById("com.skt.skaf.A000Z00040:id/withdrawal_info_desc1").getText());
		
		driver.findElementByXPath("//*[@text='보유 쿠폰']").isDisplayed();
		driver.findElementByXPath("//*[@text='보유 원스토어 캐쉬']").isDisplayed();
		driver.findElementByXPath("//*[@text='보유 게임 캐쉬']").isDisplayed();
		driver.findElementByXPath("//*[@text='보유 북스 캐쉬']").isDisplayed();
		driver.findElementByXPath("//*[@text='보유 북스 포인트']").isDisplayed();
		
		
		downscroll(By.xpath("//*[@text='1. 회원정보 및 잔여 쿠폰/캐쉬 삭제']"));
		downscroll(By.xpath("//*[@text='보유하신 쿠폰과 캐쉬는 이용해지 즉시 모두 소멸됩니다. 유효기간이 남아 있는 현금형 캐쉬(이용자가 대가를 지급하여 발행된 캐쉬)는 환급받으실 수 있습니다. 캐쉬 환급 신청은 반드시 회원 탈퇴 전에 신청하셔야 하며, 탈퇴 후에는 캐쉬가 소멸되어 환급이 불가능합니다.\n" + 
				"환급 대상 : 유효기간이 남아있는 현금형 캐쉬\n" + 
				"환급 신청 : 원스토어 앱 내 이용해지 페이지 또는 고객센터에서 환급 신청\n" + 
				"환급 절차 : 잔여 현금형 캐쉬 확인 후 신청한 계좌로 입금']"));
		
		downscroll(By.xpath("//*[@text='2. 서비스의 정보 삭제']"));
		downscroll(By.xpath("//*[@text='유/무료 콘텐츠 구매내역은 이용해지 시 모두 삭제됩니다. 회원님의 구매이력과 고객지원에 필요한 정보는 ‘개인정보처리방침’에 따라 일정기간 보관 뒤 삭제됩니다.']"));
		
		downscroll(By.xpath("//*[@text='3. 불량이용 및 이용제한에 관한 기록 1개월 동안 보관']"));
		downscroll(By.xpath("//*[@text='개인정보처리방침에 따라 불량이용 및 이용제한에 관한 기록은 1개월 동안 삭제되지 않고 보관됩니다.']"));
		
		downscroll(By.xpath("//*[@text='4. 기존 다운로드 상품 이용 불가']"));
		downscroll(By.xpath("//*[@text='휴대기기에 다운로드한 상품은 이용해지 후 사용이 제한될 수 있습니다.']"));
		
		assertEquals("이용해지", downscroll(By.id("com.skt.skaf.A000Z00040:id/withdrawal_button")).getText());
		
		result = "PASS";

	}
}