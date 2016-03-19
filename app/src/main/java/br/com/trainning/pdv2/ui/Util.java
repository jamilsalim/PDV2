package br.com.trainning.pdv2.ui;

import android.os.Build;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.UUID;

/**
 * Created by android on 12/03/2016.
 */
public class Util {
    public static String getCurrencyValue(double valor){
        DecimalFormat ptBR = new DecimalFormat("#,##0.00");
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(new Locale("pt", "BR"));
        symbols.setDecimalSeparator(',');
        symbols.setGroupingSeparator(' ');
        ptBR.setDecimalFormatSymbols(symbols);
        if(valor>0.0d) {
            return " R$ " + ptBR.format(valor);
        }else{
            return "";
        }
    }

    public static String getFormatedCurrency(String value){
        NumberFormat currency = NumberFormat.getCurrencyInstance();

        if(value==null){
            value="0.00";
        }
        return currency.format(Double.parseDouble(value));
    }

    public static String getUniquePsuedoID() {

        String m_szDevIDShort = "35" + (Build.BOARD.length() % 10) + (Build.BRAND.length() % 10) + (Build.CPU_ABI.length() % 10) + (Build.DEVICE.length() % 10) + (Build.MANUFACTURER.length() % 10) + (Build.MODEL.length() % 10) + (Build.PRODUCT.length() % 10);
        String serial = null;
        try {
            serial = android.os.Build.class.getField("SERIAL").get(null).toString();
            return new UUID(m_szDevIDShort.hashCode(), serial.hashCode()).toString();
        } catch (Exception exception) {
            serial = "PDV"; // TODO put some default value here.
        }

        return new UUID(m_szDevIDShort.hashCode(), serial.hashCode()).toString();
    }

}
