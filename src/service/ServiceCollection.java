package service;

/**
 * 複数サービスの計算を管理する
 */
public class ServiceCollection implements Service {
    private Service[] services = {
            new DayService(),
            new NightService(),
            new FamilyService()
    };

    /**
     * 内部の変数を初期化する
     */
    @Override
    public void clear() {
        for (Service service : services) {
            service.clear();
        }
    }

    /**
     * 割引サービスに加入しているかを検査する
     * @param record レコード
     */
    @Override
    public void checkService(Record record) {
        for (Service service : services) {
            service.checkService(record);
        }
    }

    /**
     * 1分当たりの通話単価を計算する
     * @param record レコード
     * @param unitPrice 元の通話単価
     * @return 単価
     */
    @Override
    public int calcUnitPrice(Record record, int unitPrice) {
        for (Service service : services) {
            unitPrice = service.calcUnitPrice(record, unitPrice);
        }
        return unitPrice;
    }

    /**
     * 基本料金を計算する
     * @param basicCharge 元の基本料金
     * @return 基本料金
     */
    @Override
    public int calcBasicCharge(int basicCharge) {
        for (Service service : services) {
            basicCharge = service.calcBasicCharge(basicCharge);
        }
        return basicCharge;
    }

}
