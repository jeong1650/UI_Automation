package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_GUH_00450 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-08-31
	 * @ ExpectedResult = 게임 추천 화면 > LG U+ 통신 판매업 신고번호 선택 시 LG U+ 공정위 사업자 정보 고지 화면 이동
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 웹 기본앱 설정 팝업만 확인 / LG단말 아이콘 대응
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_GUH_00450() throws Exception {
		TCID = "OSC700_01_Home_00450 LG U+ 통신 판매업 신고번호 선택";
		result = "FAIL";
		size = driver.manage().window().getSize();

		popupCheck();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_game").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/btn_game").isSelected());
		
		assertEquals("통신판매업신고 : 제2015-서울용산-00481호", downscroll(By.id("com.skt.skaf.A000Z00040:id/tv_seller_info_uplus")).getText());
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/tv_seller_info_uplus").click();
		
		Thread.sleep(3000);
		try {
			driver.findElementById("android:id/icon").isDisplayed();
		} catch(Exception e) {
			try {
				driver.findElementById("com.lge:id/icon_lg").isDisplayed();
			} catch(Exception ee) {
				try {
					driver.findElementByXPath("//*[@package='com.sec.android.app.sbrowser']").isDisplayed();
				} catch(Exception eee) {
					driver.findElementByXPath("//*[@package='com.android.chrome']").isDisplayed();
				}
			}
		}
		driver.navigate().back();
		
		result = "PASS";

	}
}