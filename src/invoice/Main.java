package invoice;

import java.io.IOException;

import service.Record;
import service.ServiceCollection;

/**
 * 請求データ作成プログラム。
 *
 */
public class Main {
    // 料金計算のための基礎情報
    private static final int INITIAL_BASIC_CHARGE = 1000;
    private static final int INITIAL_CALL_UNIT_PRICE = 20;

    // 各レコードの先頭文字 (Record Code)
    private static final char RC_OWNER_INFO = '1';
    private static final char RC_SERVICE_INFO = '2';
    private static final char RC_CALL_LOG = '5';
    private static final char RC_SEPARATOR = '9';

    public static void main(String[] args) throws IOException {
        ServiceCollection service = new ServiceCollection();

        RecordReader reader = new RecordReader();
        InvoiceWriter writer = new InvoiceWriter();
        Invoice invoice = new Invoice();

        for (Record record = reader.read(); record != null; record = reader.read()) {
            char recordCode = record.getRecordCode();
            switch (recordCode) {
            case RC_OWNER_INFO:
                // 変数の初期化
                invoice.clear();
                service.clear();

                invoice.setOwnerTelNumber(record.getOwnerTelNumber());
                break;

            case RC_SERVICE_INFO:
                // 割引サービスに加入しているかを検査する
                service.checkService(record);
                break;

            case RC_CALL_LOG:
                // 単価を計算する
                int unitPrice = INITIAL_CALL_UNIT_PRICE;
                unitPrice = service.calcUnitPrice(record, unitPrice);

                // 1通話あたりの通話料を計算し、総通話料に加算する
                invoice.addCallCharge(unitPrice * record.getCallMinutes());
                break;

            case RC_SEPARATOR:
                // 基本料金の計算
                int basicCharge = INITIAL_BASIC_CHARGE;
                basicCharge = service.calcBasicCharge(basicCharge);
                invoice.setBasicCharge(basicCharge);

                // 集計結果の出力
                writer.write(invoice);
                break;

            default:
                throw new RuntimeException("未知のレコードコード[recordCode=" + recordCode + "]のため処理を中止しました。");
            }
        }
        writer.close();
        reader.close();
    }
}
