package service;

/**
 * 通話記録レコードの取り扱いを便利にするクラス
 */
public class Record {
    // 各レコードの情報 (Record Information)
    private static final int RI_OF_OWNER_TEL_NUMBER = 2;
    private static final int RI_OF_SERVICE_CODE = 2;
    private static final int RI_SZ_SERVICE_CODE = 2;
    private static final int RI_OF_SERVICE_OPTION = 5;

    private static final int RI_OF_CALL_START_TIME = 13;
    private static final int RI_SZ_HOUR = 2;

    private static final int RI_OF_CALL_MINUTE = 19;
    private static final int RI_SZ_CALL_MINUTE = 3;

    private static final int RI_OF_CALL_NUMBER = 23;

    private String record;

    public Record(String record) {
        this.record = record;
    }

    /**
     * 通話記録の文字列表現
     */
    public String toString() {
        return record;
    }

    /**
     * レコードコード
     * @return レコードコード
     */
    public char getRecordCode() {
        return record.charAt(0);
    }

    /**
     * 契約者の電話番号
     * @return 契約者の電話番号
     */
    public String getOwnerTelNumber() {
        return record.substring(RI_OF_OWNER_TEL_NUMBER);
    }

    /**
     * サービスコード
     * @return サービスコード
     */
    public String getServiceCode() {
        return record.substring(RI_OF_SERVICE_CODE, RI_OF_SERVICE_CODE + RI_SZ_SERVICE_CODE);
    }

    /**
     * サービスのオプション情報
     * @return サービスのオプション情報。オプション情報がない場合はnullを返す。
     */
    public String getServiceOption() {
        if (record.length() < RI_OF_SERVICE_OPTION) {
            return null;
        }
        return record.substring(RI_OF_SERVICE_OPTION);
    }

    /**
     * 通話開始時刻の時間
     * @return 通話開始時刻の時間
     */
    public int getStartHour() {
        return Integer.parseInt(record.substring(RI_OF_CALL_START_TIME, RI_OF_CALL_START_TIME + RI_SZ_HOUR));
    }

    /**
     * 通話時間
     * @return 通話時間
     */
    public int getCallMinutes() {
        return Integer.parseInt(record.substring(RI_OF_CALL_MINUTE, RI_OF_CALL_MINUTE + RI_SZ_CALL_MINUTE));
    }

    /**
     * 通話先電話番号
     * @return 通話先電話番号
     */
    public String getCallNumber() {
        return record.substring(RI_OF_CALL_NUMBER);
    }

}
