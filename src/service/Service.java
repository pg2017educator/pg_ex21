package service;

/**
 * サービスの共通インタフェース
 */
public interface Service {
    /**
     * 内部の変数を初期化する
     */
    void clear();

    /**
     * 割引サービスに加入しているかを検査する
     * @param record レコード
     */
    void checkService(Record record);

    /**
     * 1分当たりの通話単価を計算する
     * @param record レコード
     * @param unitPrice 元の通話単価
     * @return 単価
     */
    int calcUnitPrice(Record record, int unitPrice);

    /**
     * 基本料金を計算する
     * @param basicCharge 元の基本料金
     * @return 基本料金
     */
    int calcBasicCharge(int basicCharge);

}
