package service;

/**
 * 昼トク割引サービスの計算を管理する
 */
public class DayService extends TimeService {
    private static final int START_TIME = 8;
    private static final int END_TIME = 17;

    // 料金計算のための基礎情報
    private static final String SERVICE_CODE = "E1";
    private static final int BASIC_CHARGE = 200;

    /**
     * 昼トク割引対象時間かどうかを判定する
     */
    @Override
    public boolean isServiceTime(int hour) {
        if (isJoined()) {
            if ((hour >= START_TIME) && (hour <= END_TIME)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String getServiceCode() {
        return SERVICE_CODE;
    }

    @Override
    public int getDiscount() {
        // 5円引き
        return 5;
    }

    @Override
    public int getBasicCharge() {
        return BASIC_CHARGE;
    }

}
