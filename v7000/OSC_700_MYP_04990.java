package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_MYP_04990 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-11
	 * @ ExpectedResult = 마이페이지 > 계정관리 > MDN 회원 기본정보 안내영역 미노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MYP_04990() throws Exception {
		TCID = "OSC700_04_설정_04990 기본정보 안내 영역 확인 (MDN 회원)";
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
		
		assertTrue(driver.findElements(By.id("com.skt.skaf.A000Z00040:id/withdrawal_info_id")).size() == 0);
		
		result = "PASS";

	}
}