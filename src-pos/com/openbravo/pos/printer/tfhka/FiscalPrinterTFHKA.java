package com.openbravo.pos.printer.tfhka;

import javax.swing.JComponent;

import com.openbravo.pos.printer.DeviceFiscalPrinter;

import tfhka.PrinterException;
import tfhka.ve.Tfhka;

public class FiscalPrinterTFHKA implements DeviceFiscalPrinter {

	Tfhka test ; 
	public FiscalPrinterTFHKA(String sFiscalParam1) {
		test = new Tfhka(sFiscalParam1);
		if(test.IndPuerto)
			System.out.println("Conectada Satisfactoriamente");
	}

	@Override
	public String getFiscalName() {
		return "Test The Factory TFHKA";
	}

	@Override
	public JComponent getFiscalComponent() {
		return null;
	}

	@Override
	public void beginReceipt() {
//		try {
//			test.SendCmd("500000");
//		} catch (PrinterException e) {
//			System.out.println("Comando no enviado");
//			e.printStackTrace();
//		}
		System.out.println("beginReceipt()");
	}

	@Override
	public void endReceipt() {
//		try {
//			test.SendCmd("6");
//		} catch (PrinterException e) {
//			System.out.println("Comando no enviado");
//			e.printStackTrace();
//		}
		System.out.println("endReceipt()");
	}

	@Override
	public void printLine(String sproduct, double dprice, double dunits, int taxinfo) {
		try {
			test.SendCmd("CMD" + dprice + dunits + sproduct);
		} catch (PrinterException e) {
			System.out.println("Comando no enviado");
			e.printStackTrace();
		}
	}

	@Override
	public void printMessage(String smessage) {
		System.out.println("printMessage()");
	}

	@Override
	public void printTotal(String sPayment, double dpaid) {
		try {
			test.SendCmd("101");
		} catch (PrinterException e) {
			System.out.println("Comando no enviado");
			e.printStackTrace();
		}
	}

	@Override
	public void printZReport() {
		System.out.println("printZReport()");
	}

	@Override
	public void printXReport() {
		System.out.println("printXReport()");
	}

}
