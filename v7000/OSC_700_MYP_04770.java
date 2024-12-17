package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_MYP_04770 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-11
	 * @ ExpectedResult = 마이페이지 > 계정관리 > OK캐쉬백 포인트 > 카드 저장 동의 전문보기 항목 제공
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MYP_04770() throws Exception {
		TCID = "OSC700_04_설정_04770 OK캐쉬백 포인트 (OK캐쉬백 카드 등록 되어있지 않은 경우)";
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
		driver.findElementById("com.skt.skaf.OA00018282:id/cb_agree_give_private_info").isDisplayed();
		assertTrue(driver.findElementById("com.skt.skaf.OA00018282:id/cb_agree_give_private_info").getAttribute("checked").equals("false"));
		assertEquals("OK캐쉬백 카드번호 저장에 동의합니다.", driver.findElementById("com.skt.skaf.OA00018282:id/agreeInfo").getText());
		assertEquals("전문보기", driver.findElementById("com.skt.skaf.OA00018282:id/showFullDocs").getText());
		
		assertEquals("확인", driver.findElementById("com.skt.skaf.OA00018282:id/btn_confirm").getText());
		
		Thread.sleep(3000);
		driver.navigate().back();
		
		Thread.sleep(3000);
		driver.navigate().back();
		
				
		result = "PASS";

	}
}