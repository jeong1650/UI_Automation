package osc.v7000;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_MKT_03060 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-28
	 * @ ExpectedResult = 사전예약 > 하단 유의사항 영역 > 더보기 선택 시 유의사항 전체 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MKT_03060() throws Exception {
		TCID = "OSC700_08_마케팅_03060 더보기 선택";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();
				
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_game").click();

		Thread.sleep(3000);
		driver.findElementByXPath("//android.widget.Button[@text='신규']").click();
		
		Thread.sleep(3000);
		downscroll(By.xpath("//*[@text='사전예약']")).click();
		
		Thread.sleep(3000);
		for(int i = 0; i <= 10; i++) {
			upSwipe(0.80);
		}
		
		Thread.sleep(5000);
		downscroll(By.xpath("//*[@text='꼭 알아두세요']"));
		downscroll(By.xpath("//*[@text='사전예약 혜택은 ONE store 계정 당 1회 수령 가능합니다. (동일 계정 내 여러 개의 단말로 신청해도 계정 당 1회만 지급됩니다.)']"));
		downscroll(By.xpath("//*[@text='청소년 이용불가 게임은 성인인증을 하신 회원에 한해서 사전예약 신청되며, 게임 출시일까지 성인인증상태를 유지하여야 혜택이 정상 지급됩니다. (성인 인증방법 : 마이 > 계정관리 > 성인인증 > 인증)']"));
		downscroll(By.xpath("//*[@text='사전예약 신청 게임 중 일부는 신청 시 출시 후 자동 다운로드하며, 자동 다운로드 대상 게임 여부는 개별 페이지에서 확인하실 수 있습니다.']"));
		
		downscroll(By.xpath("//*[@text='더보기']")).click();
		
		downscroll(By.xpath("//*[@text='Wi-Fi가 아닌 경우 가입하신 요금제에 따라 자동설치 시 ‘별도의 데이터 요금이 부과’될 수 있습니다. (Wi-fi 상태에서만 다운로드를 원하면 마이>설정>Wi-Fi에서만 다운로드를 설정해 주세요.)']"));
		downscroll(By.xpath("//*[@text='통신사 변경 시 기존 사전예약 내역이 취소될 수 있으며, 사전예약 혜택은 사전예약을 신청한 통신사 별로 상이할 수 있습니다.']"));
		downscroll(By.xpath("//*[@text='통신사에 가입되지 않은 단말이나 게임사의 정책에 의해 일부 단말에서는 사전예약 및 게임 이용이 어려울 수 있습니다.']"));
		downscroll(By.xpath("//*[@text='원스토어 탈퇴, 원스토어 로그인 계정(구글, 네이버, 페이스북, T store ID) 변경, 로그아웃, 기기삭제, 핸드폰번호 변경 등이 발생할 경우에는 사전예약이 취소될 수 있으며 사전예약 리워드 지급이 불가하니 유의하시기 바랍니다.']"));
		downscroll(By.xpath("//*[@text='개별 사전예약 이벤트는 회사의 내부 사정에 의해 별도의 고지 없이 변경 또는 조기종료 될 수 있습니다.']"));
		
		result = "PASS";
	}
}