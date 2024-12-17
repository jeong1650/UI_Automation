package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_MYP_00010 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-09
	 * @ ExpectedResult = 메인 > 마이페이지 정상 이동
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MYP_00010() throws Exception {
		TCID = "OSC700_04_MY_00010 마이페이지 선택";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();

		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my_layout").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my").isSelected());
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/appbar_noti_icon_actionlayout").isDisplayed();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/account_layout").isDisplayed();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/menu_my_coupon").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/menu_game_cash").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/menu_onestore_cash").isDisplayed();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_ebook_cash").isDisplayed();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/menu_update").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/menu_download").isDisplayed();
		
		assertEquals("구매내역", downscroll(By.id("com.skt.skaf.A000Z00040:id/menu_purchase_list")).getText());
		assertEquals("고객센터", downscroll(By.id("com.skt.skaf.A000Z00040:id/menu_customer_center")).getText());
		assertEquals("계정관리", downscroll(By.id("com.skt.skaf.A000Z00040:id/menu_manage_account")).getText());
		assertEquals("공지사항", downscroll(By.id("com.skt.skaf.A000Z00040:id/menu_notice")).getText());
		assertEquals("설정", downscroll(By.id("com.skt.skaf.A000Z00040:id/menu_setting")).getText());
		assertEquals("이용안내", downscroll(By.id("com.skt.skaf.A000Z00040:id/menu_use_guide")).getText());
		
		result = "PASS";

	}
}