package osc.v7000;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_MKT_03050 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-28
	 * @ ExpectedResult = 사전예약 > 하단 유의사항 영역 정상 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MKT_03050() throws Exception {
		TCID = "OSC700_08_마케팅_03050 하단 유의사항 영역";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();
				
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_game").click();

		Thread.sleep(3000);
		driver.findElementByXPath("//android.widget.Button[@text='신규']").click();
		
		Thread.sleep(3000);
		downscroll(By.xpath("//*[@text='사전예약']")).click();
		
		Thread.sleep(5000);
		downscroll(By.xpath("//*[@text='꼭 알아두세요']"));
		downscroll(By.xpath("//*[@text='사전예약 혜택은 ONE store 계정 당 1회 수령 가능합니다. (동일 계정 내 여러 개의 단말로 신청해도 계정 당 1회만 지급됩니다.)']"));
		downscroll(By.xpath("//*[@text='청소년 이용불가 게임은 성인인증을 하신 회원에 한해서 사전예약 신청되며, 게임 출시일까지 성인인증상태를 유지하여야 혜택이 정상 지급됩니다. (성인 인증방법 : 마이 > 계정관리 > 성인인증 > 인증)']"));
		downscroll(By.xpath("//*[@text='사전예약 신청 게임 중 일부는 신청 시 출시 후 자동 다운로드하며, 자동 다운로드 대상 게임 여부는 개별 페이지에서 확인하실 수 있습니다.']"));
		downscroll(By.xpath("//*[@text='더보기']"));
		
		result = "PASS";
	}
}