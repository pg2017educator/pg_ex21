package service;

abstract class TimeService implements Service {
    // 割引サービスに加入しているか
    private boolean joined = false;

    /**
     * 変数を初期化する
     */
    @Override
    public void clear() {
        joined = false;
    }

    /**
     * 割引サービスに加入済み
     */
    public void joined() {
        joined = true;
    }

    /**
     * 割引サービスに加入しているか
     * @return 割引サービスに加入していればtrue
     */
    public boolean isJoined() {
        return joined;
    }

    /**
     * 割引対象時間かどうかを判定する
     * @param hour 通話開始時間
     * @return 該当する割引サービスに加入していて、割引対象時間ならばtrue
     */
    abstract public boolean isServiceTime(int hour);

    /**
     * 該当する割引サービスに加入しているかを判定する。
     * 加入していれば、内部のフラグがたつ。
     */
    @Override
    public void checkService(Record record) {
        if (getServiceCode().equals(record.getServiceCode())) {
            joined();
        }
    }

    /**
     * サービスコード
     * @return サービスコード
     */
    abstract public String getServiceCode();

    // 単価を計算する
    @Override
    public int calcUnitPrice(Record record, int unitPrice) {
        int hour = record.getStartHour();
        if (isServiceTime(hour)) {
            // 割引
            unitPrice -= getDiscount();
        }
        return unitPrice;
    }

    // 割引額を取り出す
    abstract public int getDiscount();

    //	基本料金を計算する
    @Override
    public int calcBasicCharge(int basicCharge) {
        if (isJoined()) {
            basicCharge += getBasicCharge();
        }
        return basicCharge;
    }

    // 基本料金を取り出す
    abstract public int getBasicCharge();
}
