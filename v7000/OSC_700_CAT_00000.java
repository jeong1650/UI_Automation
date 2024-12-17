package osc.v7000;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
// import org.openqa.selenium.By;

public class OSC_700_CAT_00000 extends OSC_Base_text {

	/*
	 * -----------------------------------------------------------------------------
	 * 
	 * @ Editor = Lim Hyeongsun
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_CAT_00000() throws Exception {
		TCID = " 이용해지 ";
		result = "FAIL";
		size = driver.manage().window().getSize();

		popupCheck();

		// 이용해지 후 재가입
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/actionbar_title_layout").click();

		Thread.sleep(3000);
		String member1 = driver.findElementById("com.skt.skaf.A000Z00040:id/navi_user_id").getText();

		Thread.sleep(3000);
		driver.findElementByXPath("//android.widget.TextView[@text='계정 관리']").click();

		Thread.sleep(3000);
		driver.findElementByXPath("//android.widget.TextView[@text='이용해지']").click();

		Thread.sleep(3000);
		assertEquals("이용해지", driver.findElementById("com.skt.skaf.A000Z00040:id/action_bar_tv_title").getText());

		Thread.sleep(3000);
		String cash1 = driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[2]")
				.getText();
		System.out.println("보유 원스토어 캐쉬 = " + cash1);
		String cash2 = driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.TextView[2]")
				.getText();
		System.out.println("보유 게임 캐쉬 = " + cash2);
		String cash3 = driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.TextView[2]")
				.getText();
		System.out.println("보유 북스 캐쉬 = " + cash3);
		String cash4 = "0P";

		Thread.sleep(3000);
		upSwipe(0.30);

		Thread.sleep(3000);
		String out = driver.findElementById("com.skt.skaf.A000Z00040:id/withdrawal_button").getText();

		Thread.sleep(3000);
		if (cash1.equals(cash4) && cash2.equals(cash4) && cash3.equals(cash4)) {
			System.out.println(out);
			assertEquals("이용해지", driver.findElementById("com.skt.skaf.A000Z00040:id/withdrawal_button").getText());

			Thread.sleep(3000);
			driver.findElementById("com.skt.skaf.A000Z00040:id/withdrawal_button").click();

			Thread.sleep(3000);
			driver.findElementByXPath("//android.widget.Button[@text='예']").click();

		} else {
			System.out.println(out);
			assertEquals("환급 확인 후 이용해지",
					driver.findElementById("com.skt.skaf.A000Z00040:id/withdrawal_button").getText());

			Thread.sleep(3000);
			driver.findElementById("com.skt.skaf.A000Z00040:id/withdrawal_button").click();

			Thread.sleep(3000);
			driver.findElementByXPath("//android.view.View[@text='환급여부 확인']").isDisplayed();

			Thread.sleep(3000);
			driver.findElementByXPath("//android.view.View[@text='이용해지']").click();

			Thread.sleep(3000);
			driver.findElementByXPath("//android.view.View[@text='해지하시면 모든 정보와 구매내역이 삭제되고 복구되지 않습니다. 해지하시겠습니까?']")
					.isDisplayed();

			Thread.sleep(3000);
			driver.findElementByXPath("//android.view.View[@text='예']").click();
		}

		Thread.sleep(3000);
		driver.findElementByXPath("//android.widget.TextView[@text='이용해지가 완료되었습니다.']").isDisplayed();
		Thread.sleep(2000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn").click();

		Thread.sleep(3000);
		driver.findElementByXPath("//android.widget.TextView[@text='휴대전화번호로 이용하기']").click();

		Thread.sleep(3000);
		boolean agree;
		agree = driver.findElementById("com.skt.skaf.OA00018282:id/agree").isEnabled();
		if (agree == false) {
			Thread.sleep(3000);
			driver.findElementById("com.skt.skaf.OA00018282:id/allagree").click();
			Thread.sleep(1500);
			agree = true;
			System.out.println("agree Complete");
		}

		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.OA00018282:id/agree").click();

		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.OA00018282:id/buttonConfirm").click();

		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/layout_start").click();

		popupCheck();

		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/actionbar_title_layout").click();

		Thread.sleep(3000);
		String member2 = driver.findElementById("com.skt.skaf.A000Z00040:id/navi_user_id").getText();

		Thread.sleep(3000);
		assertEquals(member1, member2);

		Thread.sleep(3000);
		driver.navigate().back();

		result = "PASS";

	}
}