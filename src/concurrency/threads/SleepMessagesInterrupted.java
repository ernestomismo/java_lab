package concurrency.threads;

public class SleepMessagesInterrupted {

	public static void main(String[] args) {

		MessageLoop messagesThread = new MessageLoop();
		messagesThread.start();

		while (messagesThread.isAlive()){
			if (messagesThread.currentState.equals("stop")){
				messagesThread.interrupt();
			}
		}
	}
	
	private static class MessageLoop extends Thread {
		
		public String currentState = "";
		
		public void run() {
			String importantInfo[] = { "Mares eat oats", "stop", "Does eat oats", "Little lambs eat ivy",
					"A kid will eat ivy too" };
			try {
				for (int i = 0; i < importantInfo.length; i++) {
					// Pause for 4 seconds
					Thread.sleep(2000);
					// Print a message
					threadMessage(importantInfo[i]);
				}
			} catch (InterruptedException e) {
				threadMessage("I wasn't done!");
			}
		}
		
		void threadMessage(String message) {
			String threadName = Thread.currentThread().getName();
			System.out.format("%s: %s%n", threadName, message);
			currentState = message;
		}
	}

}
