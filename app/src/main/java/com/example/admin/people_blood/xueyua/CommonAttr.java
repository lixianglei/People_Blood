package com.example.admin.people_blood.xueyua;

/**
 * 鏀剧疆涓�浜涘父鐢ㄧ殑甯镐寒
 * 
 * @author yangyu
 */
public class CommonAttr {

	/**
	 * 琛�鍘嬬殑鍥哄畾id銆傚拰鍛戒护銆�
	 * 
	 * @author yangyu
	 */
	public static class Sphygmomanometer {

		// /**
		// * 寮�濮嬫祴璇曡鍘嬶紱
		// */
		// public static final byte[] START_MEASURE = {(byte) 0xFA, 0x20, 0x00,
		// (byte) 0xE6, (byte) 0xFA};
		// /**
		// * 鍋滄娴嬭瘯琛�鍘嬶紱
		// */
		// public static final byte[] STOP_MEASURE = {(byte) 0xFA, 0x20, 0x01,
		// (byte) 0xE5, (byte) 0xFA};
		// /**
		// * 鑾峰彇璁惧淇℃伅
		// */
		// public static final byte[] GET_DEV_INFO = {(byte) 0xFA, 0x01, 0x05,
		// (byte) 0xFA};
		// /**
		// * 鑾峰彇褰撳墠鐢甸噺
		// */
		// public static final byte[] GET_BATTERY = {(byte) 0xFA, 0x02, 0x04,
		// (byte) 0xFA};
		// /**
		// * 鑾峰彇缁撴灉
		// */
		// public static final byte[] GET_REUSLT = { (byte) 0xFA, 0x21, (byte)
		// 0xE5, (byte) 0xFA };
// 让这个机器动起来
		public static final byte[] START_MEASURE = { (byte) 0xEB, 0x20, 0x00,
				(byte) 0xf5, (byte) 0xEB };
		/**
		 * 鍋滄娴嬭瘯琛�鍘嬶紱
		 */
		public static final byte[] STOP_MEASURE = { (byte) 0xEB, 0x20, 0x01,
				(byte) 0xf4, (byte) 0xEB };
		/**
		 * 鑾峰彇璁惧淇℃伅
		 */
		public static final byte[] GET_DEV_INFO = { (byte) 0xEB, 0x01, 0x14,
				(byte) 0xEB };
		/**
		 * 鑾峰彇褰撳墠鐢甸噺
		 */
		public static final byte[] GET_BATTERY = { (byte) 0xEB, 0x02, 0x13,
				(byte) 0xEB };
		/**
		 * 鑾峰彇缁撴灉
		 */
		public static final byte[] GET_REUSLT = { (byte) 0xEB, 0x21,
				(byte) 0xf4, (byte) 0xEB };

		/* ----------------------------- */

		/**
		 * 涓庤鍘嬭浜や簰鏃剁殑Service锛�
		 */
		public static final String SERVICE_UUID = "00001810-0000-1000-8000-00805f9b34fb";
		/**
		 * 鍙戦�佸懡浠ょ殑閫氶亾锛�
		 */
		public static final String SERVICE_CHARACTERISTIC_SEND = "00002a50-0000-1000-8000-00805f9b34fb";
		/**
		 * 鎺ュ彈鏁版嵁鐨勯�氶亾锛�
		 */
		public static final String SERVICE_CHARACTERISTIC_RECEIVE = "00002a51-0000-1000-8000-00805f9b34fb";

	}

	/**
	 * @author yangyu
	 */
	public static class WeightScale {
		/**
		 * 鑾峰彇钃濈墮鐨勭‖浠朵俊鎭湇鍔�
		 */
		public static final String BLE_DEVICE_INFO_SERVICE = "0000180a-0000-1000-8000-00805f9b34fb";
		/**
		 * 鑾峰彇钃濈墮鐨勭‖浠朵俊鎭鍙�
		 */
		public static final String BLE_DEVICE_INFO_CHAR = "00002a23-0000-1000-8000-00805f9b34fb";
		/**
		 * 鍥哄畾鐨勮摑鐗欐暟鎹湇鍔￠�氶亾
		 */
		public static final String BLE_SWAP_DATA_SERVICE = "0000ffe0-0000-1000-8000-00805f9b34fb";
		/**
		 * 鍥哄畾鐨勮摑鐗欐暟鎹氦鎹㈢鍙�
		 */
		public static final String BLE_SWAP_DATA_CHAR = "0000ffe1-0000-1000-8000-00805f9b34fb";

		/* ------------------------------ */

		/**
		 * 娴嬭瘯鏁版嵁鎴愬姛 1 08H 05H 02H A5H 01H-05H * WeighthL BFH BFL WatrerH WatrerL
		 */
		public static byte[] getTestSuc = { (byte) 0x08, (byte) 0x05,
				(byte) 0x02, (byte) 0xa5, (byte) 0x01 };
		/**
		 * 涓婁紶褰撳墠娴嬮噺鏁版嵁 1 09H 05H 02H B1H 00H/01H * WeighthL BFH BFL WatrerH WatrerL
		 */
		public static byte[] getUserInfoFromScale1 = { (byte) 0x09,
				(byte) 0x05, (byte) 0x02, (byte) 0xb1, (byte) 0x01 };
		/**
		 * 涓婁紶褰撳墠娴嬮噺鏁版嵁 2 09H 05H 02H B1H 00H/01H * WeighthL BFH BFL WatrerH WatrerL
		 */
		public static byte[] getUserInfoFromScale2 = { (byte) 0x09,
				(byte) 0x05, (byte) 0x02, (byte) 0xb1, (byte) 0x02 };
	}

}
