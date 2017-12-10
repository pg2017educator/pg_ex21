package service;

/**
 * 夜トク割引サービスの計算を管理する
 */
public class NightService extends TimeService {
    private static final int START_TIME = 23;
    private static final int END_TIME = 5;

    // 料金計算のための基礎情報
    private static final String SERVICE_CODE = "E2";
    private static final int BASIC_CHARGE = 500;

    /**
     * 夜トク割引対象時間かどうかを判定する
     */
    public boolean isServiceTime(int hour) {
        if (isJoined()) {
            if (((hour >= START_TIME) && (hour < 24)) || (hour <= END_TIME)) {
                return true;
            }
        }
        return false;
    }

    public String getServiceCode() {
        return SERVICE_CODE;
    }

    public int getDiscount() {
        // 10円引き
        return 10;
    }

    public int getBasicCharge() {
        return BASIC_CHARGE;
    }
}
