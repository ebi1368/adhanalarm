package islam.adhanalarm;


import android.content.Context;
import android.os.PowerManager;


public class WakeLock {
	
	private static PowerManager.WakeLock wakeLock;

	public static void acquire(Context context) {
		if(wakeLock != null && wakeLock.isHeld()) {
			return;
		}

		PowerManager powerManager = (PowerManager)context.getSystemService(Context.POWER_SERVICE);

		wakeLock = powerManager.newWakeLock(PowerManager.SCREEN_DIM_WAKE_LOCK | PowerManager.ACQUIRE_CAUSES_WAKEUP, "Adhan Alarm Wake Lock");
		wakeLock.acquire();
	}

	public static void release() {
		if(wakeLock != null) {
			wakeLock.release();
			wakeLock = null;
		}
	}
}