package alexey.gritsenko.application.report.impl;

import alexey.gritsenko.application.models.InvoiceItem;
import alexey.gritsenko.application.report.InvoiceFormGenerator;
import alexey.gritsenko.application.report.TableStringUtils;
import alexey.gritsenko.application.repository.InvoiceRepository;



public class InvoiceBodyFormGenerator implements InvoiceFormGenerator {
    private final int productNameColumnWidth;
    private final int productCostColumnWidth;
    private final TableStringUtils tableStringUtils;
    private final InvoiceRepository invoiceRepository;
    public InvoiceBodyFormGenerator(int productNameColumnWidth,
                                    int productCostColumnWidth,
                                    TableStringUtils tableStringUtils,
                                    InvoiceRepository invoiceRepository) {
        this.productNameColumnWidth = productNameColumnWidth;
        this.productCostColumnWidth = productCostColumnWidth;
        this.tableStringUtils = tableStringUtils;
        this.invoiceRepository = invoiceRepository;
    }
    @Override
    public String[] getPartForm() {
        InvoiceItem[] invoiceItems = this.invoiceRepository.getArrayItems();
        String[] resultBody = new String[0];
        for (InvoiceItem item : invoiceItems) {
            String[] lines = this.tableStringUtils.createTableString(item.productName(),
                    this.productNameColumnWidth, String.valueOf(item.cost()), this.productCostColumnWidth);
            resultBody = this.tableStringUtils.concatenate(resultBody, lines);
        }
        return resultBody;
    }



}
