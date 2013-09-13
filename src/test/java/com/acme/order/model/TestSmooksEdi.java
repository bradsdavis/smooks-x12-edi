package com.acme.order.model;

import java.io.StringWriter;
import java.util.Date;

import org.junit.Test;


public class TestSmooksEdi {

	@Test
	public void testExecution() throws Exception {
		InvoiceFactory orderFactory = InvoiceFactory.getInstance();

		Invoice invoice = new Invoice();
		TransactionSetHeader tsh = new TransactionSetHeader();
		tsh.setTransactionSetControlNumber("ABC");
		tsh.setTransactionSetIdentifier("XYZ");
		invoice.setTransactionSetHeader(tsh);
		
		
		BeginningSegment bs = new BeginningSegment();
		bs.setInvoiceDate(new Date());
		invoice.setBeginningSegment(bs);
		
		StringWriter sw = new StringWriter();
		
		orderFactory.toEDI(invoice, sw);
		
		System.out.println(sw.toString());
	}
}
