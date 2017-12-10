package invoice;

/**
 * 請求書のデータを管理する
 */
public class Invoice {
    // 契約者電話番号
    private String ownerTelNumber = null;

    // 基本料金
    private int basicCharge = 0;

    // 通話料金
    private int callCharge = 0;

    // 変数を初期化する
    public void clear() {
        ownerTelNumber = null;
        basicCharge = 0;
        callCharge = 0;
    }

    // 加入者電話番号を設定する
    public void setOwnerTelNumber(String ownerTelNumber) {
        this.ownerTelNumber = ownerTelNumber;
    }

    // 加入者電話番号を取り出す
    public String getOwnerTelNumber() {
        return ownerTelNumber;
    }

    // 基本料金を設定する
    public void setBasicCharge(int basicCharge) {
        this.basicCharge = basicCharge;
    }

    // 基本料金を取り出す
    public int getBasicCharge() {
        return basicCharge;
    }

    // 通話料金を加算する
    public void addCallCharge(int callCharge) {
        this.callCharge += callCharge;
    }

    // 通話料金を取り出す
    public int getCallCharge() {
        return callCharge;
    }

}
