package lv.javaguru.java2.servlet.mvc;

import java.util.List;

/**
 * Created by Svetlana Titova on 04.10.2016.
 */
public interface CustomerExportComponent {
    CustomerExportResult export(List<String> customers_ids);
}
