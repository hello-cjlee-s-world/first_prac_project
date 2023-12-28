package DaemonThread;

public class TestDaemonThread extends Thread implements Runnable{
	@Override
	public void run() {
	// 데몬 스레드인지 확인
		while(true) {
			try {				
				if(Thread.currentThread().isDaemon()) {
					System.out.println("Daemon Thread");
					Thread.sleep(500);
				} else {
					System.out.println("Normal Thread executing");
					Thread.sleep(500);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
				break;
			}
		}
	}
	public static void main(String[] args) {
//		Thread t1 = new TestDaemonThread();
//		Thread t2 = new TestDaemonThread();
		
		Thread t1 = new Thread(new TestDaemonThread());
		Thread t2 = new Thread(new TestDaemonThread());
		
		//t1 을 데몬으로 설정
		t1.setDaemon(true);
		// 스레드 시작
		t1.start();
//		t2.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// main 에서 setDaemon 으로 설정한 Thread 이외에 
		// 다른 실행명령이 있다면(t2 혹은 하기 System.out.println 같은)
		// 해당 명령이 끝나면 main 이 끝난것으로 간주해 daemon도 꺼진다.
		// 하지만 daemon thread 이외에 다른 실행 명령이 없다면 daemon은 유지된다.
		System.out.println("메인 스레드가 종료됩니다.");
	}
}
